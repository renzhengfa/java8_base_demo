package com.mybatis.annotation.one2many.bean;

import java.io.Serializable;

/**
 * CREATE TABLE `orders` (
 *   `order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单号',
 *   `uid` int(11) NOT NULL COMMENT '用户id',
 *   `goods` varchar(255) NOT NULL COMMENT '商品名称',
 *   `address` varchar(255) NOT NULL COMMENT '地址',
 *   `price` decimal(10,2) NOT NULL COMMENT '单价',
 *   `num` int(11) NOT NULL COMMENT '数量',
 *   `detail` varchar(255) DEFAULT NULL COMMENT '描述信息',
 *   PRIMARY KEY (`order_id`),
 *   KEY `order_user_id` (`uid`),
 *   CONSTRAINT `order_user_id` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
 */
public class Orders implements Serializable {

    private Integer order_id;
    private Integer uid;
    private String goods;
    private String address;
    private Double price;
    private Integer num;
    private String detail;

    public Orders() {
    }

    public Orders(Integer order_id, Integer uid, String goods, String address, Double price, Integer num, String detail) {
        this.order_id = order_id;
        this.uid = uid;
        this.goods = goods;
        this.address = address;
        this.price = price;
        this.num = num;
        this.detail = detail;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "order_id=" + order_id +
                ", uid=" + uid +
                ", goods='" + goods + '\'' +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", detail='" + detail + '\'' +
                '}';
    }
}
