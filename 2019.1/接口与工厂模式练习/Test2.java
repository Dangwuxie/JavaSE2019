interface IMessage{
    static final String MSG = "hello";
    void play();
}
class MessageImpl implements IMessage{
    public void play(){
        System.out.println(MSG);
    }
}
public class Test2{
    public static void main(String[] args){
        IMessage msg = new MessageImpl();
        msg.play();
    }
}