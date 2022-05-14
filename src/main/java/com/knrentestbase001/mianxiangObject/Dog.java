package com.knrentestbase001.mianxiangObject;

public class Dog extends Person {

    public String name;
    private Integer age;
    String m;

    public Dog(){
    }

    @Override
    public void sport() {
        System.out.println("person sport");
    }
//    Person test1 = new Person();

//    @Override
//    public String toString() {
//        return "Dog{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    }
}
