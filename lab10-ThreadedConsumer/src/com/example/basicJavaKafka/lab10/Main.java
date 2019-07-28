package com.example.basicJavaKafka.lab10;

import com.example.basicJavaKafka.lab10.consumer.SimpleThreadedConsumer;
import javafx.beans.property.SimpleBooleanProperty;

import java.util.List;

public class Main {
    private List<SimpleThreadedConsumer> consumers;
    public static void main(String[] args) {
        System.out.println("I am in "+Thread.currentThread().getStackTrace()[1]);
	// write your code hereconsumers = new ArrayList<>();
           Main mn = new Main();
           mn.execute();
          }
    public void execute() {
        System.out.println("I am in "+Thread.currentThread().getStackTrace()[1]);
        for (int i = 0; i <= 3; i++) {
            Thread t = new Thread(new SimpleThreadedConsumer("PartitionedProducer", i));
            t.start();
        }
    }

}
