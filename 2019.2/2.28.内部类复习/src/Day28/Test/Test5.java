package Day28.Test;
//举例：内部类可以直接访问外部类的元素；
class Outer5{
    private String words = "hello world  china";
    private int number = 6666666;
    class Inner5{
        public Inner5(){
            Outer5.this.words = "i am a student!!!";
            Outer5.this.number = 77777;
        }
        public void print(){
            System.out.println(words);
            System.out.println(number);
        }
    }
}
public class Test5 {
    public static void main(String[] args) {
        Outer5.Inner5 inner5 = new Outer5().new Inner5();
        inner5.print();
    }
}
