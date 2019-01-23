package Day23.Test;

class Outer1{
    static class Iner1{
        public void test(){
            System.out.println("********************");
        }
    }
}
public class Test6 {
    public static void main(String[] args) {
        Outer1.Iner1 iner1 = new Outer1.Iner1();
        iner1.test();
    }
}
