package Day01.Test;

/**
 * @author Dangxuchao
 * @Title: Test4
 * @ProjectName 6.1 Java多线程编程核心技术第六章 ：单例模式与多线程
 * @Description: 给getInstance方法加上synchronized关键字解决多线程下的懒汉模式问题
 * @date 2019/6/7 9:39
 */
class MyObject4{
    private static MyObject4 myObject4;

    public MyObject4() {
    }
    public synchronized static MyObject4 getInstance(){
        try {
            if (myObject4 == null){
                Thread.sleep(2000);
                myObject4 = new MyObject4();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return myObject4;
    }
}
class Thread4 extends Thread{
    @Override
    public void run() {
        System.out.println(MyObject4.getInstance().hashCode());
    }
}
public class Test4 {
    public static void main(String[] args) {
        Thread4 t1 = new Thread4();
        Thread4 t2 = new Thread4();
        Thread4 t3 = new Thread4();
        t1.start();
        t2.start();
        t3.start();
    }
}
