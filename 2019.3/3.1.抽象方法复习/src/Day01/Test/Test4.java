package Day01.Test;
//如果父类没有无参构造，那么子类构造必须使用super明确指出
//使用的是父类的哪个构造方法；
abstract class A{
    public A(){
        this.print();
    }
    public abstract void print();
}
class B extends A{
    private int num = 666;
    public B(int num){
        this.num = num;
    }
    @Override
    public void print() {
        System.out.println(this.num);
    }
}
public class Test4 {
    public static void main(String[] args) {
        new B(333);
    }
}
