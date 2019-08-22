package com.dxc.NET.FileUpLoad;

import java.io.*;
import java.net.Socket;

/**
 * @author 灵魂编程者
 * @Title: UpLoadClient
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/8/22 19:17
 */
/*
* 客户端，要上传本地文件到服务器，并且读取服务器返回的信息
* 数据源，本地：D:\\aaa.jpg，D盘下的一个图片
* 目的地：服务器
* 实现步骤：
*       1、创建一个本地的字节输入流，FileInputStream对象，读取本地数据源
*       2、创建一个客户端Socket对象，构造方法中绑定服务器的ip地址和端口号
*       3、使用Socket获得网络字节输出流
*       4、使用本地字节输入流，read方法，读取本地文件
*       5、使用网络字节输出流，write方法，把读取到的文件上传到服务器
*       6、使用Socket中的网络字节输入流对象，
*       7、使用网络字节输入流对象read读入服务器端回写的数据
*       8、释放资源，网络流，本地流
*
*       \void shutdownOutput()
          禁用此套接字的输出流。
* */
public class UpLoadClient {
    public static void main(String[] args) throws IOException {

        //1、创建一个本地的字节输入流，FileInputStream对象，读取本地数据源
        InputStream in  = new FileInputStream(new File("D:\\aaa.jpg"));

        // 2、创建一个客户端Socket对象，构造方法中绑定服务器的ip地址和端口号
        Socket socket = new Socket("127.0.0.1",8888);
        //3、使用Socket获得网络字节输出流
        OutputStream osN = socket.getOutputStream();
        //4、使用本地字节输入流，read方法，读取本地文件
        byte[] data = new byte[1024*1024];
        int len = 0;
        //5、使用网络字节输出流，write方法，把读取到的文件上传到服务器
        while ((len = in.read(data)) != -1){
            osN.write(data,0,len);
        }
        socket.shutdownOutput();
        //6、使用Socket中的网络字节输入流对象，
        InputStream inN = socket.getInputStream();
        //7、使用网络字节输入流对象read读入服务器端回写的数据
         while ((len = inN.read(data)) != -1){
            //5、使用网络字节输出流，write方法，把读取到的文件上传到服务器
            System.out.println(new String(data,0,len));
        }
        //8、释放资源，网络流，本地流
        in.close();
        socket.close();

    }
}
