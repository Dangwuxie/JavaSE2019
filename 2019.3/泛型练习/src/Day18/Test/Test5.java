package Day18.Test;
//泛型接口

interface Person5<T>{
    void print(T t);
}
class Student<T> implements Person5<T>{
    @Override
    public void print(T t) {
        System.out.println(t);
    }
}
class Boss implements Person5<String>{
    @Override
    public void print(String s) {
        System.out.println(s);
    }
}
public class Test5 {
    public static void main(String[] args) {
        Student<Integer> student = new Student<>();
        student.print(666);
        Boss boss = new Boss();
        boss.print("123456");
    }
}
