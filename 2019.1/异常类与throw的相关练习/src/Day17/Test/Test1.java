package Day17.Test;

public class Test1 {

    public static void main(String[] args){
        try {
            System.out.println(div(10,0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("异常之后的代码");
    }
    public static int div(int a,int b) throws Exception{
        return a/b;
    }
}
