package com.example.basicJavaKafka.lab3.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.concurrent.ExecutionException;


public class SimpleLoopedProducer extends Thread {
    private final KafkaProducer<Integer, String> producer;
    private final String topic;
    public static final String KAFKA_SERVER_URL = "localhost";
    public static final int KAFKA_SERVER_PORT = 9092;

    public SimpleLoopedProducer(String topic) {
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
        int messageNo = 1;
        while (true) {
            try {
                producer.send(new ProducerRecord<>
                        (topic,
                                messageNo,
                                "My Message " + messageNo)).get();
                System.out.println("Sent message: (" + messageNo + ", " + "My Message " + messageNo + ")");
                if(messageNo%10==0)
                    sleep(3000);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                // handle the exception
            }
            ++messageNo;

        }
    }
}
