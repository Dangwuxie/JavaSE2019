package Day21.Test;


interface Imessage{}
interface INews{}
class MyClass implements Imessage,INews{ }

public class Test4 {
    public static void main(String[] args) {
        Class<Test4> cls = Test4.class;
        Class[] classes = MyClass.class.getInterfaces();
        for (Class cls1 : classes){
            System.out.println(cls1);
        }
    }
}
