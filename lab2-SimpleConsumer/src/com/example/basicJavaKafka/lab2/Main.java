package com.example.basicJavaKafka.lab2;

import com.example.basicJavaKafka.lab2.consumer.SimpleConsumer;

public class Main {
    public static void main(String[] args) {
	// write your code here
        System.out.println("I am in "+Thread.currentThread().getStackTrace()[1]);
        SimpleConsumer cm  = new SimpleConsumer("SimpleProducerTopic");
        cm.consume();
    }
}
