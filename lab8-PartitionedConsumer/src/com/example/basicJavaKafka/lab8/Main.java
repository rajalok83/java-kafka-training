package com.example.basicJavaKafka.lab8;

import com.example.basicJavaKafka.lab8.consumer.PartitionedConsumer;


public class Main {
    //Start Zookeeper
    //.\zookeeper-server-start.bat ..\..\config\zookeeper.properties
    //Start Broker
    //.\kafka-server-start.bat ..\..\config\server.properties
    //Create 3 paritioned topic
    //.\kafka-topics.bat --zookeeper localhost:2181 --list
    //.\kafka-topics.bat --zookeeper localhost:2181 --describe --topic SerializedProducerTopic
    //.\kafka-topics.bat --zookeeper localhost:2181 --create --topic PartitionedProducer --partitions 3  --replication-factor 1
    //.\kafka-topics.bat --zookeeper localhost:2181 --describe --topic PartitionedProducer
    //Run simple consumer for all 3 partitions in different commmand prompt
    //.\kafka-run-class.bat kafka.tools.SimpleConsumerShell --broker-list localhost:9092 --topic PartitionedProducer --partition 0
    //.\kafka-run-class.bat kafka.tools.SimpleConsumerShell --broker-list localhost:9092 --topic PartitionedProducer --partition 1
    //.\kafka-run-class.bat kafka.tools.SimpleConsumerShell --broker-list localhost:9092 --topic PartitionedProducer --partition 2
    //Keep changing constructor and reexecute to see in consumer console which partition data lands into
    public static void main(String[] args) {
	// write your code here
        System.out.println("I am in "+Thread.currentThread().getStackTrace()[1]);
        PartitionedConsumer pp  = new PartitionedConsumer("PartitionedProducer");
        pp.consume();
    }
}
