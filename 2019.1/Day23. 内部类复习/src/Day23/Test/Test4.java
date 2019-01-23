package Day23.Test;

class Outer{
    private String name = "Outer的私有属性";
    class Iner{
        private String name1 = "Iner的私有属性";
        public void fun(){
            System.out.println(name);
        }
    }
    public void test(){
        Iner in = new Iner();
        System.out.println(in.name1);
    }
}
public class Test4 {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.test();
    }
}
