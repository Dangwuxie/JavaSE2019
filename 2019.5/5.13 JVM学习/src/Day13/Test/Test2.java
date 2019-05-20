package Day13.Test;

public class Test2 {
    private static Test2 test2;
    public void isAlive(){
        if (test2 != null){
            System.out.println("还活着--------");
        }
    }
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method execute");
        test2 = this;
    }

    public static void main(String[] args) {
        test2 = new Test2();//此时有GC Roots
        test2 = null;
        System.gc();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (test2 != null){
            test2.isAlive();
        }else {
            System.out.println("对象已死------");
        }
        //第二次会判断死亡，因为finalize方法以及被JVM调用过了；
        //所以此次判断死亡；
        test2 = null;
        System.gc();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (test2 != null){
            test2.isAlive();
        }else {
            System.out.println("对象已死------");
        }
    }
}
