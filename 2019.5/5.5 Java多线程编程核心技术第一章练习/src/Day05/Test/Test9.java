package Day05.Test;
//suspend/resume的缺点，独占锁
class SynchronizedObject9{
    public synchronized void printString(){
        System.out.println("当前线程为："+Thread.currentThread().getName());
        System.out.println("下面停止了-----");
        Thread.currentThread().suspend();
    }

}
public class Test9 {
    public static void main(String[] args) throws InterruptedException {
        SynchronizedObject9 s9 = new SynchronizedObject9();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                s9.printString();
            }
        };
        t1.start();
        Thread.sleep(2000);
        //此处要是恢复，线程B就可以进入该同步方法；
        //t1.resume();
        Thread t2 = new Thread(){
            @Override
            public void run() {
                System.out.println("Thread2启动，但是进入不了printString同步方法--");
                System.out.println("因为printString方法被A线程锁定了，永远的暂停在了该线程的该方法里面");
                s9.printString();
            }
        };
        t2.start();
    }
}
