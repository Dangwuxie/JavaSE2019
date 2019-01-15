


interface IMsg{
    void printMsg();
}
class MsgImpl implements IMsg{
    public void printMsg(){
        System.out.println("hello world");
    }
}
public class Test10{
    public static void main(String[] args){
        //Object接收数组对象
        Object obj = new int[]{1,2,3,4,5};
        int[] data = (int[]) obj;
        System.out.println(data.length);
        IMsg msg = new MsgImpl();
        Object obj2 = msg;
        IMsg msg1 = (IMsg) obj2;
        System.out.println(obj2);
        msg1.printMsg();
    }
}