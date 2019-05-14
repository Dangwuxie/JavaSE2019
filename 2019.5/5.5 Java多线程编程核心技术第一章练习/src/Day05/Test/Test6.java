package Day05.Test;
//stop方法释放锁导致的后果，数据得不到同步的处理
class SynchronizedObject{
    private Integer age;
    private Integer id;
    public SynchronizedObject(Integer age, Integer id) {
        this.age = age;
        this.id = id;
    }
    public synchronized void printString(Integer age,Integer id){
        try {
            this.age = age;
            Thread.sleep(3000);
            this.id = id;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public Integer getAge() {
        return age;
    }
    public Integer getId() {
        return id;
    }
}
class MyThread6 implements Runnable{
    private SynchronizedObject object;
    public MyThread6(SynchronizedObject object){
        this.object = object;
    }
    @Override
    public void run() {
        object.printString(11,11);
    }
}
public class Test6 {
    public static void main(String[] args) throws InterruptedException {
        SynchronizedObject object = new SynchronizedObject(88,88);
        MyThread6 myThread6 = new MyThread6(object);
        Thread thread = new Thread(myThread6);
        thread.start();
        //注意此处，睡眠的时间为1秒，赋值语句中睡了3秒；
        //所以在同步块里来不及同步数据的时候调用stop方法可以观察到此问题
        Thread.sleep(1000);
        thread.stop();
        System.out.println("age = "+object.getAge()+",id = "+object.getId());
    }
}
