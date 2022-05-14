package com.knrentestbase001.extends1;

//父类
public class Employee {

    public String name = "aa";
    private int age;

    public static void method(){
        System.out.println("employee method zhixing");
    }

    public String overRideFu(String name){
        return "overRideFu";
    }

    public Employee() {
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
