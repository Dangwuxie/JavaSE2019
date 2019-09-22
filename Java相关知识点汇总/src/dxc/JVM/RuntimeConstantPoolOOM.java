package dxc.JVM;

/**
 * @author 灵魂编程者
 * @Title: RuntimeConstantPoolOOM
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/22 11:23
 */
/*
* jdk1.6中，intern方法会把首次出现的字符串实例复制到永久代中，并且返回永久代的这个引用，
* jdk1.7中，intern方法不会复制，而是在常量池中记录首次出现的实例引用，返回的依旧是这个引用
* */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        String str1 = new StringBuilder("机算计").append("技术").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
}
