package Day02.Test;

/**
 * @author Dangxuchao
 * @Title: Test5
 * @ProjectName 6.2 Java多线程核心编程第七章：查漏补缺
 * @Description: 2.1、线程对象关联线程组：1级关联
 * 一级关联：父对象中有子对象，但并不创建子孙对象；
 * @date 2019/6/7 22:00
 */

class Thread5A extends Thread{
    @Override
    public void run() {
        try{
            while(!Thread.currentThread().isInterrupted()){
                System.out.println("A线程名字："
                        +Thread.currentThread().getName());
                Thread.sleep(2000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();;
        }
    }
}
class Thread5B extends Thread{
    @Override
    public void run() {
        try{
            while(!Thread.currentThread().isInterrupted()){
                System.out.println("B线程名字："
                        +Thread.currentThread().getName());
                Thread.sleep(2000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();;
        }
    }
}
public class Test5 {
    public static void main(String[] args) {
        Thread5A thread5A = new Thread5A();
        Thread5B thread5B = new Thread5B();
        ThreadGroup threadGroup = new ThreadGroup("000线程组：");
        Thread aThread = new Thread(threadGroup,thread5A);
        Thread bThread = new Thread(threadGroup,thread5B);
        aThread.start();
        bThread.start();
        System.out.println("活动的线程数为："+threadGroup.activeCount());
        System.out.println("线程组的名称为: "+threadGroup.getName());
    }
}
