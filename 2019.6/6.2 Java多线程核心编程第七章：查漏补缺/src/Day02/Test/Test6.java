package Day02.Test;

/**
 * @author Dangxuchao
 * @Title: Test6
 * @ProjectName 6.2 Java多线程核心编程第七章：查漏补缺
 * @Description: 使线程具有有序性；
 * 正常情况下线程在运行时多个线程之间执行任务的时机是无序的，
 * 可以通过改造代码的方式使他们有序：
 *
 * @date 2019/6/7 22:22
 */

class Thread6 extends Thread{
    private Object lock;
    private String showChar;
    private int showNum;
    private int printCount = 0;//统计打印了几个字母
    private volatile static int addNumber = 1;

    public Thread6(Object lock, String showChar, int showNum) {
        this.lock = lock;
        this.showChar = showChar;
        this.showNum = showNum;
    }
    @Override
    public void run() {
        try{
            synchronized (lock){
                while (true){
                    if (addNumber % 3 == showNum){
                        System.out.println("线程名字="
                                +Thread.currentThread().getName()
                                +"run方法计数："+addNumber+" "+showChar);
                        lock.notifyAll();
                        addNumber++;
                        printCount++;
                        if (printCount == 2){
                            break;
                        }
                    }else {
                        lock.wait();
                    }
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
public class Test6 {
    public static void main(String[] args) {
        Object lock = new Object();
        Thread6 a = new Thread6(lock,"A",1);
        Thread6 b = new Thread6(lock,"B",2);
        Thread6 c = new Thread6(lock,"C",0);
        a.start();
        b.start();
        c.start();
    }
}
