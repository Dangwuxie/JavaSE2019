package Day03.Test;
//抽象类实现接口
interface Imessage4{
    void print();
}
abstract class News4 implements Imessage4{
    public abstract void getNews();
}
class ImessageImpl4 extends News4{
    @Override
    public void getNews() {
        System.out.println("getNews");
    }
    @Override
    public void print() {
        System.out.println("覆写父接口的抽象方法");
    }
}
public class Test4 {
    public static void main(String[] args) {
        Imessage4 m = new ImessageImpl4();
        m.print();
        ((News4) m).getNews();
        ((ImessageImpl4) m).getNews();
        News4 news4 = (News4) m;
        news4.getNews();
    }
}
