package Day02.Test;

/**
 * @author Dangxuchao
 * @Title: Test3
 * @ProjectName 6.2 Java多线程核心编程第七章：查漏补缺
 * @Description: 3、验证BLOCKED：此状态出现在某个线程等待锁的时候：
 * @date 2019/6/7 12:03
 */
class MyService{
    synchronized static public void serviceMethod(){
        try{
            System.out.println(Thread.currentThread().getName()
                    +"进入了业务方法！");
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
class Thread3A extends Thread{
    @Override
    public void run() {
        MyService.serviceMethod();
    }
}
class Thread3B extends Thread{
    @Override
    public void run() {
        MyService.serviceMethod();
    }
}

public class Test3 {
    public static void main(String[] args) {
        Thread3A thread3A = new Thread3A();
        thread3A.setName("A");
        thread3A.start();
        Thread3B thread3B = new Thread3B();
        thread3B.setName("B");
        thread3B.start();
        System.out.println("main方法中t2状态："+thread3B.getState());
    }
}
