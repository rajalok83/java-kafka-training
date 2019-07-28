package com.example.basicJavaKafka.lab6.model;

import java.io.Serializable;

public class Employee{
    int id;
    int age;
    String fName;
    String lName;

    public Employee() {
    }

    public Employee(int id, int age, String fName, String lName) {
        System.out.println("I am in " + Thread.currentThread().getStackTrace()[1]);
        this.id = id;
        this.age = age;
        this.fName = fName;
        this.lName = lName;
    }

    public int getId() {
        System.out.println("I am in " + Thread.currentThread().getStackTrace()[1]);
        return id;
    }

    public void setId(int id) {
        System.out.println("I am in " + Thread.currentThread().getStackTrace()[1]);
        this.id = id;
    }

    public int getAge() {
        System.out.println("I am in " + Thread.currentThread().getStackTrace()[1]);
        return age;
    }

    public void setAge(int age) {
        System.out.println("I am in " + Thread.currentThread().getStackTrace()[1]);
        this.age = age;
    }

    public String getfName() {
        System.out.println("I am in " + Thread.currentThread().getStackTrace()[1]);
        return fName;
    }

    public void setfName(String fName) {
        System.out.println("I am in " + Thread.currentThread().getStackTrace()[1]);
        this.fName = fName;
    }

    public String getlName() {
        System.out.println("I am in " + Thread.currentThread().getStackTrace()[1]);
        return lName;
    }

    public void setlName(String lName) {
        System.out.println("I am in " + Thread.currentThread().getStackTrace()[1]);
        this.lName = lName;
    }

    @Override
    public String toString() {
        System.out.println("I am in " + Thread.currentThread().getStackTrace()[1]);
        return "Employee{" +
                "id=" + id +
                ", age=" + age +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                '}';
    }
}
