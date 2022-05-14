package com.kn20210423.网络编程;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
网络传输协议客户端Socket
网络传输协议分为TCP和UDP
TCP : 先建立连接在发送数据（三次握手1、客户端向服务端发送请求 2、服务端收到请求向客户端发送确认响应 3、客户端再次向服务器发送确认信息确认连接）
UDP : 不需要建立连接，直接发送数据 （效率高）
 */
public class 网络传输协议客户端1 {
    public static void main(String[] args) throws IOException {
        /*
        客户端向服务器发送数据和接收数据流程：
            1、创建一个客户端对象Socket,构造方法绑定服务器ip及端口
            2、使用Socket对象里面的getOutputStream()获取网络字节输出流OutputStream对象
            3、使用网络字节输出流中的write()方法向服务器发送数据
            4、使用Socket对象里面的getInputStream()获取网络字节输入流InputStream对象
            5、使用网络字节输入流中的read()方法获取服务器回写的数据
            6、释放流资源
        注意：
            1、客户端和服务器端交互必须使用Socket中提供的网络字节流
            2、当我们创建客户端Socket对象时，Socket就会去和服务端请求并通过3次握手建立连接通路（这个时候服务器没有启动就会报错）
         */
        //1、创建一个客户端对象Socket,构造方法绑定服务器ip及端口
        Socket socket = new Socket("127.0.0.1",8888);
        //2、使用Socket对象里面的getOutputStream()获取网络字节输出流OutputStream对象
        OutputStream outputStream = socket.getOutputStream();
        //3、使用网络字节输出流中的write()方法向服务器发送数据
        outputStream.write("你好，服务器,我是客户端1 ！！！".getBytes());
        //4、使用Socket对象里面的getInputStream()获取网络字节输入流InputStream对象
        InputStream is = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        //5、使用网络字节输入流中的read()方法获取服务器回写的数据
        while ((len = is.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }
        //6、释放流资源
        outputStream.close();
        is.close();
    }
}
