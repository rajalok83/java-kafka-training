package com.example.basicJavaKafka.lab5.producer.serializer;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

//Add jackson Annotation, Core & Databind library
public class EmployeeSerializer implements Serializer {
    @Override
    public void configure(Map map, boolean b) {
        System.out.println("I am in " + Thread.currentThread().getStackTrace()[1]);
    }

    @Override
    public byte[] serialize(String s, Object o) {
        System.out.println("I am in " + Thread.currentThread().getStackTrace()[1]);
        byte[] retVal = null;
        ObjectMapper om = new ObjectMapper();
        try {
            retVal = om.writeValueAsString(o).getBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retVal;
    }

    @Override
    public void close() {
        System.out.println("I am in " + Thread.currentThread().getStackTrace()[1]);
    }
}
