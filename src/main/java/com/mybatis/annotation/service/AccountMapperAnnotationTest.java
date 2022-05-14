package com.mybatis.annotation.service;

import com.mybatis.annotation.bean.Account;
import com.mybatis.annotation.dao.AccountMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;

/**
 * 测试注解开发
 */
public class AccountMapperAnnotationTest {

    /**
     * 1、新增测试
     * @throws Exception
     */
    @Test
    public void testInsert() throws Exception {
        //1、加载配置
        InputStream in = Resources.getResourceAsStream("mybatis/SqlMapConfig.xml");
        //2、获取sqlSession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //3、获取SQLSession对象
        SqlSession session = sqlSessionFactory.openSession();
        //4、获取mapper代理对象
        AccountMapper accountMapper = session.getMapper(AccountMapper.class);
        //5、调用代理对象的方法实现操作数据库
        Account account = new Account();
        account.setMoney(2406.22);
        account.setUid(3);
        account.setTimestamp(new Date());
        accountMapper.insertAccount(account);
        session.commit();
        //6、释放资源
        session.close();
        in.close();
    }

    /**
     * 2、删除测试
     * @throws Exception
     */
    @Test
    public void testDelete() throws Exception {
        //1、加载配置
        InputStream in = Resources.getResourceAsStream("mybatis/SqlMapConfig.xml");
        //2、获取sqlSession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //3、获取SQLSession对象
        SqlSession session = sqlSessionFactory.openSession();
        //4、获取mapper代理对象
        AccountMapper accountMapper = session.getMapper(AccountMapper.class);
        //5、调用代理对象的方法实现操作数据库
        accountMapper.deleteAccountByAccountId(4);
        session.commit();
        //6、释放资源
        session.close();
        in.close();
    }

    /**
     * 3、修改测试
     * @throws Exception
     */
    @Test
    public void testUpdate() throws Exception {
        //1、加载配置
        InputStream in = Resources.getResourceAsStream("mybatis/SqlMapConfig.xml");
        //2、获取sqlSession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //3、获取SQLSession对象
        SqlSession session = sqlSessionFactory.openSession();
        //4、获取mapper代理对象
        AccountMapper accountMapper = session.getMapper(AccountMapper.class);
        //5、调用代理对象的方法实现操作数据库
        Account account = new Account();
        account.setUid(3);
        account.setMoney(123456.78);
        account.setTimestamp(new Date());
        accountMapper.updateAccountByAccount(account);
        session.commit();
        //6、释放资源
        session.close();
        in.close();
    }

    /**
     * 4、查询测试
     * @throws Exception
     */
    @Test
    public void testQuery() throws Exception {
        //1、加载配置
        InputStream in = Resources.getResourceAsStream("mybatis/SqlMapConfig.xml");
        //2、获取sqlSession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //3、获取SQLSession对象
        SqlSession session = sqlSessionFactory.openSession();
        //4、获取mapper代理对象
        AccountMapper accountMapper = session.getMapper(AccountMapper.class);
        //5、调用代理对象的方法实现操作数据库
        Account account = accountMapper.queryAccountByUid(3);
        System.out.println(account);
        //6、释放资源
        session.close();
        in.close();
    }
}
