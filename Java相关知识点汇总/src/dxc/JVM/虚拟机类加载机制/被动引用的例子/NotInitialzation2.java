package dxc.JVM.虚拟机类加载机制.被动引用的例子;

/**
 * @author 灵魂编程者
 * @Title: NotInitialzation2
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/11 20:36
 */

/*
* 被动引用2：
* 通过数组定义来引用类，不会触发改类的初始化
* */


public class NotInitialzation2 {
    public static void main(String[] args) {

        SubClass[] subClasses = new SubClass[2];
    }
}
