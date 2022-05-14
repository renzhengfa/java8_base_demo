package com.spring.proxy;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 模拟一个消费者
 */
public class Client {

    /*
    动态代理
     */
    public static void main(String[] args) {
        Producer producer = new Producer();
//        producer.saleProduct(10000f);
        /**
         * 动态代理：
         * 特点：字节码随用随加载
         * 作用：不修改源码的基础上实现对方法的增强
         * 分类：1、基于接口的动态代理（涉及的类Proxy,提供者：JDK官方）缺点：被代理类必须实现至少一个接口，如果没有则不可以使用
         *      2、基于子类的动态代理（cglib,依靠第三方jar包）
         */
        IProducer iProducer = (IProducer)Proxy.newProxyInstance(producer.getClass().getClassLoader(), producer.getClass().getInterfaces(), new InvocationHandler() {
            /**
             * 作用：执行被代理对象的所有接口方法都会经过该方法
             * @param proxy      代理对象的引用
             * @param method     当前执行的方法
             * @param args       当前方法执行所需的参数
             * @return           和被代理对象方法有相同的返回值
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //此处编写要增强的代码
                //获取参数
                if (args.length == 1){
                    System.out.println(1);
                }
                Float money = (Float) args[0];
                System.out.println(money);
                //判断是否时销售方法
                if (method.getName().equals("saleProduct")) {
                    money = 0.8f * money;
                    return method.invoke(producer, money);
                }
                return method.invoke(producer, args);
            }
        });

        //执行方法
        iProducer.saleProduct(10000f);
        iProducer.afterService(10000f);




        /*IProducer iProducer = (IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    *//**
                     * 作用：执行被代理对象的所有接口方法都会经过该方法
                     * @param proxy      代理对象的引用
                     * @param method     当前执行的方法
                     * @param args       当前方法执行所需的参数
                     * @return           和被代理对象方法有相同的返回值
                     * @throws Throwable
                     *//*
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //提供增强的代码
                        //获取执行的方法参数
                        System.out.println(args[0]);
                        Float money = (Float) args[0];
                        //判断当前是不是执行的销售方法
                        if (method.getName().equals("saleProduct")){
                            money = 0.8f * money;
                            return method.invoke(producer, money);
                        }
                        return method.invoke(producer, args);
                    }
                });
        iProducer.saleProduct(10000f);
        iProducer.afterService(10000F);*/
    }

    /**
     * cglib代理：基于子类的动态代理测试
     * 被代理类不能是最终类
     */
    @Test
    public void testEnhancerProxy(){
        Producer producer = new Producer();
        /**
         * Class: 字节码文件
         * Callback: 用于提供增强代码块，我们一般是写该接口的子接口实现类：MethodInterceptor
         */
        //Enhancer.create(Class.class, Callback callback);
        Producer cglibProducer = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             * 执行被代理对象的任何方法都会经过该方法
             * @param proxy
             * @param method
             * @param args
             * 以上三个参数和基于接口实现动态代理中invoke方法内的三个参数是一样的
             * @param methodProxy 当前方法执行的代理对象
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                //提供增强的代码
                //获取执行的方法参数
                System.out.println(args[0]);
                Float money = (Float) args[0];
                //判断当前是不是执行的销售方法
                if (method.getName().equals("saleProduct")){
                    money = 0.8f * money;
                    return method.invoke(producer, money);
                }
                return method.invoke(producer, money * 0.6f);
            }
        });
        //执行方法
        cglibProducer.saleProduct(10000f);
        cglibProducer.afterService(10000f);
    }

}