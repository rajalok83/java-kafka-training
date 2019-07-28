package com.example.basicJavaKafka.lab5.producer;

import com.example.basicJavaKafka.lab5.model.Employee;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.concurrent.ExecutionException;


public class SerializedProducer {
    private final KafkaProducer<Integer, Employee> producer;
    private final String topic;
    public static final String KAFKA_SERVER_URL = "localhost";
    public static final int KAFKA_SERVER_PORT = 9092;

    public SerializedProducer(String topic) {
        System.out.println("I am in " + Thread.currentThread().getStackTrace()[1]);
        Properties properties = new Properties();
        properties.put("bootstrap.servers", KAFKA_SERVER_URL + ":" + KAFKA_SERVER_PORT);
        //properties.put("client.id", CLIENT_ID);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
        properties.put("value.serializer", "com.example.basicJavaKafka.lab5.producer.serializer.EmployeeSerializer");
        producer = new KafkaProducer<>(properties);
        this.topic = topic;
    }

    public void produce() {
        System.out.println("I am in " + Thread.currentThread().getStackTrace()[1]);
        int messageNo = 1;
        //while (true) {
            Employee emp = new Employee(messageNo, 10, "abc", "xyz");
            try {
                producer.send(new ProducerRecord
                        (topic,
                                messageNo,
                                emp)).get();
                System.out.println("Sent message: (" + messageNo + ", " + "My Message " + emp.toString() + ")");
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                // handle the exception
            }
            //++messageNo;

        //}
    }
}
