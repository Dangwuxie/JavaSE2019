package dxc.JVM.内存模型与线程;

/**
 * @author 灵魂编程者
 * @Title: VolatileTest2
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/3 16:41
 */
public class VolatileTest2 {

    public static volatile boolean flag1 = false;

    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(!flag1){
                }
                System.out.println("flag已经被修改了！");
            }
        }).start();

        Thread.sleep(2000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                fun();
            }
        }).start();

    }
    public static void fun(){
        System.out.println("开始修改");
        flag1 = true;
        System.out.println("修改完成");
    }
}
