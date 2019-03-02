package Day03.Test;

interface Imessage{
    public final static String words = "张三";
    public abstract void print();
}
interface Inews{
    public abstract String getNews();
}
class MessageImpl implements Imessage,Inews{
    @Override
    public void print() {
        System.out.println(Imessage.words);
    }
    @Override
    public String getNews() {
        return Imessage.words;
    }
}
public class Test1 {
    public static void main(String[] args) {
        Imessage imessage = new MessageImpl();
        imessage.print();
        Inews inews = (Inews) imessage;
        System.out.println(inews.getNews());
    }
}
