package com.mybatis.oneToOne.dao;

import com.mybatis.oneToOne.bean.UserAccount;

public interface AccountMapper {

    /**
     * 根据用户id查询账户信息
     * @param uid
     * @return
     */
    UserAccount getUserAccountByUid(Integer uid);

}
