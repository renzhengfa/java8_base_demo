package com.mybatis.service;

import com.mybatis.bean.Role;
import com.mybatis.bean.RoleQueryVo;
import com.mybatis.dao.RoleMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.data.relational.core.sql.In;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 动态sql
 */
public class RoleService {

    /**
     * 测试角色使用代理mapper方式查询角色列表
     */
    @Test
    public void test01() throws Exception{
        //1、加载配置
        InputStream in = Resources.getResourceAsStream("mybatis/SqlMapConfig.xml");
        //2、获得生产工厂对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
        //3、使用工厂对象获取session对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);

        RoleQueryVo vo = new RoleQueryVo();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);ids.add(2);ids.add(3);
        vo.setIds(ids);

        List<Role> roleList = roleMapper.queryRolesByIds(vo);
        System.out.println(roleList);
        //释放资源
        sqlSession.close();
        in.close();
    }

}
