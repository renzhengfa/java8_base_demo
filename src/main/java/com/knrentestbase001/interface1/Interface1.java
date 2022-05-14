package com.knrentestbase001.interface1;

/*
接口中的抽象方法必须为：public abstract修饰符

java8开始支持接口可以定义默认方法（public default）
java9及之后支持接口内些私有化方法（private）

接口内的成员变量必须有public final static修饰 ,一旦使用final修饰的变量就是常量，值不可变

接口可以继承接口Interface1 extends Interface2,Interface3
 */
public class Interface1 {

    public static void main(String[] args) {

        Dog dog = new Dog();
        String eat = dog.eat();
        System.out.println(eat);
        Animal.getA();//静态方法只能用类调用
        dog.getB();//接口的默认方法可以用子类对象调用

        Zi zi = new Zi();
        zi.method();

    }

}
