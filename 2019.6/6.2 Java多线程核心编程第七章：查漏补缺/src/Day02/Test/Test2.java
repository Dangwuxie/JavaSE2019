package Day02.Test;

/**
 * @author Dangxuchao
 * @Title: Test2
 * @ProjectName 6.2 Java多线程核心编程第七章：查漏补缺
 * @Description: 验证TIMED_WAITING：
 * 此状态代表了执行Thread.sleep的方法，呈等待状态；
 * @date 2019/6/7 11:58
 */

class Thread2 extends Thread{
    @Override
    public void run() {
        try{
            System.out.println("开始睡眠");
            Thread.sleep(1000);
            System.out.println("睡眠结束");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
public class Test2 {
    public static void main(String[] args) {
        try{
            Thread2 t = new Thread2();
            t.start();
            Thread.sleep(1000);
            System.out.println("main方法中的状态："
                    +t.getState());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
