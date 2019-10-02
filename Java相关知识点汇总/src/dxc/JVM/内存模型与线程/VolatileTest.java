package dxc.JVM.内存模型与线程;

/**
 * @author 灵魂编程者
 * @Title: VolatileTest
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/2 11:28
 */
public class VolatileTest {

    public static volatile int race = 0;

    public static void increase(){
        race++;
    }
    /*
    *  字节码指令
       public static void increase();
       Code:
       0: getstatic     #2                  // Field race:I
       3: iconst_1
       4: iadd
       5: putstatic     #2                  // Field race:I
       8: return
    * */

    private static final int THREADS_COUNT=30;
    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];

        for (int i=0;i<THREADS_COUNT;i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0;i<1000;i++){
                        increase();
                    }
                }
            });
            threads[i].start();
        }
        //public static int activeCount()
        //返回当前线程的thread group及其子组中活动线程数的估计。
        while (Thread.activeCount() > 2){
            Thread.yield();
        }

        System.out.println(race);
    }
}
