package com.knrentestbase001.mianxiangObject;

/*
Java访问修饰符包括private，default，protected和public。
 */

import org.springframework.data.relational.core.sql.In;

abstract class Person {

    private String name;
    private Integer age;

    Person(){

    }

    Person(String name, Integer integer){
        this.age = integer;
        this.name = name;
    }

    public abstract void sport();

    public void sport(Integer i){

    }

}
