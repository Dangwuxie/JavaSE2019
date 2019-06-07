package Day01.Test;

/**
 * @author Dangxuchao
 * @Title: Test5
 * @ProjectName 6.1 Java多线程编程核心技术第六章 ：单例模式与多线程
 * @Description: 延迟加载的解决方案2：尝试同步代码块：
 * @date 2019/6/7 9:58
 */


class MyObject5{
    private static MyObject5 myObject5;

    public MyObject5() {
    }
    public static MyObject5 getInstance(){
        try {
            synchronized (MyObject5.class){
                if (myObject5 == null){
                    Thread.sleep(2000);
                    myObject5 = new MyObject5();
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return myObject5;
    }
}
    class Thread5 extends Thread{
        @Override
        public void run() {
            System.out.println(MyObject5.getInstance().hashCode());
        }
    }
    public class Test5 {
    public static void main(String[] args) {
        Thread5 t1 = new Thread5();
        Thread5 t2 = new Thread5();
        Thread5 t3 = new Thread5();
        t1.start();
        t2.start();
        t3.start();
    }
}
/*
运行结果：

    228428496
    228428496
    228428496

 */