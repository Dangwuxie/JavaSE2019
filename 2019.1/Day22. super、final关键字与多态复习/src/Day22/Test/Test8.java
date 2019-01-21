package Day22.Test;

class China{
    public void print(){
        System.out.println("China的方法");
    }
}
class ShanXi extends China{
    public void print(){
        System.out.println("ShanXi的方法");
    }
}
class BaoJi extends China{
    public void print(){
        System.out.println("Baoji的方法");
    }
}
public class Test8 {
    public static void main(String[] args) {
        fun(new China());
        fun(new ShanXi());
        fun(new BaoJi());
    }
    public static void fun(China china){
        china.print();
    }
}
