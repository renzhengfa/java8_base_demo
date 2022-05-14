package com.mybatis.annotation.bean;

import java.io.Serializable;

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
public class UserAccount implements Serializable {

    private Integer id;
    private String user_name;
    private String password;
    private Integer role_id;
    private String date_first;

    private Account account;

    public UserAccount() {
    }

    public UserAccount(Integer id, String user_name, String password, Integer role_id, String date_first, Account account) {
        this.id = id;
        this.user_name = user_name;
        this.password = password;
        this.role_id = role_id;
        this.date_first = date_first;
        this.account = account;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "id=" + id +
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                ", role_id=" + role_id +
                ", date_first='" + date_first + '\'' +
                ", account=" + account +
                '}';
    }
}
