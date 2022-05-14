package com.mybatis.service;

import com.mybatis.bean.User;
import com.mybatis.dao.UserMapper;
import com.mybatis.dao.impl.UserMapperImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.List;

/**
 * user调试类
 */
public class UserService {
    public static void main(String[] args) throws IOException {
         //1、读取配置文件
        InputStream in = Resources.getResourceAsStream("mybatis/SqlMapConfig.xml");
        //2、创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(in);
        //3、使用工厂生产SqlSession对象
        SqlSession sqlSession = sessionFactory.openSession();
        //4、获取代理对象
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);

        //增加用户信息测试
        /*User user = new User(null, "stephen1", "abc123111", 3, "2021-05-21 11:13:32");
        System.out.println("保存之前的user： " + user);
        //保存之前的user：User{id=null, user_name='stephen1', password='abc123111', role_id=3, date_first=2021-05-21 11:13:32}
        Integer user_id = userDao.addUser(user);
        sqlSession.commit();
        System.out.println("保存之后的user： " + user);*/
        //保存之后的user： User{id=7, user_name='stephen1', password='abc123111', role_id=3, date_first=2021-05-21 11:13:32}

        //删除用户信息
//        userDao.deleteUserById(4);
//        sqlSession.commit();

        //修改用户信息
//        userDao.updateUser(2, "cc123456");
//        sqlSession.commit();

        //查询所有用户信息
//        List<User> list = userDao.findAllUser();
//        System.out.println(list);

        //查询统计用户数量
//        Integer count = userDao.countUser();
//        System.out.println(count);

        //模糊查询
//        List<User> list = userDao.queryUser("%马%");
//        System.out.println(list);
        User user1 = userDao.loginTh("curry", "123456", 2);
        System.out.println(user1);
        //释放资源
        in.close();
        sqlSession.close();
    }

    /**
     * 使用Junit测试使用mybatis自己代理对象方案
     * @throws Exception
     */
    @Test
    public void test01() throws Exception{
        System.out.println("---------------------------------------------");
        System.out.println("test01");
        System.out.println("---------------------------------------------");
        //1、获取资源配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis/SqlMapConfig.xml");
        //2、根据获取的资源创建工厂对象
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = factoryBuilder.build(inputStream);
        //
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Method[] methods = userMapper.getClass().getMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i]);
        }
        sqlSession.close();
        inputStream.close();
        System.out.println("---------------------------------------------");
    }

    /**
     * 使用自己写实现类来实现mybatis
     * @throws Exception
     */
    @Test
    public void test02() throws Exception{
        System.out.println("---------------------------------------------");
        System.out.println("test02");
        System.out.println("---------------------------------------------");
        //1、获取资源
        InputStream in = Resources.getResourceAsStream("mybatis/SqlMapConfig.xml");
        //2、根据获取的资源创建工厂对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
        //获取mapper的实现类对象
        UserMapper userMapper = new UserMapperImpl(sqlSessionFactory);
        List<User> users = userMapper.queryUser("curry");
        for (User user : users) {
            System.out.println(user);
        }
        in.close();
        System.out.println("---------------------------------------------");
    }

    @Test
    public void test03() throws Exception{
        System.out.println("---------------------------------------------");
        System.out.println("test03");
        System.out.println("---------------------------------------------");
        /*//1、读取配置文件
        InputStream in = Resources.getResourceAsStream("mybatis/SqlMapConfig.xml");
        //2、创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(in);
        //3、使用工厂生产SqlSession对象
        SqlSession sqlSession = sessionFactory.openSession();
        //4、获取代理对象
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);

        User user1 = userDao.loginTh("curry", "123456", 1);
        System.out.println(user1);
        //释放资源
        in.close();
        sqlSession.close();
        System.out.println("---------------------------------------------");*/

        //1、读取配置文件
        InputStream in = Resources.getResourceAsStream("mybatis/SqlMapConfig.xml");
        //2、创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
        //3、使用工厂生产SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4、获取代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.login("curry", "123456");
        System.out.println(user);
        //释放资源
        sqlSession.close();
        in.close();
    }

}