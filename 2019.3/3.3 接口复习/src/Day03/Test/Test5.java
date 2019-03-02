package Day03.Test;
//接口之间实现多继承；
interface A{
    void fun1();
}
interface B{
    void fun2();
}
interface C extends A,B{
    @Override
    void fun1();
    @Override
    void fun2();

    void fun3();
}
class Impl implements C{
    @Override
    public void fun1() {
        System.out.println("fun1");
    }
    @Override
    public void fun2() {
        System.out.println("fun2");
    }

    @Override
    public void fun3() {
        System.out.println("fun3");
    }
}
public class Test5 {
    public static void main(String[] args) {
        C c = new Impl();
        c.fun1();
        c.fun2();
        c.fun3();
    }
}
