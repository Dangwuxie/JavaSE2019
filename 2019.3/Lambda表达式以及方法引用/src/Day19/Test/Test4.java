package Day19.Test;
//引用构造方法
class Person4{
    private String name;
    private Integer age;
    //实际上这个构造方法又返回了一个Person对象；
    //返回值就是Person对象；
    public Person4(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return age + "   " +name;
    }
}
//所以此处要使用方法引用的话要使用3个泛型；
interface Personnal<P,PI,PT>{
    P creatPerson(PI pi,PT pt);
}
public class Test4 {
    public static void main(String[] args) {
        Personnal<Person4,String,Integer> person = Person4::new;
        //因为person指向的构造方法返回的是一个Person4对象，所以要用对象来接收
        Person4 person4 = person.creatPerson("张三",666);
        System.out.println(person4.toString());
    }
}
