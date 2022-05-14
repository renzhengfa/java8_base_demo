package com.kuiniu.jdbc;

import com.kuiniu.bean.Act_id_user;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 使用连接池的好处：
 * 1、每次我们获取数据库连接都是向系统底层要得资源，频繁的创建和销毁连接比较耗时和浪费资源。
 * 2、连接池的Connection.close()方法将不再是释放资源，而是将连接归还到连接池。
 * c3p0连接池类
 * 配置文件：c3p0-config.xml
 * <c3p0-config>
 *     <default-config>
 *         <property name="driverClass">jdbc:mysql://localhost:3306/db_kuiniu</property>
 *         ...
 *     </default-config>
 *     <named-config name="myConfig">
 *          <property name="driverClass">jdbc:mysql://localhost:3306/db_kuiniu</property>
 *          ...
 *     </named-config>
 * </c3p0-config>
 * 1、导包
 * 2、获得连接池： DataSource ds = new ComboPooledDataSource();
 * 3、获得连接：ds.
 */
public class C3P0DataSource {


    public static void main(String[] args) throws SQLException {
        DataSource ds = new ComboPooledDataSource();
        Connection con = ds.getConnection();
        System.out.println(con);
        PreparedStatement ps = null;
        ResultSet rs = null;
        //
        //4、创建预处理对象（？占位符防止sql注入）
        String sql = "select * from act_id_user where ID_ = ?";
//            ps = con.createStatement();
        ps = con.prepareStatement(sql);
        //给sql的参数赋值
        ps.setInt(1, 22);
        //5、执行sql语句返回结果集
        rs = ps.executeQuery();
        //
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
        }
        //将连接归还到连接池
        con.close();
    }

}
