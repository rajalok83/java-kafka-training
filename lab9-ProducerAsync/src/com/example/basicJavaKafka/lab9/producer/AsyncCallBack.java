package com.example.basicJavaKafka.lab9.producer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

//This is Callback implementation
class AsyncCallBack implements Callback {

    private final long startTime;
    private final int key;
    private final String message;

    public AsyncCallBack(long startTime, int key, String message) {
        System.out.println("I am in "+Thread.currentThread().getStackTrace()[1]);
        this.startTime = startTime;
        this.key = key;
        this.message = message;
    }

    /**
     * onCompletion method will be called when the record sent to the Kafka Server has been acknowledged.
     *
     * @param metadata  The metadata contains the partition and offset of the record. Null if an error occurred.
     * @param exception The exception thrown during processing of this record. Null if no error occurred.
     */
    public void onCompletion(RecordMetadata metadata, Exception exception) {
        System.out.println("I am in "+Thread.currentThread().getStackTrace()[1]);
        long elapsedTime = System.currentTimeMillis() - startTime;
        if (metadata != null) {
            System.out.println(
                    "message(" + key + ", " + message + ") sent to partition(" + metadata.partition() +
                            "), " +
                            "offset(" + metadata.offset() + ") in " + elapsedTime + " ms");
        } else {
            exception.printStackTrace();
        }
    }
}