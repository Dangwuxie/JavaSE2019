package Day26.Test;
//多态；向下转型，强制的；
class Person8{
    public void print(){
        System.out.println("Person7的方法");
    }
}
class Student8 extends Person8{
    public void print(){
        System.out.println("Student7的方法");
    }
    public void fun(){
        System.out.println("儿子独有的方法");
    }
}
public class Test8 {
    public static void main(String[] args) {
        Person8 person8 = new Student8();
        Student8 student8 = (Student8) person8;
        student8.print();
        student8.fun();
    }
}
