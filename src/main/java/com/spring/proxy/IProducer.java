package com.spring.proxy;

/**
 * 生产厂家标准
 */
public interface IProducer {

    /**
     * 销售产品
     * @param money
     */
    public void saleProduct(float money);

    /**
     * 售后服务
     * @param money
     */
    public void afterService(float money);

    public default void aa(float money){

    }

    public static void bb(float money){

    }

}
