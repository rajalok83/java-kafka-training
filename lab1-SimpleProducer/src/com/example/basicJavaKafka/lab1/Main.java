package com.example.basicJavaKafka.lab1;

import com.example.basicJavaKafka.lab1.producer.SimpleProducer;

public class Main {
    public static void main(String[] args) {
	// write your code here
        SimpleProducer sp  = new SimpleProducer("SimpleProducerTopic");
        sp.produce();
    }
}
