package dxc.Spring_XML;



/**
 * @author 灵魂编程者
 * @Title: MessagePrinter
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/29 18:34
 */


public class MessagePrinter {

    public MessagePrinter() {
        super();
        System.out.println("MessagePrinter...");
    }


    private MessageService service;


    public void setService(MessageService service) {
        this.service = service;
    }

    public void printMesage(){
        System.out.println(this.service.getMessage());
    }

}
