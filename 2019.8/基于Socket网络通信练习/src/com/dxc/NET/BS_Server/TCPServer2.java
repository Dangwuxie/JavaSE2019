package com.dxc.NET.BS_Server;


import java.io.*;
import java.net.*;

/**
 * @author 灵魂编程者
 * @Title: TCPServer
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/8/23 0:46
 */
/*
* 创建一个BS版本TCP服务器
* */
public class TCPServer2 {
    public static void main(String[] args) throws IOException {
        while (true){
            //创建服务器
            ServerSocket serverSocket = new ServerSocket(8080);
            //获取请求端Socket对象
            Socket socket = serverSocket.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        //获取网络字节输入流
                        InputStream isN = socket.getInputStream();
                        //读取浏览器端，输入的内容
           /* byte[] data = new byte[1024*1024];
            int len = 0;
            while ((len=isN.read(data)) != -1){
                System.out.println(new String(data,0,len));
            }*/

                        //把siN转换成字符缓存输入流对象，中间有个字符输入流


                        BufferedReader br =  new BufferedReader(new InputStreamReader(isN));
                        //然后把请求信息第一行读取出来get行,就是第一行
                        //String line2 = URLEncoder.encode(InputStreamReader,"utf8");
                        String readlin = br.readLine();
                        System.out.println(readlin);
                        String line = URLDecoder.decode(readlin,"UTF-8");
                        System.out.println(line);
                        //切割获取请求文件路径
                        String[] arr = line.split(" ");//先根据空格来切割

                        //然后去掉中间一部分的“\”
                        String htmlPath = arr[1].substring(1);
                        System.out.println(htmlPath);
                        //下面创建一个本地字节输入流，读取html路径
                        FileInputStream fileInputStream = new FileInputStream("D:\\Github\\JavaSE2019\\"+htmlPath);
                        //使用Socket方法，获得网络字节输出流，回写给浏览器端
                        OutputStream outN = socket.getOutputStream();
                        //D:\Github\JavaSE2019\基于Socket网络通信练习\web\index.html
                        // 写入HTTP协议响应头,固定写法
                        outN.write("HTTP/1.1 200 OK\r\n".getBytes());
                        outN.write("Content‐Type:text/html\r\n".getBytes());
                        // 必须要写入空行,否则浏览器不解析
                        outN.write("\r\n".getBytes());

                        //然后就可以开始一读一写了，回写文件到客户端
                        int len = 0;
                        byte[] data = new byte[1024*1024];
                        while ((len=fileInputStream.read(data)) !=-1 ){
                            outN.write(data,0,len);
                        }

                        //最后释放资源
                        fileInputStream.close();
                        socket.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        //serverSocket.close();

    }
}
