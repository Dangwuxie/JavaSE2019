package dxc.JVM.内存模型与线程;

/**
 * @author 灵魂编程者
 * @Title: VolatileTest2
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/3 16:41
 */
public class VolatileTest2 {

    public static volatile boolean flag = true;
    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;){
                    System.out.println(flag);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;){
                    flag = false;
                }
            }
        });

        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();

    }
}
