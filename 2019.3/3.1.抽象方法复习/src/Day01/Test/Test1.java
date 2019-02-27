package Day01.Test;
//抽象类的定义与使用；
abstract class Person{
    private String name;//属性
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public abstract void getPersonInfo();//抽象方法；
}
class Student extends Person{
    public void getPersonInfo(){
        System.out.println("i am a student!!");
    }
}
public class Test1 {

    public static void main(String[] args) {
        Person person = new Student();//实例化子类，向上转型
        person.getPersonInfo();//被子类覆写过的方法；
    }
}
