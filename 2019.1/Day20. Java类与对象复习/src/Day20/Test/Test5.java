package Day20.Test;

class Fruit{
    public void print(){
        System.out.println("Fruit类的对象"+this);
    }
}
public class Test5 {
    public static void main(String[] args) {
        Fruit fruit1 = new Fruit();
        fruit1.print();
        System.out.println("main方法中的："+fruit1);
        System.out.println("###############################");
        Fruit fruit2 = new Fruit();
        fruit2.print();
        System.out.println("main方法中的："+fruit2);
    }
}
