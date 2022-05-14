package com.mybatis.service;

import com.mybatis.dao.AccountMapper;
import com.mybatis.dao.RoleMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 用户账户服务类
 */
public class AccountService {

    private static InputStream in = null;
    private static SqlSessionFactoryBuilder sqlSessionFactoryBuilder = null;
    private static SqlSessionFactory sqlSessionFactory = null;
    private static SqlSession sqlSession = null;
    private static AccountMapper accountMapper = null;

    static {
        //1、加载配置
        try {
            in = Resources.getResourceAsStream("mybatis/SqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //2、获得生产工厂对象
        sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
        //3、使用工厂对象获取session对象
        sqlSession = sqlSessionFactory.openSession();
        accountMapper = sqlSession.getMapper(AccountMapper.class);
    }
    /**
     * 根据用户id转入账户金额
     * @param uid
     * @param money
     */
    public void updateCountInto(Integer uid, Double money) throws Exception{
        accountMapper.updateCountInto(uid, money);
        commitAndRelease();
    }

    /**
     * 根据用户id转出账户金额
     * @param uid
     * @param money
     */
    public void updateCountOut(Integer uid, Double money) throws Exception{
        accountMapper.updateCountOut(uid, money);
        commitAndRelease();
    }

    /**
     * 提交事务及释放资源
     */
    public static void commitAndRelease() throws Exception{
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

}
