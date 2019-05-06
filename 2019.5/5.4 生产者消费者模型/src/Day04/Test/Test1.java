package Day04.Test;
//线程wait方法
public class Test1 {

    public static void main(String[] args) {
	    Object obj = new Object();
	    synchronized(obj){
            System.out.println("wait线程开始");
            try {
                obj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("wait线程结束");

        }
    }
}
