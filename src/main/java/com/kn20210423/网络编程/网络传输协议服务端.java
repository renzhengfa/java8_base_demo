package com.kn20210423.网络编程;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
网络传输协议服务端
通信的步骤：
    1、启动服务端ServerSocket
    2、客户端Socket请求服务器端（客户端和服务端就会建立一个逻辑连接）
    3、这个连接中包含一个对象（IO对象）
    4、客户端和服务端可以使用的这个IO对象进行数据交换的
    5、通信的数据不仅仅是文字，所有采用字节流对象
 */
public class 网络传输协议服务端 {
    public static void main(String[] args) throws IOException {
        /*
        服务端使用步骤：
            1、创建服务端ServerSocket对象和指定服务端端口
            2、使用服务端ServerSocket对象的成员方法accept获取客户端对象Socket
            3、使用客户端对象获取对应的网络字节输入输出流
            4、使用网络字节输入输出流与客户端进行数据交换
            5、是否资源
         */
        ServerSocket ss = new ServerSocket(8888);
//        SocketChannel socketChannel = ss.getChannel().accept();
        //获取到请求的客户端对象
        Socket accept = ss.accept();
        //服务端接收客户端数据
        InputStream inputStream = accept.getInputStream();
        byte[] bytes = new byte[2048];
        int len = inputStream.read(bytes);
        String message = new String(bytes, 0, len);
        System.out.println(message);

        //服务端向客户端发送数据
        OutputStream outputStream = accept.getOutputStream();
        if (message.contains("2")){
            outputStream.write("收到，客户端2。。。".getBytes());
        }else {
            outputStream.write("收到，客户端1。。。".getBytes());
        }
        //释放资源
        inputStream.close();
        outputStream.close();
    }
}
