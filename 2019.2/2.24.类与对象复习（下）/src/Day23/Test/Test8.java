package Day23.Test;

class Person8{
    public void fun(){
        this.print();
    }
    //此时父类使用private定义了print方法，
    //就表示该方法只能被父类使用，子类无法使用，
    //子类根本不知道父类有这样的方法；
    private void print(){
        System.out.println("父类中的私有属性");
    }
}
class Student8 extends Person8{
    //子类中的print方法仅仅是子类定义的新方法而已，
    // 并没有和父类的方法有任何关系；
    public void print(){
        System.out.println("子类中的同名方法");
    }
}
public class Test8 {
    public static void main(String[] args) {
        new Student8().fun();
    }
}
