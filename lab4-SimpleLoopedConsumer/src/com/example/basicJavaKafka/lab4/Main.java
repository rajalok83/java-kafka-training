package com.example.basicJavaKafka.lab4;

import com.example.basicJavaKafka.lab4.consumer.SimpleLoopedConsumer;

public class Main {
    public static void main(String[] args) {
	// write your code here
        SimpleLoopedConsumer cm  = new SimpleLoopedConsumer("SimpleProducerTopic");
        cm.consume();
    }
}
