package Day23.Test;

class Tiger{
    private String name = "huhu";
    public void display(final int num){
        //方法内部类
        class Inner3{
            public void fun(){
                System.out.println(name);
                System.out.println(num);
            }
        }
        new Inner3().fun();
    }
}
public class Test7 {
    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        tiger.display(20);
    }
}
