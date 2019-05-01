package Day26.Test;
//调用interrupt方法来停止线程；可见上的例子；
class MyThread6 implements Runnable{
    private boolean flag = true;
    @Override
    public void run() {
        int i = 1;
        while (flag){
            try {
                Thread.sleep(1000);
                boolean bool = Thread.currentThread().isInterrupted();
                if (bool){
                    System.out.println("非阻塞情况下执行该操作"+bool);
                    break;
                }
                System.out.println("第 "+i+" 次执行,线程名字为："
                        +Thread.currentThread().getName());
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("退出了");
                boolean bool = Thread.currentThread().isInterrupted();
                System.out.println(bool);
                //退出run方法，中断进程
                return;
            }
        }
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
public class Test6 {
    public static void main(String[] args) throws InterruptedException {
        MyThread6 myThread6 = new MyThread6();
        Thread thread = new Thread(myThread6);
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
        System.out.println("代码结束");
    }
}
