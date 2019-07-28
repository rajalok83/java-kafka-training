package com.example.basicJavaKafka.lab10.consumer;



import kafka.utils.ShutdownableThread;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Kafka Consumer with Example Java Application
 */
public class SimpleThreadedConsumer implements Runnable {
    private final KafkaConsumer<Integer,String> consumer;
    private final String topic;
    private final int partition;

    public static final String KAFKA_SERVER_URL = "localhost";
    public static final int KAFKA_SERVER_PORT = 9092;
    public static final String CLIENT_ID = "SampleConsumer0";

    public SimpleThreadedConsumer(String topic, int partition) {
        System.out.println("I am in "+Thread.currentThread().getStackTrace()[1]);
        //super("KafkaConsumerExample", false);
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_SERVER_URL + ":" + KAFKA_SERVER_PORT);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, CLIENT_ID);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.IntegerDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        consumer = new KafkaConsumer<>(props);
        this.topic = topic;
        this.partition = partition;
    }



    @Override
    public void run() {
        System.out.println("I am in "+Thread.currentThread().getStackTrace()[1]);
        TopicPartition topicPartition = new TopicPartition(this.topic, this.partition);
        List<TopicPartition> topics = Arrays.asList(topicPartition);
        consumer.assign(topics);
//        consumer.seekToBeginning(
//                Stream.of(new TopicPartition(this.topic, this.partition)).collect(toList()));
//        consumer.seek(new TopicPartition(this.topic, this.partition), 0);
        //consumer.subscribe(Collections.singletonList(this.topic));
        while(true) {
            ConsumerRecords<Integer, String> records = consumer.poll(100);
            for (ConsumerRecord<Integer, String> record : records) {
                System.out.println(Thread.currentThread().getName()+" Received message: (" + record.key() + ", " + record.value() + ") at offset " + record.offset());
            }
        }
    }
}