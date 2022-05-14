package com.knrentestbase001.final1;

/*
1.final修饰的数据一旦赋初始值，基本数据类型数据赋值后数据不可变，引用数据类型数据的地址值不可变。
2.如果成员变量可以不赋初始值，那么构造方法里面必须赋初始值。
 */
public class Final1 {

    private final String NAME /*= "curry"*/;
    private String name;

    public String getNAME() {
        return NAME;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Final1() {
        System.out.println("空参构造");//空参构造
        NAME = "curry";
    }

    public Final1(String NAME) {
        System.out.println("...");
        this.NAME = NAME;
    }


    public static void main(String[] args) {
        final Final1 final1 = new Final1();
        System.out.println(final1.NAME);//curry

        final int a = 1;
//        a = 2;//错误写法
        System.out.println(final1.getName());//null
        final1.setName("huohuohaha");//final修饰的引用类型数据地址值不可变但是里面的数据可以变。
        System.out.println(final1.getName());//huohuohaha

    }
}
