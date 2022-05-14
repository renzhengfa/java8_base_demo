package com.kn20210406.collection.doudizhu;

import java.util.ArrayList;
import java.util.Collections;

/*
单列斗地主
 */
public class DouDiZhu {

    public static void main(String[] args) {
        //获取全部元数据
        ArrayList baseCard = DouDiZhu.getBaseCard();
//        System.out.println(baseCard);
//        System.out.println(baseCard.size());

        //打乱集合顺序Collections.shuffle(List<?> list);随机打乱顺序
        Collections.shuffle(baseCard);
//        System.out.println(baseCard);

        //分发牌
        ArrayList a1 = new ArrayList();
        ArrayList a2 = new ArrayList();
        ArrayList a3 = new ArrayList();
        ArrayList a4 = new ArrayList();
        for (int i = 0; i < baseCard.size(); i++) {
            //预留三张底片
            if (i < (baseCard.size() - 3)) {
                if(i % 3 == 0) {
                    a1.add(baseCard.get(i));
                }
                if(i % 3 == 1) {
                    a2.add(baseCard.get(i));
                }
                if(i % 3 == 2) {
                    a3.add(baseCard.get(i));
                }
                continue;
            }
            a4.add(baseCard.get(i));
        }
        Person person1 = new Person("curry",33, a1);
        Person person2 = new Person("tompthon",29, a2);
        Person person3 = new Person("green",32, a3);

        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);
        System.out.println(a4);

    }

    //基本数据准备
    public static ArrayList getBaseCard() {
        ArrayList baseCard = new ArrayList();
        String[] colors = {"♠","♥","♣","♦"};
        String[] cards = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        for (int i = 0; i < colors.length; i++) {
            for (int i1 = 0; i1 < cards.length; i1++) {
                baseCard.add(colors[i]+cards[i1]);
            }
        }
        //,"小王","大王"
        baseCard.add("小王");
        baseCard.add("大王");
        return baseCard;
    }

}
