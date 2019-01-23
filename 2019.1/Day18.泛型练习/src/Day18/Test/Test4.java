package Day18.Test;

class Cat{
    public <T> void test(T t){
        System.out.println(t);
    }
}
public class Test4 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.test("hello");
        cat.test(666);
        cat.test(66.66);
    }
}
