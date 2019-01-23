package Day18.Test;

class Dog<T,E>{
    private T x;
    private E y;
}
public class Test3 {
    public static void main(String[] args) {
        Dog<String,String> dog = new Dog<String, String>();
        Dog<Integer,String> dog1 = new Dog<Integer, String>();
    }
}
