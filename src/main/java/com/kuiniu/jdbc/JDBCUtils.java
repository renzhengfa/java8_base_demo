package com.kuiniu.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 使用druid连接池编写的连接池工具类
 */
public class JDBCUtils {

    //连接池对象
    private static DataSource ds;

    //静态代码块，随类加载而加载
    static {
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream("io\\druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 释放资源
     * DML语句
     */
    public static void close(Statement statement, Connection connection) {
        close(null, statement, connection);
    }

    /**
     * 释放资源
     * DQL语句
     */
    public static void close(ResultSet rs, Statement statement, Connection connection) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();//归还连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取连接池
     */
    public static DataSource getDataSource() {
        return ds;
    }
}
