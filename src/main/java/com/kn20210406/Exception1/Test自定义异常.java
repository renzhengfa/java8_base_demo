package com.kn20210406.Exception1;

import java.util.HashMap;
import java.util.Scanner;

public class Test自定义异常{
    public static void main(String[] args) throws 自定义异常 {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("guiyi","26");
        hashMap.put("duotai","26");
        hashMap.put("digui","26");
        System.out.println(hashMap);
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您要注册的用户名：");
        String next = sc.next();
        if (hashMap.containsKey(next)) {
            try {
                throw new 自定义异常("亲，该用户名已被注册！！！");
            }catch (自定义异常 e) {
//                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }else {
            hashMap.put(next,"26");
            System.out.println("恭喜你，注册成功！！！");
        }
        System.out.println(hashMap);

        //extends RuntimeException
        System.out.println("--------------------------");
        System.out.println("请输入您要注册的用户名：");
        String username = sc.next();
        if (hashMap.containsKey(username)) {
            try {
                throw new 自定义异常1("亲，该用户名已被注册！！！");
            }catch (自定义异常1 e) {
//                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }else {
            hashMap.put(username,"26");
            System.out.println("恭喜你，注册成功！！！");
        }
        System.out.println(hashMap);
    }
}