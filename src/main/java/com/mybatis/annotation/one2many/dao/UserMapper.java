package com.mybatis.annotation.one2many.dao;

import com.mybatis.annotation.one2many.bean.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * 使用注解方式查看一对多情况下的用户订单信息
 */
public interface UserMapper {

    /**
     * 查询所有用户的所有订单信息
     * @return
     */
//    @Select("select * from user where id = #{uid}")
    @Select("select * from user")
    @Results(id = "userMap",value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "user_name", property = "user_name"),
            @Result(column = "password", property = "password"),
            @Result(column = "role_id", property = "role_id"),
            @Result(column = "date_first", property = "date_first"),
            @Result(property = "orders",column = "id",
                    many = @Many(select = "com.mybatis.annotation.one2many.dao.OrdersMapper.queryOrdersByUserId", fetchType = FetchType.LAZY))
    })
    List<User> selectAllUserOrders();

    /**
     * 根据用户id查询用户订单信息
     * @return
     */
    @Select("select * from user where id = #{uid}")
//    @Select("select * from user")
    @Results(id = "userMap1",value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "user_name", property = "user_name"),
            @Result(column = "password", property = "password"),
            @Result(column = "role_id", property = "role_id"),
            @Result(column = "date_first", property = "date_first"),
            @Result(property = "orders",column = "id",
                    many = @Many(select = "com.mybatis.annotation.one2many.dao.OrdersMapper.queryOrdersByUserId", fetchType = FetchType.LAZY))
    })
    User selectUserOrdersByUserId(Integer uid);

}