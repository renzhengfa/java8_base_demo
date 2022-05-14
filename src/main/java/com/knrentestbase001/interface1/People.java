package com.knrentestbase001.interface1;

public class People implements Animal {



    @Override
    public String eat() {
        return "people eat";
    }

    @Override
    public String sleep() {
        return "people sleep";
    }
}
