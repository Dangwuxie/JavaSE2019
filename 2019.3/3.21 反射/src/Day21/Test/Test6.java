package Day21.Test;
//反射调用构造方法；
import java.lang.reflect.Constructor;
class Person6{
    private String name;
    private int age;
    public Person6() {
    }
    Person6(String name) {
        this.name = name;
    }
    private Person6(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
public class Test6 {
    public static void main(String[] args) throws NoSuchMethodException {
        Class<Person6> cls = Person6.class;
        Constructor constructors = cls.getConstructor();
        System.out.println(constructors);
        Constructor constructors1 = cls.getDeclaredConstructor(String.class);
        System.out.println(constructors1);
        Constructor constructors3 = cls.getDeclaredConstructor(String.class,int.class);
        System.out.println(constructors3);

       /* for (Constructor o:constructors){
            System.out.println(o);
        }*/
       /* System.out.println("------------------------------------");
        Constructor[] constructors2 = cls.getDeclaredConstructors();
        for (Constructor o:constructors2){
            System.out.println(o);
        }*/
    }
}
