package Day28.Test;

class Outer2{
    private String words = "helloword";
    public String getWords() {
        return words;
    }
    public void fun(){
        Inner2 inner2 = new Inner2(this);
        inner2.print();
    }
}
class Inner2{
    Outer2 outer2 ;
    public Inner2(Outer2 outer2){
        this.outer2 = outer2;//引用传递；
    }
    public void print(){
        System.out.println(outer2.getWords());
    }
}
public class Test2 {
    public static void main(String[] args) {
        Outer2 outer2 = new Outer2();
        outer2.fun();
    }
}
