package dxc.Spring_Annotation;

/**
 * @author 灵魂编程者
 * @Title: ApplicationTest
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/29 18:37
 */
public class ApplicationTest {

    public static void main(String[] args) {

        System.out.println("application:");
        //创建打印机对象
        MessagePrinter printer = new MessagePrinter();
        //消息服务对象
        MessageService service = new MessageService();
        //设置打印机对象的service属性
        printer.setService(service);
        //打印消息
        printer.printMesage();

    }
}
