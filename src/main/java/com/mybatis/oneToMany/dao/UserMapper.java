package com.mybatis.oneToMany.dao;

import com.mybatis.oneToMany.bean.User;

/**
 * 一个用户多个订单查询测试
 */
public interface UserMapper {

    /**
     * 根据用户id查询其所有订单信息
     * @param uid
     * @return
     */
    User findAllOrderByUserId(Integer uid);

}
