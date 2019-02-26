package Day26.Test;

//使用super调用父类属性；
class Person3{
    public String words = "爸爸";

}
class Student3 extends Person3{
    public String words = "儿子";
    public void print(){
        System.out.println(super.words);
        System.out.println(this.words);
    }
}
public class Test3 {
    public static void main(String[] args) {
        new Student3().print();
    }
}
