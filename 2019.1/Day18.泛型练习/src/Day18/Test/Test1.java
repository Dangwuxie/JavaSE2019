package Day18.Test;

class MyClass<T> {
    T t;
    public T getT() { return t; }
    public void setT(T t) { this.t = t; }
}
public class Test1 {
    public static void main(String[] args) {
        MyClass<String> myClass = new MyClass<String>();
        MyClass<Integer> myClass1 = new MyClass<Integer>();
        myClass.setT("张三");
        myClass1.setT(666);
        System.out.println(myClass.getT()+myClass1.getT());
    }
}
