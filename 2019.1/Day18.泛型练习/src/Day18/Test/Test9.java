package Day18.Test;

import java.util.Objects;

class Green<T>{
    private T t;
    public T getT() { return t; }
    public void setT(T t) { this.t = t; }
}
public class Test9 {
    public static void main(String[] args) {
        Green<Object> green = new Green<>();
        fun(green);
    }
    public static void fun(Green<? super String> green){
        green.setT("hello");
        System.out.println(green.getT());
    }
}
