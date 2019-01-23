package Day23.Test;

class Waibu{
    private String name = "外部类中的私有属性";
    class Neibu{
        private String name2 = "内部类的私有属性";
        public void fun(){
            System.out.println(name);
        }
    }
}
public class Test5 {
    public static void main(String[] args) {
        Waibu.Neibu neibu = new Waibu().new Neibu();
        neibu.fun();
    }
}
