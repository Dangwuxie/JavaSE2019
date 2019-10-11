package dxc.JVM.虚拟机类加载机制.被动引用的例子;

/**
 * @author 灵魂编程者
 * @Title: NotInitialzation3
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/11 20:38
 */
/*
* 被动引用3：
* 引用改类中的常量，该常量在编译阶段已经放入调用类的常量池中，
* 本质上并不是直接引用到了定义该常量的类
* */

class ConstClass{
    static{
        System.out.println("类的静态块");
    }

    public static final String HELLOWORLD = "HELLO WORLD";
}
public class NotInitialzation3 {
    public static void main(String[] args) {
        System.out.println(ConstClass.HELLOWORLD);

    }
}
