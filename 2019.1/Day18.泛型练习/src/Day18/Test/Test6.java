package Day18.Test;
//通配符

class Red<T> {
    T t;
    public T getT() { return t; }
    public void setT(T t) { this.t = t; }
}
public class Test6 {
    public static void main(String[] args) {
        Red<String> red = new Red<>();
        red.setT("hello");
        Red<Integer> red1 = new Red<>();
        red1.setT(6666);
        print(red);
        print(red1);
    }
    public static void print(Red<?> red){
        System.out.println(red.getT());
    }
}
