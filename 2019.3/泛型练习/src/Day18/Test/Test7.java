package Day18.Test;
//观察类型擦除

import java.lang.reflect.Field;

class myClass7<T,E extends Number>{
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
public class Test7 {
    public static void main(String[] args) {
        myClass7<String,Integer> myClass7 = new myClass7<>();
        java.lang.Class<? extends Day18.Test.myClass7> cls = myClass7.getClass();
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields){
            System.out.println(field.getType());
        }
    }
}
