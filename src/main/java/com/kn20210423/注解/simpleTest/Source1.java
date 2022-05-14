package com.kn20210423.注解.simpleTest;

/*
这是要测试的代码
 */
public class Source1 {

    @Check
    public int add(){
        int i = 1;
        int a = 0;
        System.out.println("add");
        String s = null;
        s.toString();
        return a + i;
    }

    @Check
    public int dec(){
        int i = 1;
        int a = 0;
        System.out.println("dec");
        return a - i;
    }

    @Check
    public int sheng(){
        int i = 1;
        int a = 0;
        System.out.println("sheng");
        return a * i;
    }

    @Check
    public int chu(){
        int i = 1;
        int a = 0;
        System.out.println("chu");
        return i / a;
    }

    public void noCheck() {
        System.out.println("本方法不检测...");
    }

}
