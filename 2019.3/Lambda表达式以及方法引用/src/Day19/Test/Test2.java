package Day19.Test;
//引用对象方法
interface Person<P>{
    P switchPara();
}
public class Test2 {
    public static void main(String[] args) {
        Person<String> person = "hello"::toUpperCase;
        //这就等同于"hello".toUpperCase();
        System.out.println(person.switchPara());
    }
}
