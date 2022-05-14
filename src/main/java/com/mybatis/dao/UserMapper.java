package com.mybatis.dao;

import com.mybatis.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * user实体持久层接口类
 */
public interface UserMapper {

    /**
     * 增加用户信息,返回新增用户的id信息
     * @param user
     * @return
     */
    Integer addUser(User user);

    /**
     * 删除用户信息
     * @param id
     */
    void deleteUserById(Integer id);

    /**
     * 修改用户密码信息
     * @param id
     * @param password
     */
    void updateUser(@Param("id") Integer id, @Param("password") String password);

    /**
     * 查询所有用户信息
     * @Select("select * from user")
     */
    List<User> findAllUser();

    /**
     * 查询统计用户数量
     * @return
     */
    Integer countUser();

    /**
     * 模糊查询
     */
    List<User> queryUser(String user_name);

    /**
     * login
     * @param user_name
     * @param password
     * @return
     */
    User login(String user_name, String password);

    /**
     * 登录1
     * @param user_name
     * @param password
     * @param role_id
     * @return
     */
    User loginTh(String user_name, String password,Integer role_id);
}
