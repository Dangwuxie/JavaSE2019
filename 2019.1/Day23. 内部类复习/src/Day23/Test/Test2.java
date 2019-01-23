package Day23.Test;

class Outter2{
    private String word = "helloworld";
    public void test(){
        Inner2 inner2 = new Inner2(this);
        inner2.fun();
    }
    public String getWord(){
        return this.word;
    }
}
class Inner2{
    private Outter2 outter2;
    public Inner2(Outter2 outter2){
        this.outter2 = outter2;
    }
    public void fun(){
        System.out.println(outter2.getWord());
    }
}
public class Test2 {
    public static void main(String[] args) {
        Outter2 outter2 = new Outter2();
        outter2.test();
    }
}
