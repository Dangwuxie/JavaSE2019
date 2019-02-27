package Day01.Test;
//抽象类只是比普通类多了些抽象方法，抽象类中也允许提供构造方法；
abstract class Person3{
    private String word = "hello world!!!";
    public Person3(){
        System.out.println("抽象类中的构造方法");
    }
    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }
    public abstract void getPersonInfo();
}
class Student3 extends Person3{
    public Student3(){
        System.out.println("子类中的构造方法");
    }
    @Override
    public void getPersonInfo() {
        //空实现；
    }
}
public class Test3 {
    public static void main(String[] args) {
        new Student3();
    }
}
