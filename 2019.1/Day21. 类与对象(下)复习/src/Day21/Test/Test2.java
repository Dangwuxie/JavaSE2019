package Day21.Test;

class Person{
    public Person(){
        System.out.println("1、Person的构造方法");
    }
    {
        System.out.println("2、Person类的构造块");
    }
}
public class Test2 {
    public static void main(String[] args) {
        new Person();
        new Person();
    }
}
