package com.kn20210406.neibulei1;

/*
匿名内部类：
如果接口的实现类（或者父类的子类）只需要使用唯一的一次，
那么这种情况下就可以使用匿名内部类。

匿名内部类定义格式：
接口名称 对象名 = new 接口名称(){
    //实现所有抽象方法。
};
 */
public class NiMingNeiBuLei {

    public static void main(String[] args) {
        //为了不去写实现MyInterface接口的实现类，创建一个匿名内部类
        MyInterface myInterface = new MyInterface() {
            @Override
            public void method() {
                System.out.println("匿名内部类实现了MyInterface接口的方法");
            }
        };
        myInterface.method();
        String aa = "";



        //
        int mag = Integer.SIZE - Integer.numberOfLeadingZeros(11);
        System.out.println(Integer.SIZE);
        System.out.println(Integer.numberOfLeadingZeros(11));

//        int chars = Math.max(((mag + (shift - 1)) / shift), 1);
//        char[] buf = new char[chars];

//    formatUnsignedInt(val, shift, buf, 0, chars);

        //位运算
        System.out.println(14 >> 2);// 过程： 14=1110  1110 >> 2 = 11 = 3
        System.out.println(14 << 2);// 过程： 14=1110  1110 << 2 = 111000 = 56
        System.out.println(-14 >> 2);
        System.out.println(-14 << 2);
    }

}
