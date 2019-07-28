package com.example.basicJavaKafka.lab6.consumer;
import com.example.basicJavaKafka.lab6.model.Employee;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.Properties;

public class DeserializedConsumer {
    private final KafkaConsumer<Integer, Employee> consumer;
    private final String topic;

    public static final String KAFKA_SERVER_URL = "localhost";
    public static final int KAFKA_SERVER_PORT = 9092;
    public static final String CLIENT_ID = "SampleConsumer";

    public DeserializedConsumer(String topic) {
        System.out.println("I am in " + Thread.currentThread().getStackTrace()[1]);
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_SERVER_URL + ":" + KAFKA_SERVER_PORT);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, CLIENT_ID);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.IntegerDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "com.example.basicJavaKafka.lab6.consumer.deserializer.EmployeeDeserializer");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        consumer = new KafkaConsumer<>(props);
        this.topic = topic;
    }

    public void consume() {
        System.out.println("I am in " + Thread.currentThread().getStackTrace()[1]);
        consumer.subscribe(Collections.singletonList(this.topic));
        ConsumerRecords<Integer, Employee> records = consumer.poll(1000);
        //int  batchId=0;
        //while(true) {
            System.out.println("I am in " + Thread.currentThread().getStackTrace()[1]+" in while");
            for (ConsumerRecord<Integer, Employee> record : records) {
                System.out.println("Received message: (" + record.key() + ", " + record.value().toString() + ") at offset " + record.offset());
            }
        //}
    }
}