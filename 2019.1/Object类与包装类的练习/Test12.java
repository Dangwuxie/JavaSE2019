class IntDemo{
    private int value;
    public IntDemo(int value){
        this.value = value;
    }
    public int intValue(){
        return this.value;
    }
}
public class Test12{
    public static void main(String[] args){
        //自动装箱
        Integer intdemo = 10;
        //自动拆箱
        System.out.println(intdemo);
    }
}