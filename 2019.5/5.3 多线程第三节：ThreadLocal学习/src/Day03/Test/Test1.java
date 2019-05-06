package Day03.Test;

import java.lang.ref.WeakReference;

//ThreadLocal类的简单使用；
public class Test1 {
    private static String commStr;
    private static ThreadLocal<String> threadStr =
            ThreadLocal.withInitial(()->{
                return "中国";
            });

    public static void main(String[] args) {
        System.out.println("初始化的值："+threadStr.get());
        commStr = "main";
        threadStr.set("main");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("新线程："+threadStr.get());
                commStr = "thread";
                threadStr.set("thread");
                System.out.println("新线程："+threadStr.get());
                threadStr.remove();
                System.out.println("新线程："+threadStr.get());
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(commStr);
        System.out.println(threadStr.get());

    }
}
