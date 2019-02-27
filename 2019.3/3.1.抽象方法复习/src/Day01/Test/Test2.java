package Day01.Test;
//抽象类的还有以下这种形式；
//通过方法内部类来覆写抽象类的方法；
abstract class Person2{
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public abstract void getPersonInfo();

    public static Person2 getInstance(){
        class Student2 extends Person2{
            @Override
            public void getPersonInfo() {
                System.out.println("i am a students!!!");
            }
        }
        return new Student2();//此处返回一个实例化的子类对象；会发生自动向上转型；
    }
}
public class Test2 {
    public static void main(String[] args) {
        Person2 person2 = Person2.getInstance();
        person2.getPersonInfo();
    }
}
