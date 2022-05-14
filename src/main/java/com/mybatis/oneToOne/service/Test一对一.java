package com.mybatis.oneToOne.service;

import com.mybatis.oneToOne.bean.UserAccount;
import com.mybatis.oneToOne.dao.AccountMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.data.relational.core.sql.In;

import java.io.InputStream;

/**
 * 测试一对一情况
 */
public class Test一对一 {

    @Test
    public void test01() throws Exception{
        //1、加载配置文件
        InputStream in = Resources.getResourceAsStream("mybatis/SqlMapConfig.xml");
        //2、获取工厂生产对象生产工厂对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(in);
        //3、获取SQLSession对象
        SqlSession session = sessionFactory.openSession();
        //4、获取mapper代理对象
        AccountMapper accountMapper = session.getMapper(AccountMapper.class);
        //5、调用方法操作数据库
        Integer uid = 1;
        UserAccount userAccount = accountMapper.getUserAccountByUid(uid);
        System.out.println(userAccount);

        //6、释放资源
        session.close();
        in.close();
    }

}
