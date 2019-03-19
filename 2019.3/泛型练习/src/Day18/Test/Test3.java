package Day18.Test;

class Apple<T extends Number>{
    private T t;
    public T getT() {
        return t;
    }
    public void setT(T t) {
        this.t = t;
    }
}
public class Test3 {
    public static void main(String[] args) {
        Apple<Integer> apple = new Apple<>();
        Apple<Double>apple1 = new Apple<>();
        apple.setT(222);
        apple1.setT(22.22);
        print(apple);
        print(apple1);
    }
    public static void print(Apple<? extends Number> apple){
        System.out.println(apple.getT());
    }
}
