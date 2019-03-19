package Day18.Test;
//观察类型擦除

class Person6<T>{
    private T t;

    public T getT() {
        return t;
    }
    public void setT(T t) {
        this.t = t;
    }
}
public class Test6 {
    public static void main(String[] args) {
        Person6<String> person6 = new Person6<>();
        Person6<Integer> person61 = new Person6<>();
        System.out.println(person6.getClass() == person61.getClass());
    }
}
