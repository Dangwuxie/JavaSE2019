package Day23.Test;

class Person3{
    private String name;
    private int age;

    public Person3(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
public class Test3 {
    public static void main(String[] args) {
       /* Person3 person3 = new Person3();
        person3.setAge(20);
        person3.setName("张三");
        System.out.println(person3.getAge());
        System.out.println(person3.getName());*/
        /* 使用构造方法初始化对象属性参数 */
        Person3 person31 = new Person3(33,"李四");
        System.out.println(person31.getAge());
        System.out.println(person31.getName());
    }
}
