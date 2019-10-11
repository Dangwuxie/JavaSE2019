package dxc.JVM.虚拟机类加载机制.被动引用的例子;

/**
 * @author 灵魂编程者
 * @Title: NotInitialization
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/11 20:33
 */

/*
* 被动例子1：
* 通过子类引用父类的静态字段，子类不会被初始化
* */
class SuperClass{
    static{
        System.out.println("父类的静态块");
    }

    public static int value = 12;
}

class SubClass extends SuperClass{
    static{
        System.out.println("子类的静态块");

    }
}
public class NotInitialization {

    public static void main(String[] args) {
        System.out.println(SubClass.value);
    }
}
/*
* 执行结果：
* 父类的静态块
*    12
* */