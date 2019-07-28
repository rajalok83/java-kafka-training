package com.example.basicJavaKafka.lab6;

import com.example.basicJavaKafka.lab6.consumer.DeserializedConsumer;

public class Main {
    public static void main(String[] args) {
	// write your code here
        DeserializedConsumer cm  = new DeserializedConsumer("SerializedProducerTopic");
        cm.consume();
    }
}
