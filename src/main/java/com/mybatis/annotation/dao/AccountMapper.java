package com.mybatis.annotation.dao;

import com.mybatis.annotation.bean.Account;
import org.apache.ibatis.annotations.*;
import org.springframework.data.jdbc.repository.query.Query;

/**
 * Account 使用注解方式实现增删改查
 */
public interface AccountMapper {

    /**
     * 1、新增账户
     * @param account
     */
    @Insert("insert into account (uid, money, timestamp) values (#{uid}, #{money}, #{timestamp})")
    void insertAccount(Account account);

    /**
     * 2、根据账户id删除账户信息
     * @param id
     */
    @Delete("delete from account where id = #{id}")
    void deleteAccountByAccountId(Integer id);

    /**
     * 3、修改账户信息
     * @param account
     */
    @Update("update account set money = #{money}, timestamp = #{timestamp} where uid = #{uid}")
    void updateAccountByAccount(Account account);

    /**
     * 4、根据用户id查询账户信息
     * @param uid
     */
    @Select("select * from account where uid = #{uid}")
    Account queryAccountByUid( Integer uid);

}
