package Day18.Test;

import java.util.Date;

/**
 * 再次验证数据的隔离性
 */
class Tools3{
    public static ThreadLocal<Date> t3 = new ThreadLocal<Date>();
}

class Thread3A extends Thread{
    @Override
    public void run() {
        try{
            for (int i = 0;i < 3;i++){
                if (Tools3.t3.get() == null){
                    Tools3.t3.set(new Date());
                }
                System.out.println("A线程 "+Tools3.t3.get().getTime());
                Thread.sleep(2200);
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
class Thread3B extends Thread{
    @Override
    public void run() {
        try{
            for (int i = 0;i < 3;i++){
                if (Tools3.t3.get() == null){
                    Tools3.t3.set(new Date());

                }
                System.out.println("B线程 "+Tools3.t3.get().getTime());
                Thread.sleep(2100);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
public class Test3 {
    public static void main(String[] args) {
        try{
            Thread3A a = new Thread3A();
            a.start();
            Thread.sleep(1000);
            Thread3B b = new Thread3B();
            b.start();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
/*
    运行结果：

    A线程 1558794878574
    B线程 1558794879576
    A线程 1558794878574
    B线程 1558794879576
    A线程 1558794878574
    B线程 1558794879576

 */