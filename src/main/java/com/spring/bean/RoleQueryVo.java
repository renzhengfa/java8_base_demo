package com.spring.bean;

import java.util.List;

public class RoleQueryVo {

    private Integer role_id;
    private String role_name;

    /*
    当需要给sql语句传递集合时可以这样
    select * from user where userId in (1,2,3,4);
     */
    private List<Integer> ids;

    public RoleQueryVo() {
    }

    public RoleQueryVo(Integer role_id, String role_name, List<Integer> ids) {
        this.role_id = role_id;
        this.role_name = role_name;
        this.ids = ids;
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

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "RoleQueryVo{" +
                "role_id=" + role_id +
                ", role_name='" + role_name + '\'' +
                ", ids=" + ids +
                '}';
    }
}
