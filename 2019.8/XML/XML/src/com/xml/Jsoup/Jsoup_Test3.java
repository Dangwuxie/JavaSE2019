package com.xml.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;


/**
 * @author Dangxuchao
 * @Title: Jsoup_Test3
 * @ProjectName XML
 * @Description: Document/Element对象功能演示
 * @date 2019/8/5 14:35
 */
public class Jsoup_Test3 {
    public static void main(String[] args) throws IOException {
        //2.1、获取student.xml的path路径
        String path = Jsoup_Test1.class.getClassLoader().getResource("student.xml").getPath();
        //3、获取document对象
        Document document = Jsoup.parse(new File(path),"UTF-8");
        //4、获取元素对象
        //4.1、获取所有name对象，通过标签名称获取
       /* Elements elements = document.getElementsByTag("name");
        System.out.println(elements);*/

       //4.2、获取所有的number对象
        /*Elements elements = document.getElementsByAttribute("id");
        System.out.println(elements);*/

        //4.3、根据指定的属性名称和属性值获取元素对象集合
        /*Elements elements = document.getElementsByAttributeValue("number","adang_0002");
        System.out.println(elements);*/

        Element element = document.getElementById("001");
        System.out.println(element);
    }
}
