package com.mybatis.dao.impl;

import com.mybatis.bean.User;
import com.mybatis.dao.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserMapperImpl implements UserMapper {

    private SqlSessionFactory sqlSessionFactory;

    public UserMapperImpl(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public Integer addUser(User user) {

        return null;
    }

    @Override
    public void deleteUserById(Integer id) {

    }

    @Override
    public void updateUser(Integer id, String password) {

    }

    @Override
    public List<User> findAllUser() {
        return null;
    }

    @Override
    public Integer countUser() {
        return null;
    }

    @Override
    public List<User> queryUser(String user_name) {
        SqlSession session = sqlSessionFactory.openSession();
        //可以传递参数
        List<User> list = session.selectList("com.mybatis.dao.UserMapper.queryUser", user_name);
        //释放资源
        session.close();
        return list;
    }

    @Override
    public User login(String user_name, String password) {
        return null;
    }

    @Override
    public User loginTh(String user_name, String password, Integer role_id) {
        return null;
    }
}
