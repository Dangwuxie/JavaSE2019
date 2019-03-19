package Day18.Test;
//设置泛型下限

class Week<T>{
    private T t;
    public T getT() {
        return t;
    }
    public void setT(T t) {
        this.t = t;
    }
}
public class Test4 {
    public static void main(String[] args) {
        Week<String> message = new Week<>();
        message.setT("hello world");
        print(message);
    }
    public static void print(Week<? super String> str){
        System.out.println(str.getT());
        str.setT("world");
        System.out.println(str.getT());
    }
}
