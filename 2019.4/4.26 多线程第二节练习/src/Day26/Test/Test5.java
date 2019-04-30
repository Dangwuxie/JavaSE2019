package Day26.Test;
//1、设置标志位使线程正常退出
class MyThread5 implements Runnable{
    private boolean flag = true;
    @Override
    public void run() {
        int i = 1;
        while(flag){
            try {
                System.out.println("第"+i+"次执行，线程名称为："+
                Thread.currentThread().getName());
                Thread.sleep(1000);
                i++;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void setFlag(boolean flag){
        this.flag = flag;
    }
}
public class Test5 {
    public static void main(String[] args) throws InterruptedException {
        MyThread5 myThread5 = new MyThread5();
        Thread thread1 = new Thread(myThread5,"子线程A");
        thread1.start();
        Thread.sleep(5000);
        myThread5.setFlag(false);
        System.out.println("main线程结束");
    }
}
