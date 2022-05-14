package com.knrentestbase001.random;

import java.util.Random;
import java.util.Scanner;

public class Caishu {

    public static void main(String[] args) {
        caishu();
    }

    public static void caishu(){
        Random random = new Random();
        //产生1~100的随机数
        int ran = random.nextInt(100) + 1;
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.print("请输入猜的数字：");
            int i = sc.nextInt();
            if (i == ran) {
                System.out.println("恭喜你猜对了，随机数为：" + ran);
                break;
            }
            if (i > ran) System.out.println("大了");
            if (i < ran) System.out.println("小了");
        }
    }

}
