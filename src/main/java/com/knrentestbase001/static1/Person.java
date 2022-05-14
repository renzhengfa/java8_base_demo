package com.knrentestbase001.static1;

import org.springframework.data.relational.core.sql.In;

import java.util.Objects;

public class Person {

    private int age;
    private String name;
    public static String blon;

    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getBlon() {
        return blon;
    }

    public static void setBlon(String blon) {
        Person.blon = blon;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", blon=" + blon +
                '}';
    }
}
