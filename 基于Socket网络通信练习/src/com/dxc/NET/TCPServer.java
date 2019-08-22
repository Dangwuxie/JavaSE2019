package com.dxc.NET;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 灵魂编程者
 * @Title: TCPServer
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/8/22 17:05
 */
/*
* java.net.ServerSocket;此类实现服务器套接字。服务器套接字等待请求通过网络传入。
* TCP通信的服务器端，需要读取客户端发送的数据，需要给客户端回写数据；
* 必须要知道是哪个客户端所请求的服务器，可以使用accept方法获取到客户端对象
*
* 构造方法：（服务器端启动的时候需要向系统申请指定的端口号）
*       1、ServerSocket(int port) ：创建绑定到特定端口的服务器套接字。
*       2、Socket accept() ：侦听并接受到此套接字的连接。
*
* 服务器的实现步骤：
*       1、创建服务器ServerSocket对象和系统要指定的端口号
*       2、使用对象的方法accept，获取到请求的客户端Socket对象
*       3、使用Scoket对象获取InputStream网络字节输入流对象
*       4、使用网络字节输入流InputStream对象中的方法read()，读取客户端发送的数据；
*       5、使用Socket对象获取OutputStream流对象，使用write方法给客户端回写发出数据；
*       6、关闭流
*
* */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        //1、创建服务器ServerSocket对象和系统要指定的端口号
        ServerSocket ss = new ServerSocket(8888);
        //2、使用对象的方法accept，获取到请求的客户端Socket对象
        Socket socket = ss.accept();
        //3、使用Scoket对象获取InputStream网络字节输入流对象
        InputStream is = socket.getInputStream();
        //4、使用网络字节输入流InputStream对象中的方法read()，读取客户端发送的数据；
        byte[] data = new byte[1024];
        int i = is.read(data);
        System.out.println(new String(data,0,i));




        //5、使用Socket对象获取OutputStream流对象，使用write方法给客户端回写发出数据；
        OutputStream os = socket.getOutputStream();
        os.write("收到，谢谢！！".getBytes());
        //6、关闭流
        socket.close();
        ss.close();
    }
}
