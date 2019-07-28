package com.example.basicJavaKafka.lab3;

import com.example.basicJavaKafka.lab3.producer.SimpleLoopedProducer;

public class Main {
    public static void main(String[] args) {
	// write your code here
        SimpleLoopedProducer sp  = new SimpleLoopedProducer("SimpleProducerTopic");
        sp.produce();
    }
}
