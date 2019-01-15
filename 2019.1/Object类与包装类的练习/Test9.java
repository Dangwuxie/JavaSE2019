
class Person{
    private String name;
    private int age;
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    public boolean equals(Object obj){
        //判断地址是否相等
        if(this == obj){
            return true;
        }
        //判断传入的对象是否是Person对象
        if(!(obj instanceof Person)){
            return false;
        }
        //传入的是person对象并且地址不相等；
        //向下转型脱掉小马甲，要比较Person的属性是否先相等；
        Person per = (Person) obj;
        return per.name.equals(this.name) && per.age == this.age;
    }
}
public class Test9{
    public static void main(String[] args){
        Person per1 = new Person("张三",212);
        Person per2 = new Person("张三",212);
        System.out.println(per1.equals(per2));
    }
}