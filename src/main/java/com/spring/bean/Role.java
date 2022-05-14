package com.spring.bean;

import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * CREATE TABLE `role` (
 *   `role_id` int(10) NOT NULL,
 *   `role_name` varchar(255) NOT NULL,
 *   PRIMARY KEY (`role_id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
//@Component(value = "role")
//@Service(value = "role")
//@Controller(value = "role")
@Repository(value = "role")
public class Role implements Serializable {

    private Integer role_id;
    private String role_name;

    public Role() {
    }

    public Role(Integer role_id, String role_name) {
        this.role_id = role_id;
        this.role_name = role_name;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role_id=" + role_id +
                ", role_name='" + role_name + '\'' +
                '}';
    }
}