package Day18.Test;

interface IInterface<T>{ T test(T t);}
class InterImpl implements IInterface<String>{
    @Override
    public String test(String s) {
        return s;
    }
}
public class Test10 {
    public static void main(String[] args) {
        InterImpl interimpl = new InterImpl();
        System.out.println(interimpl.test("wangjo "));
    }
}
