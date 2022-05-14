package com.mybatis.annotation.one2many.bean;

import java.io.Serializable;
import java.util.List;

/**
 * user实体类
 * CREATE TABLE `user` (
 *   `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
 *   `user_name` varchar(255) NOT NULL,
 *   `password` varchar(255) NOT NULL,
 *   `role_id` int(11) NOT NULL,
 *   `date_first` datetime(6) DEFAULT NULL,
 *   PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
 */
public class User implements Serializable {

    private Integer id;
    private String user_name;
    private String password;
    private Integer role_id;
    private String date_first;

    //订单集合
    private List<Orders> orders;

    public User() {
    }

    public User(Integer id, String user_name, String password, Integer role_id, String date_first, List<Orders> orders) {
        this.id = id;
        this.user_name = user_name;
        this.password = password;
        this.role_id = role_id;
        this.date_first = date_first;
        this.orders = orders;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getDate_first() {
        return date_first;
    }

    public void setDate_first(String date_first) {
        this.date_first = date_first;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                ", role_id=" + role_id +
                ", date_first='" + date_first + '\'' +
                ", orders=" + orders +
                '}';
    }
}
