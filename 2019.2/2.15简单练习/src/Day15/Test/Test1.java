package Day15.Test;

class Abb implements Runnable{
    private int i = 0;
    @Override
    public void run(){
        try{
            while(true){
                i++;
                System.out.println("线程名称："+Thread.currentThread().getName()+",i="+i+",是否为守护线程："
                        +Thread.currentThread().isDaemon());
                Thread.sleep(1000);
            }
        }catch(InterruptedException e){
            System.out.println("线程名称："+Thread.currentThread().getName()+
                    "中断线程了");
        }
    }
}
public class Test1 {
    public static void main(String[] args) throws InterruptedException{
        Thread thread1 = new Thread(new Abb(),"子线程A");
        thread1.setDaemon(true);
        thread1.start();
        Thread thread2 = new Thread(new Abb(),"子线程B");
        thread2.start();
        Thread.sleep(3000);
        thread2.interrupt();
        Thread.sleep(3000);
        System.out.println("代码结束");
    }
}
