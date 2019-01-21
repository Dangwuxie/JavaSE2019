package Day22.Test;

class Person{
    public Person(){
        System.out.println("1、父类的构造方法");
    }
}
class Son extends Person{
    public Son(){
        //隐藏语句
        super();
        System.out.println("2、子类的构造方法");
    }
}
public class Test1 {
    public static void main(String[] args) {
	    Son son = new Son();
    }
}
