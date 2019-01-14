class Person{
    private String name;
    private int age;
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
}
public class Test7{
    public static void main(String[] args){
        fun(new Person("张三",22));
        fun("hehe");
    }
    public static void fun(Object obj){
        System.out.println(obj.toString());
    }
}