package com.xml.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author Dangxuchao
 * @Title: Jsoup_Test2
 * @ProjectName XML
 * @Description: Jsoup对象的一个功能
 * @date 2019/8/5 13:53
 */
public class Jsoup_Test2 {
    public static void main(String[] args) throws IOException {

        //2.1、获取student.xml的path路径
        String path = Jsoup_Test1.class.getClassLoader().getResource("student.xml").getPath();
        //2.2、解析文档，就是加载文档进内存，获取dom树--》document
        /*Document document = Jsoup.parse(new File(path),"UTF-8");
        System.out.println(document);*/

        /*
            2\parse(String html):解析xml或者html字符串的

        */
       /* String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "\n" +
                " <students  >\n" +
                "\t\t<student number=\"heima_0001\">\n" +
                "\t\t\t<name>zhangsan</name>\n" +
                "\t\t\t<age>232</age>\n" +
                "\t\t\t<sex>male</sex>\n" +
                "\t\t</student>\n" +
                "\t<student number=\"heima_0002\">\n" +
                "\t\t<name>jack</name>\n" +
                "\t\t<age>22</age>\n" +
                "\t\t<sex>female</sex>\n" +
                "\t</student>\n" +
                " </students>";
        Document document = Jsoup.parse(str);
        System.out.println(document);*/

       /*
       *
       * 3\parse(File in,String charsetName):解析xml或者html文件
       * */

        URL url = new URL("https://www.baidu.com/");
        Document document = Jsoup.parse(url,10000);
        System.out.println(document);
    }
}
