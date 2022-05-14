package com.kuiniu.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

/**
 * druid连接池使用方法：
 * 1、导入jar包
 * 2、定义配置文件
 * 3、加载配置文件的配置
 * 4、获取连接对象
 */
public class DruidDatasource {

    public static void main(String[] args) throws Exception {
        //加载配置
        Properties prop = new Properties();
        prop.load(new FileInputStream("io/druid.properties"));
        Set keys = prop.keySet();
        Iterator iterator = keys.iterator();
        while (iterator.hasNext()){
            String key = (String) iterator.next();
            System.out.println(key + " : " + prop.get(key));
        }
        DataSource ds = DruidDataSourceFactory.createDataSource(prop);
        Connection con = ds.getConnection();
        System.out.println(con);
        con.close();
    }
}
