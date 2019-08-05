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
 * @Description: TODO
 * @date 2019/8/5 15:03
 */
public class Jsoup_Test4 {
    public static void main(String[] args) throws IOException {
        //2.1、获取student.xml的path路径
        String path = Jsoup_Test1.class.getClassLoader().getResource("student.xml").getPath();
        //3、获取document对象
        Document document = Jsoup.parse(new File(path),"UTF-8");

        /*
        * 4  Element：元素对象
                1、获取element对象，获取子元素对象，子类Document对象的方法：
                    getElementById(String id)：此方法需要属性值的名字必须叫做id才可以查出来；
                            根据id属性值获取唯一的(系统自己的值，唯一值)element对象
                    getElementsByTag(String TagName):根据标签名称获取元素对象集合
                    getElementsByAttribute(String key):根据属性名称获取元素对象集
                    getElementsByAttributeValue(String key,String value):
                            根据对应的属性名和属性值获取元素对象集合
                2、获取属性值
                    String attr(String key):根据属性名称获取属性值
                3、获取文本内容
                    String text()：获取文本内容；
                    String html():获取标签体的所有内容，包括子标签的字符串内容；
        *
        * */

        /*Elements elements = document.getElementsByTag("name");
        System.out.println(elements.size());*/

        /*
        * 通过element对象获取子标签对象
        * */

        Element element_student = document.getElementsByTag("student").get(1);
        Elements ele_name = element_student.getElementsByTag("name");
       // System.out.println(ele_name.size());
        //System.out.println(ele_name);


        /*获取一下属性值
        * 获取student对象的属性值
        * */

        String number = element_student.attr("number");
        //System.out.println(number);

        /*
        * 获取文本内容
        * */

        String text1 = element_student.text();
        String html1 = element_student.html();
        String html2 = ele_name.html();
        String text2 = ele_name.text();
        System.out.println(html1);
        System.out.println("--------------------------------------------------");
        System.out.println(html2);//后面两个打印出来的是子标签name下的文本；
        System.out.println("--------------------------------------------------");
        System.out.println(text1);//打印出来的是student标签下的文本内容
        System.out.println("--------------------------------------------------");
        System.out.println(text2);



    }
}
