class IntDemo{
    private int value;
    public IntDemo(int value){
        this.value = value;
    }
    public int intValue(){
        return this.value;
    }
}
public class Test11{
    public static void main(String[] args){
        //将基本类型值封装到类中
        Integer intdemo = new IntDemo(10);
        //将基本类型值从类中取出来
        System.out.println(intdemo.intValue());
    }
}