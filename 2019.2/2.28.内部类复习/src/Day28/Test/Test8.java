package Day28.Test;
//方法内部类；
class Outter8{
    private int num;
    public void display(int test){
        class NeiBu8{
            private void fun(){
                num++;
                System.out.println(num);
                System.out.println(test);
            }
        }
        new NeiBu8().fun();
    }
}
public class Test8 {

    public static void main(String[] args) {
        Outter8 outter8 = new Outter8();
        outter8.display(666);
    }
}
