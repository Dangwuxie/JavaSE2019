package dxc.Spring_Annotation;

import org.springframework.stereotype.Component;

/**
 * @author 灵魂编程者
 * @Title: MessageService
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/29 18:32
 */

/*
* 简单的打印输出
* */
//此注解的作用就是通知spring容器以后的MessageService对象由spring容器来创建，不需要new了；
@Component
public class MessageService {

    public MessageService() {
        super();
        System.out.println("MessageService...");
    }

    /*执行打印功能*/
    public String getMessage(){
        return "Spring_Annotation,world";
    }
}
