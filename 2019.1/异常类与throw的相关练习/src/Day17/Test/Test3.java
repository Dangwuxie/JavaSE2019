package Day17.Test;

public class Test3 {

    public static void main(String[] args){
        try {

            throw new Exception("人为进行异常输出");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int div(int a,int b) throws Exception{
        return a/b;

    }
}
