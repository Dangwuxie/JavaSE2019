package dxc.JVM.虚拟机类加载机制;

/**
 * @author 灵魂编程者
 * @Title: clinit
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/10 20:46
 */

/*
* 注意：类中的静态块和静态变量的顺序是，按照代码的编写顺序去执行
* */

class Parent{

    static {
        A = 2;
    }
    //准备阶段初始化A的值为0；
//然后初始化阶段执行clinit方法，执行所有类变量的赋值动作；
    public static int A = 1;
}

class Sub extends Parent{

    public static  int B = A;
}
public class clinit {

    public static void main(String[] args) {
        System.out.println(Sub.B);
    }
}
