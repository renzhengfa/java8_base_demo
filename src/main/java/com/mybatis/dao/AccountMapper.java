package com.mybatis.dao;

/**
 * Account持久层接口
 */
public interface AccountMapper {

    /**
     * 根据用户id转入账户金额
     * @param uid
     * @param money
     */
    void updateCountInto(Integer uid, Double money);

    /**
     * 根据用户id转出账户金额
     * @param uid
     * @param money
     */
    void updateCountOut(Integer uid, Double money);

}
