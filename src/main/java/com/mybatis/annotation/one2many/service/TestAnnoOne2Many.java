package com.mybatis.annotation.one2many.service;

import com.mybatis.annotation.one2many.bean.Orders;
import com.mybatis.annotation.one2many.bean.User;
import com.mybatis.annotation.one2many.dao.OrdersMapper;
import com.mybatis.annotation.one2many.dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * 使用注解方式查看一对多情况下的用户订单信息
 */
public class TestAnnoOne2Many {

    /**
     * 测试一对多
     * @throws Exception
     */
    @Test
    public void testOne2Many() throws Exception {
        InputStream in = Resources.getResourceAsStream("mybatis/SqlMapConfig.xml");
        SqlSession session = new SqlSessionFactoryBuilder().build(in).openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
//        List<User> users = userMapper.selectAllUserOrders();
//        for (User user : users) {
//            System.out.println(user);
//        }

        User user = userMapper.selectUserOrdersByUserId(1);
        System.out.println(user);
        User user1 = userMapper.selectUserOrdersByUserId(1);
        System.out.println(user == user1);
        session.close();
        in.close();
    }

    /**
     * 测试查询集合数据
     * @throws Exception
     */
    @Test
    public void queryOrdersByUid() throws Exception {
        InputStream in = Resources.getResourceAsStream("mybatis/SqlMapConfig.xml");
        SqlSession session = new SqlSessionFactoryBuilder().build(in).openSession();
        OrdersMapper ordersMapper = session.getMapper(OrdersMapper.class);
        List<Orders> orders = ordersMapper.queryOrdersByUserId(1);
        for (Orders order : orders) {
            System.out.println(order);
        }
        session.close();
        in.close();
    }

}
