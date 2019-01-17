package Day17.Test;
public class Test2 {

    public static void main(String[] args) throws Exception{
        System.out.println(div(10,0));
        System.out.println("异常之后的代码");
    }
    public static int div(int a,int b) throws Exception{
        return a/b;
    }
}
