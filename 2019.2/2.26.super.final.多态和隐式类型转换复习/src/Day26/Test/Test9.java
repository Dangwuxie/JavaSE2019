package Day26.Test;

//instance关键字检查当前引用是否指向目标类；
class Person9{}
class Person91 extends Person9{}
public class Test9 {
    public static void main(String[] args) {
        Person9 person9 = new Person9();
        System.out.println(person9 instanceof Person9);
        System.out.println(person9 instanceof Person91);
    }
}
