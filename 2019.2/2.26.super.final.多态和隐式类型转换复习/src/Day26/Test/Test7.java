package Day26.Test;
//多态；向上转型，自动的；
class Person7{
    public void print(){
        System.out.println("Person7的方法");
    }
}
class Student7 extends Person7{
    public void print(){
        System.out.println("Student7的方法");
    }
}
public class Test7 {
    public static void main(String[] args) {
        Person7 person7 = new Person7();
        person7.print();
    }
}
