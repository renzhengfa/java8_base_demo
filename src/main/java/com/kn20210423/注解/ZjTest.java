package com.kn20210423.注解;

import java.util.Arrays;

@Zj(age = 18, name = "curry")
public class ZjTest {
    public static void main(String[] args) {
        Class clazz = ZjTest.class;
        Zj zj = (Zj) clazz.getAnnotation(Zj.class);
        System.out.println(zj.name());//curry
        System.out.println(zj.age());//18
        System.out.println(Arrays.toString(zj.value()));//[abc]
    }
}

