package Day18.Test;

class Work<T>{
    public T method1(T t){ return t; }
    public <T> T method2(T t){ return t; }
}
public class Test5 {
    public static void main(String[] args) {
        Work<String> work = new Work<>();
        System.out.println(work.method1("hello"));
        System.out.println(work.method2(222));
    }
}
