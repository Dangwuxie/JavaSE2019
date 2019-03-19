package Day18.Test;

class MyClass<T,E>{
    private T t;
    private E e;
    public T getT() {
        return t;
    }
    public void setT(T t) {
        this.t = t;
    }
    public E getE() {
        return e;
    }
    public void setE(E e) {
        this.e = e;
    }
}
class Class<T>{
    public static <T> void fun(T t){
        System.out.println(t);
    }

}
public class Test1 {

    public static void main(String[] args) {
	// write your code here
        Class<String> stringClass = new Class<>();
        stringClass.fun(454);
        new MyClass<>();
        MyClass myClass1 = new MyClass<>();
        myClass1.setT("name");
        myClass1.setE(10);
        System.out.println(myClass1.getT());
        System.out.println(myClass1.getE());
        Class.fun(555);
        Class.fun("sss");
        Class.fun(33.33);

    }
}
