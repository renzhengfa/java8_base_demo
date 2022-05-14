package com.kn20210423.jdk8新特性;

import org.springframework.http.converter.json.GsonBuilderUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;
import java.util.stream.Stream;

public class Stream1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("张三丰");
        list.add("张无忌");
        list.add("范志毅");
        list.add("库里");
        Stream<String> stringStream = list.stream().filter(name -> name.length() == 3).filter(name -> name.startsWith("范"));
        Stream<String> stringStream1 = list.stream().filter(name -> name.length() == 3).filter(name -> name.startsWith("张")).limit(1);
//        System.out.println(stringStream);
        stringStream.forEach(name -> System.out.println(name));//范志毅
        stringStream1.forEach(name -> System.out.println(name));//张三丰
        testLambda(() -> {System.out.println("lambda");});

    }

    public static void testLambda(MyFunctionalInterface myFunctionalInterface){
        myFunctionalInterface.get();
//        MyFunctionalInterface.get1();
    }
}