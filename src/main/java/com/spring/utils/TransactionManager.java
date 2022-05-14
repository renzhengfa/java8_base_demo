package com.spring.utils;

import com.mchange.v1.db.sql.ConnectionUtils;

/**
 * 事务管理工具类
 * 它包含了：1、开启事务 2、提交事务 3、回滚事务  4、释放连接
 */
public class TransactionManager {

    /*private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils){
        this.connectionUtils = connectionUtils;
    }*/

    /**
     * 1、开启事务
     */
    public void startTransaction(){
    }

    /**
     * 2、提交事务
     */
    public static void commit(){
    }

    /**
     * 3、回滚事务
     */
    public static void rollback(){
    }

    /**
     * 4、释放连接
     */
    public static void release(){
    }
}
