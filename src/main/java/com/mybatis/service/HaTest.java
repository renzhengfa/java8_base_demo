package com.mybatis.service;

import org.junit.Test;

public class HaTest {

    @Test
    public void test1() throws Exception {
        AccountService accountService = new AccountService();
        accountService.updateCountInto(1, 200d);
    }

}
