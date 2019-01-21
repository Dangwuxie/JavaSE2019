package Day21.Test;

class Person1{
    public static int num;
    public Person1(){
        System.out.println("1、Person类的构造方法");
    }
    {
        System.out.println("2、Person类的构造块");
    }
    static {
        System.out.println("3、Person类的静态块");
    }
}
public class Test3 {
    public static void main(String[] args) {
        new Person1();
        new Person1();
    }
}
