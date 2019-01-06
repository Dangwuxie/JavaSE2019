interface A{
    void fun1();
}
interface B{
    void fun2();
}
interface C extends A,B{
    void fun3();
}
abstract class CImpl implements C{
    
}
class Test extends CImpl implements C{
    public void fun1(){}
    public void fun2(){}
    public void fun3(){}
}
public class Test4{
    public static void main(String[] args){
        C c = new CImpl();
        c.fun1();
        c.fun2();
        c.fun3();
    }
}