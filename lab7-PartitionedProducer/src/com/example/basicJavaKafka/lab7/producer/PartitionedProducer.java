package com.example.basicJavaKafka.lab7.producer;



import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.concurrent.ExecutionException;


public class PartitionedProducer {
    private final KafkaProducer<Integer, String> producer;
    private final String topic;
    public static final String KAFKA_SERVER_URL = "localhost";
    public static final int KAFKA_SERVER_PORT = 9092;

    public PartitionedProducer(String topic) {
        System.out.println("I am in " + Thread.currentThread().getStackTrace()[1]);
        Properties properties = new Properties();
        properties.put("bootstrap.servers", KAFKA_SERVER_URL + ":" + KAFKA_SERVER_PORT);
        //properties.put("client.id", CLIENT_ID);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        producer = new KafkaProducer<>(properties);
        this.topic = topic;
    }

    public void produce() {
        System.out.println("I am in " + Thread.currentThread().getStackTrace()[1]);
        for(int messageNo=0; messageNo<=2;  messageNo++){
        try {
            String msg = "Message "+messageNo;
            //ProducerRecord(topic, value);
            ProducerRecord pr =new ProducerRecord(topic, msg+"tv");
            //ProducerRecord(topic, key, value)
            //ProducerRecord pr =new ProducerRecord(topic, messageNo, msg+"tkv");
            //ProducerRecord(topic, partition, key, value)
            //ProducerRecord pr =new ProducerRecord(topic, messageNo, messageNo, msg+"tpkv");
            //ProducerRecord(topic, partition, timestamp, key, value)
            //ProducerRecord pr =new ProducerRecord(topic, messageNo, new Date().getTime(), messageNo, msg+"tptmkv");
            producer.send(pr).get();
            System.out.println("Sent message: (" + messageNo + ", " + "My Message " + msg + ")");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            // handle the exception
        }
        }
    }
}
