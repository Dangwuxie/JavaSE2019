package Day23.Test;

class Person6{
    private String name;
    private int age;
    public Person6(){
        System.out.println("*******************");
    }
    public Person6(String name) {
        this();
        this.name = name;
    }
    public Person6(String name, int age) {
        this(name);
        this.age = age;
    }
    public String getPersonInfo(){
        return "姓名"+name+".年龄"+age;
    }
}
public class Test6 {
    public static void main(String[] args) {
        Person6 person6 = new Person6();
        Person6 person61 = new Person6("张三");
        Person6 person62 = new Person6("李四",666);
        System.out.println(person6.getPersonInfo());
        System.out.println(person61.getPersonInfo());
        System.out.println(person62.getPersonInfo());
    }
}
