package com.example.basicJavaKafka.lab5;

import com.example.basicJavaKafka.lab5.producer.SerializedProducer;

public class Main {
    public static void main(String[] args) {
	// write your code here
        SerializedProducer sp  = new SerializedProducer("SerializedProducerTopic");
        sp.produce();
    }
}
