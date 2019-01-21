package Day21.Test;

class Pig{
    default void fun(){
        System.out.println("父类的方法");
    }
}
class Peiqi{
    public void fun(){
        System.out.println("子类的覆写方法");
    }
}
public class Test7 {
    public static void main(String[] args) {
        Peiqi peiqi = new Peiqi();
        peiqi.fun();
    }
}
