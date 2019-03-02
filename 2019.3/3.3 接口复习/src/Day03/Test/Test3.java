package Day03.Test;
//当一个子类既需要继承抽象类又要实现接口时，
//先继承然后在实现接口；
interface Imessage3{
    void fun();
}
abstract class Person{
    public abstract void print3();
}
class Student extends Person implements Imessage3{
    @Override
    public void fun() {
        System.out.println("覆写接口中的抽象方法");
    }
    @Override
    public void print3() {
        System.out.println("覆写抽象父类中的抽象方法");
    }
}
public class Test3 {
    public static void main(String[] args) {
        /*tudent student = new Student();
        student.fun();
        student.print3();*/
        //当父类与父接口有共同子类时，两者可以转换；
        Imessage3 imessage3 = new Student();
        imessage3.fun();
        Person person = (Person) imessage3;
        person.print3();
    }
}
