package Day26.Test;
//final关键字；
public class Test5 {
    public static void main(String[] args) {
        fun("张三");
        fun("李四",666);

    }
    public static final void fun(String name){
        System.out.println(name);
    }
    public static void fun(String name, int age){
        System.out.println(name);
        System.out.println(age);
    }
}
