package com.example.basicJavaKafka.lab6.consumer.deserializer;

import com.example.basicJavaKafka.lab6.model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;


//Add Jackson Annotation, Core and Databind packages
public class EmployeeDeserializer implements Deserializer<Employee> {
    @Override
    public void configure(Map<String, ?> map, boolean b) {
        System.out.println("I am in " + Thread.currentThread().getStackTrace()[1]);
    }

    @Override
    public Employee deserialize(String s, byte[] bytes) {
        System.out.println("I am in " + Thread.currentThread().getStackTrace()[1]);
        ObjectMapper mapper = new ObjectMapper();
        Employee emp = null;
        try {
            emp = mapper.readValue(bytes, Employee.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emp;
    }

    @Override
    public void close() {
        System.out.println("I am in " + Thread.currentThread().getStackTrace()[1]);
    }
}
