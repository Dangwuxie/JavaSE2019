package Day28.Test;
//静态内部类，类比静态方法；
class WaiBu7{
    private static String name = "hello world";
    static class NeiBu7{
        public void print(){
            System.out.println(name);
        }
        public void print1(){
            System.out.println("china!!!");
        }
    }
}
public class Test7 {
    public static void main(String[] args) {
        WaiBu7.NeiBu7 neiBu7 = new WaiBu7.NeiBu7();
        neiBu7.print();
    }
}
