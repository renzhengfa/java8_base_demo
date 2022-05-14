package com.spring.proxy;

/**
 * 生产者类
 */
public class Producer implements IProducer {

    /**
     * 销售产品
     * @param money
     */
    @Override
    public void saleProduct(float money){
        System.out.println("销售产品并拿到钱：" + money);
    }

    /**
     * 售后服务
     * @param money
     */
    @Override
    public void afterService(float money){
        System.out.println("提供售后服务并拿到钱：" + money);
    }

}
