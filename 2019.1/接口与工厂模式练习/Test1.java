//接口中只有全局常量，和抽象方法。
interface IMessage{
    public static final String MSG = "java";
    public abstract void fun();
}
interface INews{
    public abstract void getMsg();
}
class MessageImpl implements IMessage,INews{
    public void fun(){
        System.out.println(MSG);
    }
    public void getMsg(){
        System.out.println(MSG);
    }
}
public class Test1{
    public static void main(String[] args){
        //接口的使用原则：
        //虽然是new的子类，但是new的是IMessage的对象，所以只能使用IMessage中的方法。
        IMessage msg = new MessageImpl();
        msg.fun();
        //若想使用getMsg(),可以再new一个
        // Inews news = new MessageImpl();
        // news.getMsg();
        //或者也可以这样
        //父接口的相互转换
        //前提条件是两者有共同的子类。
        INews news = (INews) msg;
        news.getMsg();
    }
}