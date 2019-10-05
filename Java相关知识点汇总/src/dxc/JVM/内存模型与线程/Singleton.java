package dxc.JVM.内存模型与线程;

/**
 * @author 灵魂编程者
 * @Title: Singleton
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/3 15:18
 */
public class Singleton {
    private volatile static Singleton instance;

    public static Singleton getInstance(){
        if (instance == null){
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton.getInstance();
    }
}
