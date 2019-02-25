package Day23.Test;
//继承的定义与使用；
class Person5{
    private String name;
    private int age;
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
class Student extends Person5{
    private String country;
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
}
public class Test5 {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("张三");
        student.setAge(666);
        student.setCountry("美国");
        System.out.println("姓名 "+student.getName()
        +"年龄 "+student.getAge()
        +"国籍 "+student.getCountry());
    }
}
