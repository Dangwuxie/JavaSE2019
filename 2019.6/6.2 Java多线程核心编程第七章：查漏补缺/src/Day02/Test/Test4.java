package Day02.Test;


/**
 * @author Dangxuchao
 * @Title: Test4
 * @ProjectName 6.2 Java多线程核心编程第七章：查漏补缺
 * @Description: 4、验证WAITING：此状态是线程执行了Object.wait()方法后所处的状态；
 * @date 2019/6/7 12:10
 */
class Lock{
    public static final Byte lock = new Byte("0");
}
class Thread4 extends Thread{
    @Override
    public void run() {
        try{
            synchronized (Lock.lock){
                Lock.lock.wait();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
public class Test4 {
    public static void main(String[] args) {
        try {
            Thread4 t4 = new Thread4();
            t4.start();
            Thread.sleep(1000);
            System.out.println("main方法中的t的状态："+t4.getState());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
/*
    运行结果：
    main方法中的t的状态：WAITING
 */