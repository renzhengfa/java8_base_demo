package com.kn20210406.泛型;

import java.util.ArrayList;
import java.util.Iterator;

public class GenearatorClass {

    private String name;
    public Integer age;

    public GenearatorClass() {
    }

    public GenearatorClass(String name, Integer age) {
        this.name = name;
        this.age = age;
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

    public static void main(String[] args) {
        //当E为String时
        泛型<String> fx = new 泛型<>();
        fx.setName("curry");
        System.out.println(fx.getName());//curry
        //当E为Integer时
        泛型<Integer> fx1 = new 泛型<>();
        fx1.setName(18);
        System.out.println(fx1.getName());//18

        //-------------------------------------
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("aa");
        arrayList.add("11");

        ArrayList<Integer> arrayList1 = new ArrayList();
        arrayList1.add(11);
        arrayList1.add(22);
        //-泛型适应多种数据类型
        printList(arrayList);
        printList(arrayList1);

    }

    //遍历任意类型数据的集合
    private static void printList(ArrayList<?> arrayList) {
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Override
    public String toString() {
        return "GenearatorClass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
