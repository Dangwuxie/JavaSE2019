package com.xml.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * @author Dangxuchao
 * @Title: Jsoup_Test4
 * @ProjectName XML
 * @Description: 选择器查询
 * @date 2019/8/5 15:03
 */
/*
*                               选择器查询
*
* */
public class Jsoup_Test5 {
    public static void main(String[] args) throws IOException {
        //2.1、获取student.xml的path路径
        String path = Jsoup_Test1.class.getClassLoader().getResource("student.xml").getPath();
        //3、获取document对象
        Document document = Jsoup.parse(new File(path),"UTF-8");

        //查询name标签
        //使用标签选择器
        Elements elements = document.select("name");
        System.out.println(elements);
        System.out.println("---------------------");
        Elements elements1 = document.select("#001");
        System.out.println(elements1);

        /*
        * 获取student下的number属性值为adang——0001的子标签age
        * */
        //5.1，第一步
        Elements elements2 = document.select("student[number=\"adang_0001\"]");
        System.out.println("------------------");
        System.out.println(elements2);
        //5.2、获取它的子标签
        System.out.println("------------------");
        Elements elements3 = document.select("student[number=\"adang_0001\"] > age");
        System.out.println(elements3);

    }
}
