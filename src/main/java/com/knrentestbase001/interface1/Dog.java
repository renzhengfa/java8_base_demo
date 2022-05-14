package com.knrentestbase001.interface1;

public class Dog implements Animal {

    @Override
    public String eat() {
        String name = Animal.name;
        System.out.println(name);
        return "dog eat";
    }

    @Override
    public String sleep() {
        return "dog sleep";
    }

}
