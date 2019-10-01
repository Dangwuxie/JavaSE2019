package com.dxc.NET.FileUpLoad;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * @author 灵魂编程者
 * @Title: UpLoadService
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/8/22 19:18
 */
/*
* 服务端,去读客户端上传的文件，保存到服务器的硬盘上，给客户端回写消息，是否上传成功
* 服务器：
*       数据源：客户端上传的文件
*       目的地：D:\\service\\aaa.jpg，放到D盘下面service文件夹下面
* 实现步骤：
*       1、创建一个服务器ServerSocket对象，向系统指定端口号
*       2、使用ServerSocket对象中的方法accept获取客户端的Socket对象
*       3、使用Socket对象获取网络字节输入流对象，
*       4、首先你需要判断服务器要保存的路径D:\\service存在不存在，如果不存在就创建一个文件夹
*       5、创建一个本地字节输出流对象
*       6、将网络字节输入流读取进来的文件，使用本地字节输出流输出到目标内存中去
*       7、使用socket获得网络字节输出流对象，回写信息，“你已经成功上传到服务器中”
*       8、释放所有资源
*
*
*
* */
public class UpLoadService {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        /*
        * 可以让服务器一直处于监听状态
        * 有一个客户端上传文件，就保存一个文件
        * */

        while (true){
            Socket socket = serverSocket.accept();

            /*
            * 每收到一个上传请求，
            * 就新建一个线程
            * */

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        InputStream inN = socket.getInputStream();
                        File file = new File("D:\\service");
                        if (!file.exists()){
                            file.mkdirs();
                        }
                        //为了放置文件重名被覆盖。可以让每次保存的文件名不重复
                        //规则：域名+时间
                        String fileName = "com."+new Date().getTime()+".jpg";
                        FileOutputStream fos = new FileOutputStream(file+"\\"+fileName);
                        int len = 0;
                        byte[] data = new byte[1024*1024];
                        while ((len = inN.read(data)) != -1){
                            fos.write(data,0,len);
                        }

                        socket.getOutputStream().write("上传成功".getBytes());

                        fos.close();
                        socket.close();
                    }catch (IOException e){
                        System.out.println(e);
                    }
                }
            }).start();

            //serverSocket.close();
        }
    }
}
