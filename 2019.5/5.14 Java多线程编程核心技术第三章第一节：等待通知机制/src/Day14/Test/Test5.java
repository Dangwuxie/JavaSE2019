package Day14.Test;

/**
 * notify通知过早的情况；
 * 如果过早通知，那么呈wait状态的线程将不会被唤醒；一直等待下去=
 */

class MyRun{
    private String anyThing = new String();
    public Runnable runnableA = new Runnable() {
        @Override
        public void run() {
            try {
                synchronized (anyThing){
                    System.out.println("wait开始");
                    anyThing.wait();
                    System.out.println("wait结束");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
    public Runnable runnableB = new Runnable() {
        @Override
        public void run() {
            synchronized (anyThing){
                System.out.println("notify方法开始");
                anyThing.notify();
                System.out.println("notify方法结束");
            }
        }
    };
}
public class Test5 {
    public static void main(String[] args) {
        MyRun myRun = new MyRun();
        /**
         * 先启动线程B的话线程A就不会被唤醒；
         * 反之却可以；
         * notify方法开始
         * notify方法结束
         * wait开始
         */
        new Thread(myRun.runnableB).start();
        new Thread(myRun.runnableA).start();

    }
}
