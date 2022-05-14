package com.spring.test;

import com.spring.bean.Role;
import com.spring.bean.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SprT {

    public static void main(String[] args) {
        //1、获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2、根据id获取bean
        User user = (User)ac.getBean("user");
        Role role = (Role)ac.getBean("role");
        System.out.println(role);
    }

}
