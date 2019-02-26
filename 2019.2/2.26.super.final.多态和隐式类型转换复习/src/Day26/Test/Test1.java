package Day26.Test;

//super关键字练习；
//使用super来调用父类的同名方法；
class Person{
    public Person(){
        System.out.println("父类中的方法");
    }
}
class Student extends Person{
    public Student(){
        //super.print();//隐藏语句调用；
        System.out.println("子类中的方法");
    }
}
public class Test1 {
    public static void main(String[] args) {
        new Student();
    }
}
