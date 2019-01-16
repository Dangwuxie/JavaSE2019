package Jan.Day16;
//懒汉式单例模式
class Singleton{
    //首先，类中提供一个对象；
    private static Singleton singleton = new Singleton();
    //静态方法
    public static Singleton getsingleton(){
        return singleton;
    }
}
public class Test1{
    public static void main(String[] args){
        Singleton singleton1 = Singleton.getsingleton();
        Singleton singleton2 = Singleton.getsingleton();
        System.out.println(singleton1 == singleton2);
    }
}