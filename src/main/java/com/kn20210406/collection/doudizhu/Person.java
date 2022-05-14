package com.kn20210406.collection.doudizhu;

import java.util.ArrayList;

public class Person {

    //名称
    private String name;
    //年龄
    private Integer age;
    //手里还有的牌
    private ArrayList card;

    public Person() {
    }

    public Person(String name, Integer age, ArrayList card) {
        this.name = name;
        this.age = age;
        this.card = card;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public ArrayList getCard() {
        return card;
    }

    public void setCard(ArrayList card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", card=" + card +
                '}';
    }
}
