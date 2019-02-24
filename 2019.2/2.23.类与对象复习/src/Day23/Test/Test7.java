package Day23.Test;

class Person7{
    public void fun(){
        System.out.println("当前对象的地址："+this);
    }
}
public class Test7 {
    public static void main(String[] args) {
        Person7 person7 = new Person7();
        System.out.println("MAIN方法中的对象地址："+person7);
        person7.fun();
        System.out.println("#####################");
        Person7 person71 = new Person7();
        System.out.println("MAIN方法中的对象地址："+person71);
        person71.fun();
    }
}
