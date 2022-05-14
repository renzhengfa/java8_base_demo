package com.mybatis.annotation.one2many.dao;

import com.mybatis.annotation.one2many.bean.Orders;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 根据用户id查询订单信息
 */
public interface OrdersMapper {

    @Select("select * from orders where uid = #{uid}")
    @Results(id = "OrdersMap", value = {
            @Result(id = true, property = "order_id", column = "order_id"),
            @Result(property = "uid", column = "uid"),
            @Result(property = "goods", column = "goods"),
            @Result(property = "address", column = "address"),
            @Result(property = "price", column = "price"),
            @Result(property = "num", column = "num"),
            @Result(property = "detail", column = "detail")
    })
    List<Orders> queryOrdersByUserId(Integer uid);

}