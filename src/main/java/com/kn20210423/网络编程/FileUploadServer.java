package com.kn20210423.网络编程;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
文件上传服务端(优化后)
 */
public class FileUploadServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        //新建一个线程执行每一个客户端发送的请求
        new Thread(new Runnable() {
            @Override
            public void run() {
                //让服务器一直处于开启状态
                while (true) {
                    Socket socket = null;
                    InputStream intelIS = null;
                    FileOutputStream fos = null;
                    OutputStream intelOS = null;
                    try {
                        //使用多线程处理客户端请求，一个客户端请求就新建一个线程处理请求
                        socket = ss.accept();
                        //网络输入流
                        intelIS = socket.getInputStream();
                        //本地输出流(将上传的图片保存到服务器本地)
                        System.out.println("服务端网络输入流： " + intelIS.toString());
                        fos = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\upload\\kuiniu" + System.currentTimeMillis() + ".jpg");
                        byte[] bytes = new byte[1024];
                        int len = 0;
                        while ((len = intelIS.read(bytes)) != -1) {
                            fos.write(bytes, 0, len);
                        }
                        //给客户端回写数据
                        intelOS = socket.getOutputStream();
                        intelOS.write("上传成功！".getBytes());
                    } catch (IOException e) {
                        System.out.println();
                    }finally {
                        //释放资源
                        try {
                            fos.close();
                            intelIS.close();
                            intelOS.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName());
                }
                //关闭服务器
//        ss.close();
            }
        }).start();
    }
}
