package Day23.Test;

class Outter{
    private String word = "helloworld";
    class Inner{
        public void fun(){
            System.out.println(word);
        }
    }
    public void test(){
        //实例化内部类对象
        Inner inner = new Inner();
        inner.fun();
    }
}
public class Test1 {

    public static void main(String[] args) {
	    Outter outter = new Outter();
	    outter.test();
    }
}
