package Day19.Test;

interface IInterface{
    void test();
    default void print(){
        System.out.println("接口中所所有子类对象都有此方法");
    }
    static void fun(){
        System.out.println("接口的静态方法");
    }
}

class InterfaceImpl implements IInterface{
    public void test(){};
}
public class Test7 {
    public static void main(String[] args) {
        IInterface iInterface = new InterfaceImpl();
        iInterface.print();
        IInterface.fun();
    }
}
