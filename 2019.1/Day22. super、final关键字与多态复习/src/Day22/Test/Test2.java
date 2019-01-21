package Day22.Test;

class Person1{
    private String name;
    private int age;
    public Person1(String name){
        this.name = name;
    }
    public Person1(String name,int age){
        this.name = name;
        this.age = age;
    }
}
class Son1 extends Person1{
    public Son1(){
        //隐藏语句
        super("张三");
        System.out.println("2、子类的构造方法");
    }
}
public class Test2 {
    public static void main(String[] args) {
        Son1 son1 = new Son1();
    }
}
