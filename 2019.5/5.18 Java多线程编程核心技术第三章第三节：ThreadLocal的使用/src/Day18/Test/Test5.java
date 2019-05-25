package Day18.Test;

import java.util.Date;

/**
 * 验证子线程与父线程之间是否存在私有变量
 *
 */
class Tools5{
    public static ThreadLocalExt5 t5 = new ThreadLocalExt5();
}
class ThreadLocalExt5 extends ThreadLocal{
    @Override
    protected Object initialValue() {
        return new Date().getTime();
    }
}
class Thread5A extends Thread{
    @Override
    public void run() {
        try{
            for (int i = 0;i < 3;i++){
                System.out.println("在线程A中取值："+Tools5.t5.get());
                Thread.sleep(100);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

public class Test5 {
    public static void main(String[] args) {
        try {
            for (int i = 0;i < 3;i++){
                System.out.println("在主线程里取值："+Tools5.t5.get());
                Thread.sleep(100);
            }
            Thread.sleep(2000);
            Thread5A thread5A = new Thread5A();
            thread5A.start();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
/*
    运行结果：

    在主线程里取值：1558796895033
    在主线程里取值：1558796895033
    在主线程里取值：1558796895033
    在线程A中取值：1558796897340
    在线程A中取值：1558796897340
    在线程A中取值：1558796897340

    可以看出父子线程也是各自拥有各自得值；
 */