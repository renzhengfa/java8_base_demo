package com.mybatis.oneToMany.service;

import com.mybatis.oneToMany.bean.User;
import com.mybatis.oneToMany.dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

/**
 * mybatis一对多测试类
 */
public class Test一对多 {

    @Test
    public void test01() throws Exception {
        //1、加载配置文件
        InputStream in = Resources.getResourceAsStream("mybatis/SqlMapConfig.xml");
        //2、根据加载的配置输入流获取SqlSession工厂对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(in);
        //3、根据获取SqlSession工厂对象获取SqlSession对象
        SqlSession session = sessionFactory.openSession();
        //4、根据获取的SqlSession对象获得mapper的代理对象
        UserMapper userMapper = session.getMapper(UserMapper.class);
        //5、根据代理对象调用起方法操作数据库
        Integer uid = 1;
        User user = userMapper.findAllOrderByUserId(uid);
        System.out.println(user);
        //6、释放资源
        session.close();
        in.close();
    }

}