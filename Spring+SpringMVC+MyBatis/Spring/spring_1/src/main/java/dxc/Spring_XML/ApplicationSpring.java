package dxc.Spring_XML;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 灵魂编程者
 * @Title: ApplicationTest
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/29 18:37
 */
//基于注解的方法来初始化spring容器
//组件扫描，扫描所有有Component注解的类

public class ApplicationSpring {

    public static void main(String[] args) {
        System.out.println("XML_SpringApplication...");

        //初始化spring容器
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //获取MessagePrinter对象
        MessagePrinter printer = context.getBean(MessagePrinter.class);
        //打印输出
        printer.printMesage();


    }
}
