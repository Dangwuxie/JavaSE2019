package Jan.Day16;
//懒汉式单例模式
class Singleton{
    //类加载时产生
    private static Singleton singleton;
    //静态方法
    public static Singleton getsingleton(){
        if(singleton == null){
            singleton = new Singleton();
        }
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