package com.example.basicJavaKafka.lab9;

import com.example.basicJavaKafka.lab9.producer.SimpleProducer;

public class Main {
    public static void main(String[] args) {
        // write your code here
        System.out.println("I am in "+Thread.currentThread().getStackTrace()[1]);
        boolean isAsync = true;
        SimpleProducer sp = new SimpleProducer("SimpleProducerTopic", isAsync);
        sp.start();
    }
}
