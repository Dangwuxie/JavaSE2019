package Day18.Test;


class InheritableThreadLocalExt7 extends InheritableThreadLocal{
    @Override
    protected Object initialValue() {
        return "0000";
    }

    @Override
    protected Object childValue(Object parentValue) {
        return "7777";
    }
}
class Tools7 {
    public static InheritableThreadLocalExt7 t7 = new InheritableThreadLocalExt7();
}

//自定义一个线程类
class ThreadA7 extends Thread{
    @Override
    public void run() {
        try{
            for (int i = 0;i < 4;i++){
                System.out.println(" 在线程A中取值 = "+Tools7.t7.get());
                Thread.sleep(100);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
public class Test7 {
    public static void main(String[] args) {
        try{
            for (int i = 0;i < 4;i++){
                System.out.println("在主线程中取得值 = "+Tools7.t7.get());
                Thread.sleep(100);
            }
            Thread.sleep(2000);
            ThreadA7 threadA7 = new ThreadA7();
            threadA7.start();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
/*
    运行结果：

    在主线程中取得值 = 0000
    在主线程中取得值 = 0000
    在主线程中取得值 = 0000
    在主线程中取得值 = 0000
     在线程A中取值 = 7777
     在线程A中取值 = 7777
     在线程A中取值 = 7777
     在线程A中取值 = 7777

     由运行结果可以看出方法childValue修改了父线程中取得的值；
 */