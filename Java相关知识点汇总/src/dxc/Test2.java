package dxc;

/**
 * @author 灵魂编程者
 * @Title: Test2
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/25 20:50
 */

public class Test2 {
    public static int i = 1;
    public static char ch = 'A';
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (i<=52){
                    try {
                        if (i<10){
                            System.out.print(i);
                            i++;
                            System.out.print(i);
                        }
                        if (i>10){
                            System.out.print(i);
                            i++;
                            System.out.print(i);
                        }
                        i++;
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                if (i<=52){
                    System.out.print((char) ch);
                    ch+=1;
                    t1.notify();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
