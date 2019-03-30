package Day02.Test;


import java.io.InputStream;

class CloseTest1 implements AutoCloseable{
    @Override
    public void close() throws Exception {
        System.out.println("自动调用close方法");
    }
    public void fun(){
        System.out.println("普通方法");
    }
}
public class Test1 {

    public static void main(String[] args) {
	// write your code here
        try(CloseTest1 closeTest1 = new CloseTest1()) {
            closeTest1.fun();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
