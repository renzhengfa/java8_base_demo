package com.kn20210406.Exception1;

/*
自定义异常类必须继承Exception或RuntimeException
 */
//Exception
public class 自定义异常 extends Exception {

    //空参构造
    public 自定义异常(){
        super();
    }

    //带参构造
    public 自定义异常(String message){
        super(message);
    }

}

//RuntimeException
class 自定义异常1 extends RuntimeException {

    //空参构造
    public 自定义异常1(){
        super();
    }

    //带参构造
    public 自定义异常1(String message){
        super(message);
    }

}
