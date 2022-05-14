package com.mybatis.annotation.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * CREATE TABLE `account` (
 *   `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
 *   `uid` int(11) NOT NULL COMMENT '用户ID',
 *   `money` double(22,0) NOT NULL COMMENT '余额',
 *   `timestamp` datetime(6) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(6),
 *   PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
 */
public class Account implements Serializable {

    private Integer id;
    private Integer uid;
    private Double money;
    private Date timestamp;

    public Account() {
    }

    public Account(Integer id, Integer uid, Double money, Date timestamp) {
        this.id = id;
        this.uid = uid;
        this.money = money;
        this.timestamp = timestamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", uid=" + uid +
                ", money=" + money +
                ", timestamp=" + timestamp +
                '}';
    }
}
