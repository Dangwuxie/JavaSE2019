package dxc.JVM;

/**
 * @author 灵魂编程者
 * @Title: FinalizeEscapeGC
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/23 0:25
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC finalizeEscapeGC;

    public void isAlive(){
        System.out.println("我还活着！！");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize方法依旧存在！");
        //把自己赋值给
        finalizeEscapeGC = this;
    }

    public static void main(String[] args) throws Exception {
        finalizeEscapeGC = new FinalizeEscapeGC();
        //new一个对象后指向null
        finalizeEscapeGC = null;
        System.gc();//回收上面new的对象

        Thread.sleep(500);
        //判断是否自己调用了覆写后的finalized方法
        if (finalizeEscapeGC!=null){
            finalizeEscapeGC.isAlive();
        }else {
            System.out.println("当前对象已经死亡");
        }

        //再次gc并且自救
        System.out.println("////////////////////////////////");
        finalizeEscapeGC = null;
        System.gc();

        Thread.sleep(500);

        if (finalizeEscapeGC!=null){
            finalizeEscapeGC.isAlive();
        }else {
            System.out.println("当前对象已经死亡");
        }

    }
}
/*
    finalize方法依旧存在！
    我还活着！！
    ////////////////////////////////
    当前对象已经死亡
*/