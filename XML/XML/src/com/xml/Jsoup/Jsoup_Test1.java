package com.xml.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.File;
import java.io.IOException;
/**
 * @author Dangxuchao
 * @Title: Jsoup_Test1
 * @ProjectName XML
 * @Description: jsoup快速入门
 * @date 2019/8/5 13:07
 */
public class Jsoup_Test1 {
    public static void main(String[] args) throws IOException {
        //2、获取document对象,基于一个xml文档来获取
        //2.1、获取student.xml的path路径
        String path = Jsoup_Test1.class.getClassLoader().getResource("student.xml").getPath();
        //2.2、解析文档，就是加载文档进内存，获取dom树--》document
        Document document = Jsoup.parse(new File(path),"UTF-8");

        //3、获取元素的对象
        //比如说获取tom
        Elements elements = document.getElementsByTag("name");

        System.out.println(elements.size());
        //3.1、获取第一个name的Element对象
        Element element = elements.get(0);
        //3.2、获取数据
        String name = element.text();
        System.out.println(name);
    }
}
