package com.dxc.NET;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author 灵魂编程者
 * @Title: TCPClient
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 *
 * TCP通信的客户端，向服务器发送连接请求，
 * 给服务器发送数据，读取服务器回写的数据
 *
 * java.net.Socket  此类实现客户端套接字（也可以就叫“套接字”）。
 * 套接字是两台机器间通信的端点。
 * 套接字就是，包含了ip地址和端口号的网络单位
 *构造方法：
 * Socket(String host, int port)
 *           创建一个流套接字并将其连接到指定主机上的指定端口号。
 *           host代表服务器主机的名称，也可以传送服务器的ip地址
 *           port代表服务器的端口号
 *
 * 成员方法：
 * getInputStream() 返回此套接字的输入流。
 * getOutputStream() 返回此套接字的输出流。
 * close() 关闭此套接字。
 * @date 2019/8/22 16:23
 */
/*
*实现步骤：
*   1、创建一个客户端对象Socket，构造方法绑定服务器的ip和端口号，
*   2、使用Socket对象中的方法getOutputStream()获取网络字节输出流OutputStream对象，
*   3、使用此输出流里面的方法write给服务器发送数据
*   4、使用Socket对象中的方法getInputStream()获取网络字节输入流对象InputStream对象
*   5、使用网络字节输入流中的方法read读取服务器回写的数据
*   6、关闭io流；释放资源
*  注意事项：1、客户端跟服务器端交互必须使用Socket，提供的网络流，不能使用自己创建的流对象；
*           2、当我们创建客户端对象Socket的时候，就会去请求双方服务器经过三次握手从而建立连接
*               如果服务器没有启动，就会抛出java.net.ConnectException异常；
*               如果已经启动，那么就可以进行交互；
* */
//客户端的实现
public class TCPClient {
    public static void main(String[] args) throws IOException {
        //1、创建一个客户端对象Socket，构造方法绑定服务器的ip和端口号，
        Socket socket = new Socket("127.0.0.1",8888);
        //2、使用Socket对象中的方法getOutputStream()获取网络字节输出流OutputStream对象，
        OutputStream out = socket.getOutputStream();
        //3、使用此输出流里面的方法write给服务器发送数据
        out.write("你好服务器".getBytes());

        //4、使用Socket对象中的方法getInputStream()获取网络字节输入流对象InputStream对象
        //5、使用网络字节输入流中的方法read读取服务器回写的数据
        InputStream is = socket.getInputStream();
        byte[] data = new byte[1024];
        int len = is.read(data);
        System.out.println(new String(data,0,len));

        //6、关闭io流；释放资源
        socket.close();


    }

}
