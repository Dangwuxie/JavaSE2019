package Day23.Test;

//构造块，定义在类中的代码块；
//不加任何修饰符
class Person2{
    {
        System.out.println("类中的代码块，构造块");
    }
    public Person2(){
        System.out.println("Person类的构造方法");
    }
}
public class Test2 {
    public static void main(String[] args) {
        new Person2();
        new Person2();
    }
}
