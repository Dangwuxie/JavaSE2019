package dxc.Spring_Annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 灵魂编程者
 * @Title: MessagePrinter
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/29 18:34
 */

@Component
public class MessagePrinter {

    public MessagePrinter() {
        super();
        System.out.println("MessagePrinter...");
    }

    /*
    * 建立类和类之间的关联关系
    * */
    private MessageService service;
    //代表将自动调用setService这个方法
    //也就是说MessageService和MessagePrinter之间的关联关系已经被spring所管理了；
    @Autowired
    public void setService(MessageService service) {
        this.service = service;
    }

    public void printMesage(){
        System.out.println(this.service.getMessage());
    }

}
