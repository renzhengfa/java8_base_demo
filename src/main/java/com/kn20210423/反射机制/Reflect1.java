package com.kn20210423.反射机制;

import com.kn20210406.泛型.GenearatorClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/*
获取字节码文件的方式：
    1、Class.forName("全类名");将字节码文件加载到内存，类名.Class类名
    2、对象.getClass();
    3、类名.class;

一、成员方法
    1、getMethod() //只能获取以public修饰符修饰的单个方法
    2、getDeclaredMethod(String name, 参数类型.class) //获取指定参数和方法名称的单个方法
        当获取的方法时以private修饰符修饰的时候会报错，解决办法是使用暴力反射（Method met.setAccessible(true);忽略权限检测
    3、getMethods() //获取所有以public修饰符修饰的成员方法
    4、getDeclaredMethods(String name, 参数类型.class) //获取所有成员方法
二、获取成员变量
    getField ....
三、获取构造方法
    getConstructor ....
 */

/**
 * @author kuiniu
 * @version 1.0
 *
 */
public class Reflect1 {
    public static void main(String[] args) throws Exception {
//        getClass1();
//        getClass2();
//        getClass3();

        //获取字节码文件
        Class<GenearatorClass> genearatorClazz = (Class<GenearatorClass>) Class.forName("com.kn20210406.泛型.GenearatorClass");
        Method met = genearatorClazz.getDeclaredMethod("printList",ArrayList.class);
        met.setAccessible(true);//开启暴力反射，（关闭权限修饰符检测）
        ArrayList<String> list = new ArrayList<>();
        list.add("aa");list.add("aa");list.add("aa");
        //执行方法
        met.invoke(new GenearatorClass(),list);
        System.out.println(met);

        //获取成员变量
        Field[] fields = genearatorClazz.getDeclaredFields();
        GenearatorClass genearatorClass1 = new GenearatorClass();
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].toString().contains("age"))
                fields[i].set(genearatorClass1, 14);
            System.out.println(fields[i]);
        }
        System.out.println(genearatorClass1.age);//14
        System.out.println(fields.length);

        //获取构造方法
        Constructor constructor = genearatorClazz.getConstructor(String.class,Integer.class);
        GenearatorClass genearatorClass2 = (GenearatorClass)constructor.newInstance("lisa",22);
        System.out.println(genearatorClass2);//GenearatorClass{name='lisa', age=22}
        //同一个字节码文件*.class同时只能创建一个对象
//        System.out.println(Person.class == new Person().getClass());//true
//        System.out.println(Person.class == Class.forName("com.kn20210406.collection.doudizhu.Person"));//true
    }

    /**
     * @throws Exception
     */
    //1、Class.forName("全类名");
    public static void getClass1() throws Exception {
        Class<GenearatorClass> genearatorClass = (Class<GenearatorClass>) Class.forName("com.kn20210406.泛型.GenearatorClass");
        Method[] methods = genearatorClass.getMethods();
        for (int i = methods.length - 1; i >= 0; i--) {
            Method m = methods[i];
            if (m.toString().contains("printList"))
                System.out.println(methods[i]);
            System.out.println(1);
        }
        System.out.println(methods.length);
    }

    //2、对象名.getClass();
    public static void getClass2() {
        GenearatorClass genearatorClass = new GenearatorClass();
        Class<GenearatorClass> clazz = (Class<GenearatorClass>) genearatorClass.getClass();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.toString().contains("printList"))
                System.out.println(method);
        }
        System.out.println(methods.length);
    }

    //3、类名.class;
    public static void getClass3() {
        Class<GenearatorClass> clazz = GenearatorClass.class;
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if(method.toString().contains("printList"))
                System.out.println(method);
        }
        System.out.println(methods.length);
    }
}
