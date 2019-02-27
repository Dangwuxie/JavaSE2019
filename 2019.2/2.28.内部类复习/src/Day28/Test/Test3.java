package Day28.Test;

class Outer3{
    private String words = "China hello";
    private class Inner3{
        public void fun(){
            System.out.println("私有内部类的方法");
        }
    }
    public String getWords() {
        return words;
    }
}
public class Test3 {
    public static void main(String[] args) {

    }
}
