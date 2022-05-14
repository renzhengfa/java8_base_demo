package com.kn20210423.网络编程;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
文件上传
 */
public class FileUploadClient {
    public static void main(String[] args) throws IOException {
        //指定服务端ip及端口
        Socket socket = new Socket("127.0.0.1",8888);
        //客户端向服务端发送请求数据
        OutputStream intelOS = socket.getOutputStream();
        //读取文件写入网络字节输出流
        FileInputStream fis = new FileInputStream("io\\1.jpg");
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fis.read(bytes)) != -1) {
            intelOS.write(bytes, 0, len);
        }
        //向服务端发送终止序列
        socket.shutdownOutput();
        //获取服务器端返回的数据
        InputStream intelIS = socket.getInputStream();
        int read = intelIS.read(bytes);
        System.out.println(new String(bytes, 0, read));
        //释放资源
        fis.close();
        intelOS.close();
        intelIS.close();
    }
}
