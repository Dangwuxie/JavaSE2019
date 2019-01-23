package Day23.Test;
class A{
    private String name = "张三";
    public String getName() {
        return name;
    }
}
class B{
    private int number = 666;
    public int getNumber() {
        return number;
    }
}
class C{
    class InnerA extends A{
        public String name(){
            return super.getName();
        }
    }
    class InnerB extends B{
        public int number(){
            return super.getNumber();
        }
    }
    public String name(){
        return new InnerA().name();
    }
    public int number(){
        return new InnerB().number();
    }
}
public class Test3 {
    public static void main(String[] args) {
        C c = new C();
        System.out.println(c.name());
        System.out.println(c.number());
    }
}
