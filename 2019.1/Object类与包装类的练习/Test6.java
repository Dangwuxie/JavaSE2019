class Person{};
class Student{};
public class Test6{
    public static void main(String[] args){
        fun(new Student());
        fun(new Person());
    }
    public static void fun(Object obj){
        System.out.println(obj);
    }
}