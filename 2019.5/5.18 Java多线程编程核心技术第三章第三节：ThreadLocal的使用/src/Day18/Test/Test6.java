package Day18.Test;

import java.util.Date;

/**
 * 类InheritableThreadLocal的使用：
 * 使用该类可以让子线程从父线程中取得值；
 */

class InheritableThreadLocalExt extends InheritableThreadLocal{
    @Override
    protected Object initialValue() {
        return new Date().getTime();
    }
}
class Tools6 {
    public static InheritableThreadLocalExt t1 = new InheritableThreadLocalExt();
}

//自定义一个线程类
class ThreadA6 extends Thread{
    @Override
    public void run() {
        try{
            for (int i = 0;i < 5;i++){
                System.out.println("在线程A中取值 = "+Tools6.t1.get());
                Thread.sleep(100);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
public class Test6 {
    public static void main(String[] args) {
        try{
            for (int i = 0;i < 5;i++){
                System.out.println("在主线程中取得值 = "+Tools6.t1.get());
                Thread.sleep(100);
            }
            Thread.sleep(2000);
            ThreadA6 threadA6 = new ThreadA6();
            threadA6.start();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
/*
    运行结果：

    在主线程中取得值 = 1558797748836
    在主线程中取得值 = 1558797748836
    在主线程中取得值 = 1558797748836
    在主线程中取得值 = 1558797748836
    在主线程中取得值 = 1558797748836
    在线程A中取值 = 1558797748836
    在线程A中取值 = 1558797748836
    在线程A中取值 = 1558797748836
    在线程A中取值 = 1558797748836
    在线程A中取值 = 1558797748836

    可以看出父子线程由同一个InheritableThreadLocal实例对象
    取得的值是同一个；
 */