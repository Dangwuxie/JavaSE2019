interface IMessage{
    String MSG = "jsvs";
    void play();
}
abstract class News{
    public abstract void fun();
}
class MessageImpl extends News implements IMessage{
    public void play(){
        System.out.println(MSG);
    }
    public void fun(){
        System.out.println(MSG);
    }
}
public class Test3{
    public static void main(String[] args){
        IMessage msg = new MessageImpl();
        msg.play();
        //抽象类与接口也可以相互转换，前提是拥有同一个子类；
        News news = (News) msg;
        news.fun();
    }
}