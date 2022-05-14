package com.kn20210423.注解;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
注解的本质就是一个实现了java.lang.annotation.Annotation{}接口
常用注解有
    1、@Override 重写 （不同类当中）
    2、@Overload 重载（同一个类当中）
    3、@Deprecated 表示方法已经过时
    4、@SuppressWarnings("all") 压制所有警告

自定义注解：
    1、格式：
    元注解
    public @interface 注解名称{}
 */
@SuppressWarnings("all") //忽略本注解内的所有报警信息（右方不会出现黄色提示）
//允许在方法，类名，成员变量上使用该注解
@Target({ElementType.METHOD,ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)//当前描述的注解会被保留到class字节码文件中，并被JVM读取到
public @interface Zj {
    //如果不赋值将使用默认值，使用的时候为： @Zj(value = {"ab"}, age = 1, name = "a")
    String[] value() default {"abc", "def"};
    public abstract int age();
    public abstract String name();
}
