package com.kn20210406.map;

import java.util.HashMap;

public class 统计字符串内某一个字符个数 {
    public static void main(String[] args) {
        String str = "aaaaahaa啊啊啊啊  ,,规划局";
        HashMap<Character, Integer> countWords = countWords(str);
        System.out.println(countWords);//{ =2, 局=1, a=7, 划=1, 规=1, h=1, 啊=4, ,=2}
    }

    //统计字符串内每个字符出现的次数
    public static HashMap<Character, Integer> countWords(String s){
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            Character c = chars[i];
            if (hashMap.containsKey(c)) {
                int count = hashMap.get(c);//获取当前个数
                count++;
                hashMap.put(c, count);
            }
            if (!hashMap.containsKey(c)) {
                hashMap.put(c, 1);//没有就默认为1开始计数
            }
        }
        return hashMap;
    }
}
