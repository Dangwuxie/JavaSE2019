package Day23.Test;
//子类对象在进行实例化前一定会首先实例化父类对象，
//默认调用父类的构造方法后再调用子类的构造方法进行子类对象初始化；
class Person6{
    public Person6(){
        System.out.println("Person类对象产生");
    }
    public static void fun(){
        System.out.println("超类的静态方法");
    }
}
class Student6 extends Person6{
    public Student6(){
        System.out.println("Student类对象产生");
    }
}
public class Test6 {
    public static void main(String[] args) {
        Student6 student6 = new Student6();
        student6.fun();
    }
}
