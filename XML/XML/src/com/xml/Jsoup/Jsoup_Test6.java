package com.xml.Jsoup;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Dangxuchao
 * @Title: Jsoup_Test4
 * @ProjectName XML
 * @Description: 选择器查询
 * @date 2019/8/5 15:03
 */
/*
*                              Xpath查询
*
* */
public class Jsoup_Test6 {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        //1、获取student.xml的path路径
        String path = Jsoup_Test1.class.getClassLoader().getResource("student.xml").getPath();
        //2、获取document对象
        Document document = Jsoup.parse(new File(path),"UTF-8");

        //3、根据document对象创建JXDocument对象
        JXDocument jxDocument = new JXDocument(document);
        //4、结合Xpath来查询

       List<JXNode>jxNodes = jxDocument.selN("//student");
        for (JXNode jxNode:jxNodes){
            System.out.println(jxNode);
        }
        System.out.println("---------------------------");
        //4.2、查询所有student下的name标签
        List<JXNode>jxNodes2 = jxDocument.selN("//student/name");
        for (JXNode jxNode:jxNodes2){
            System.out.println(jxNode);
        }
        System.out.println("---------------------------");
        //4.3、查询student标签下带有id属性的name标签
        List<JXNode>jxNodes3 = jxDocument.selN("//student/name[@id]");
        for (JXNode jxNode:jxNodes3){
            System.out.println(jxNode);
        }
        System.out.println("---------------------------");
        //4.4、查询student标签下带有id属性值name标签，并且id属性值为
        List<JXNode>jxNodes4 = jxDocument.selN("//student/name[@id='020']");
        for (JXNode jxNode:jxNodes4){
            System.out.println(jxNode);
        }
    }
}
