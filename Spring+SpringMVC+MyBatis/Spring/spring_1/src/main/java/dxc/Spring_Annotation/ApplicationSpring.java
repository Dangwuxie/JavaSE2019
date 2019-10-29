package dxc.Spring_Annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 灵魂编程者
 * @Title: ApplicationTest
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/29 18:37
 */
//基于注解的方法来初始化spring容器
//组件扫描，扫描所有有Component注解的类
@ComponentScan
public class ApplicationSpring {

    public static void main(String[] args) {

        System.out.println("applicationSpring:");
        //初始化spring容器
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ApplicationSpring.class);

        //从容器中获取两个MessagePrinter\MessageService对象
        MessagePrinter printer = context.getBean(MessagePrinter.class);
        //service这个对象也没有不必要获取了
        //MessageService service = context.getBean(MessageService.class);
        System.out.println(printer);
        //System.out.println(service);

        //设置打印机对象的service属性
        //此关联关系的创建也是可以由spring来完成的
        //printer.setService(service);
        //打印消息
        printer.printMesage();

    }
}
