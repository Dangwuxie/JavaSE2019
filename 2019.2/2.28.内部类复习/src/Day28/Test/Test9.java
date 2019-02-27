package Day28.Test;
//匿名内部类；
interface MyInterface{
    void test();
}
class Outer9{
    private int num ;
    public void display(int para){
        //匿名内部类，实现了MyInterface接口；
        new MyInterface(){
            @Override
            public void test() {
                System.out.println("匿名内部类"+para);
            }
        }.test();
    }
}
public class Test9 {
    public static void main(String[] args) {
        Outer9 outer9 = new Outer9();
        outer9.display(666);
    }
}
