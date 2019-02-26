package Day26.Test;

//super调用父类的普通方法；
class Person2{
    public void print(){
        System.out.println("父类的方法");
    }
}
class Student2 extends Person2{
    public void print(){
        super.print();
        System.out.println("子类的方法");
    }
}
public class Test2 {
    public static void main(String[] args) {
        new Student2().print();
    }
}
