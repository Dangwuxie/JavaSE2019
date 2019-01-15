class Person{
    private String name;
    private int age;
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    public String toString(){
        return "姓名："+this.name+"年龄："+this.age;
    }
}
public class Test8{
    public static void main(String[] args){
        fun(new Person("张三",22));
        fun("Hello");
    }
    public static void fun(Object obj){
        System.out.println(obj);
        System.out.println(obj.toString());

    }
}