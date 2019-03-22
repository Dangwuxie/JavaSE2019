package Day21.Test;

class Person3{
    private int age;
}
public class Test3 {
    public static void main(String[] args) {
        Class<Test3> cls = Test3.class;
        Class<Person3> person3Class = Person3.class;
        //取得父类Class对象
        System.out.println(cls.getSuperclass());
        System.out.println(person3Class.getSuperclass());
        //取得对象名字
        System.out.println(cls.getSuperclass().getName());
        System.out.println(person3Class.getSuperclass().getName());
        //取得父类的Class对象所在的包
        System.out.println(cls.getSuperclass().getPackage());
        System.out.println(person3Class.getSuperclass().getPackage());
        // System.out.println(cls.getPackage());
        //System.out.println(cls.getPackage().getName());
    }
}
