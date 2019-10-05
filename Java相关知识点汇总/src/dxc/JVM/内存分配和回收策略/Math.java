package dxc.JVM.内存分配和回收策略;

/**
 * @author 灵魂编程者
 * @Title: Math
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/5 13:54
 */
public class Math {

    public static int initdata = 66;

    public int compute(){
        int a = 1;
        int b = 2;
        int c = (a+b)*10;
        return c;
    }

    public static void main(String[] args) {
        Math math = new Math();
        math.compute();
    }
}
