package com.kn20210406.泛型;

import org.springframework.aop.TargetSource;

/*
泛型<>符号里面的数据类型传递。

泛型的高级用法：（限定泛型的数据类型）
1、<？ extends Number>  这个时候泛型?只能是Number类型及其子类类型
2、<? supper Number>    这个时候泛型?只能是Number类型及其父类类型
 */
public class 泛型<E> {

    private E name;

    public E getName() {
        return name;
    }

    public void setName(E name) {
        this.name = name;
    }
}
