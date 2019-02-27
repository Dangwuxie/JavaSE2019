package Day28.Test;
//内部类的简单定义；
class Outer{
    private String words = "helloword";
    class Inner{
        public void print(){
            System.out.println(words);
        }
    }
    public void fun(){
        Inner inner = new Inner();
        inner.print();
    }
}
public class Test1 {

    public static void main(String[] args) {
	    Outer outer = new Outer();
	    outer.fun();
    }
}
