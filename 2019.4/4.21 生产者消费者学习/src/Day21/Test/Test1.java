package Day21.Test;

public class Test1 {

    public static void main(String[] args) throws InterruptedException {

        Object object = new Object();
        //synchronized (object) {
            System.out.println("等待中");
            object.wait();
            System.out.println("等待已过");
        //}
        System.out.println("main方法结束");
    }

}
