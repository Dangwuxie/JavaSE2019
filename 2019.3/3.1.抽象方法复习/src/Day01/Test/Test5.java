package Day01.Test;
//内部抽象类；
abstract class A5{
    public abstract void print();
    static abstract class B5{
        public abstract void fun();
    }
}
class C5 extends A5{
    @Override
    public void print() {
        System.out.println("覆写后的外部抽象类");
    }
    class E5 extends B5{
        @Override
        public void fun() {
            System.out.println("覆写后的内部方法");
        }
    }
}
public class Test5 {
    public static void main(String[] args) {
        C5 c5 = new C5();
        c5.print();
        C5.E5 e5 = new C5().new E5();
        e5.fun();
    }
}
