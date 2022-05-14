package com.kuiniu.jdbc;

import com.kuiniu.bean.Act_id_user;

import java.io.FileReader;
import java.sql.*;
import java.util.*;

/*
链接数据库
 */
public class JDBCTest {

    public static void main(String[] args) throws SQLException {
//        getUsers();
        druidDataSourceTest();
    }

    //1、常规方式获取连接操作数据库
    private static void getUsers() {
        //1、导入依赖
        Connection con = null;
//        Statement ps = null; //可能出现sql注入
        PreparedStatement ps = null; //不会出现sql注入
        ResultSet rs = null;
        try {
            //加载配置
            Properties prop = new Properties();
            prop.load(new FileReader("io\\jdbc.properties"));
            //2、加载驱动
            Class.forName(prop.getProperty("driver"));
            //3、获取连接
            con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
            //4、创建预处理对象（？占位符防止sql注入）
            String sql = "select * from act_id_user where ID_ = ?";
//            ps = con.createStatement();
            ps = con.prepareStatement(sql);
            //给sql的参数赋值
            ps.setInt(1, 22);
            //5、执行sql语句返回结果集
            rs = ps.executeQuery();
            //遍历结果集将结果每一条数据拆分然后封装成我们的对象
            while (rs.next()){
                int ID_ = rs.getInt("ID_");
                int REV_ = rs.getInt("REV_");
                String FIRST_ = rs.getString("FIRST_");
                String LAST_ = rs.getString("LAST_");
                String EMAIL_ = rs.getString("EMAIL_");
                String PWD_ = rs.getString("PWD_");
                String PICTURE_ID_ = rs.getString("PICTURE_ID_");
                Act_id_user user = new Act_id_user(ID_, REV_, FIRST_, LAST_, EMAIL_, PWD_, PICTURE_ID_);
//                if (user.getID_() == 22)
                System.out.println(user);
                //Act_id_user{ID_='22', REV_=1, FIRST_='admin', LAST_='null', EMAIL_='null', PWD_='cc123456', PICTURE_ID_='null'}
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                //6、释放资源
                rs.close();
                ps.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //2、使用Druid连接池获取连接操作数据库
    private static void druidDataSourceTest() throws SQLException {
        Connection con = JDBCUtils.getConnection();
        String sql = "insert into act_id_user values(1111, 121, 11, ?, ?, ?, ?) ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, "11-name");
        ps.setString(2, "202ll@qq.com");
        ps.setString(3, "123456");
        ps.setString(4, "null");
        ps.executeUpdate();
        JDBCUtils.close(ps, con);
    }
}