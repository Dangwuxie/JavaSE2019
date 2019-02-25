package Day23.Test;
//方法的覆写；
class Person7{
    public void fun(){
        System.out.println("Person类的fun方法");
    }
}
class Student7 extends Person7{
    public void fun(){
        System.out.println("Student类覆写的方法");
    }
}
public class Test7 {
    public static void main(String[] args) {
        new Student7().fun();
    }
}
