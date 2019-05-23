package Day16.Test;

/**
 * 方法join(long)的使用；
 * 参数设定等待的时间；
 */

class MyThread4 extends Thread{
    @Override
    public void run() {
        try {
            System.out.println("开始时间为："+System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("这句话代表子线程5秒执行完了；"+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Test4 {
    public static void main(String[] args) {
        try {
            MyThread4 myThread4 = new MyThread4();
            myThread4.start();
            myThread4.join(2000);
            System.out.println("结束时间为："+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


/*运行结果：
    开始时间为：1558622128672
    结束时间为：1558622130670
    这句话代表子线程5秒执行完了；1558622133672

    可以观察出子线程只执行了两秒，接下来就是主线程执行;
    主线程执行完了后继续子线程执行完后面三秒；
    */
