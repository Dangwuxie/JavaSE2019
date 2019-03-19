package Day17.Test;

public class Test1 {

    public static void main(String[] args) {
	// write your code here
        String str = "hello";
        StringBuffer str2 = new StringBuffer("world");
        //字符串的拼接
        str2.append(str);
        System.out.println(str2);
        //SB类转为String类，调用toString方法；
        System.out.println(str2.toString());
        //SB独有方法，反转字符串
        System.out.println(str2.reverse());
        //SB独有方法，删除指定范围的元素；
        System.out.println(str2.delete(0,4));
        //SB独有方法，指定下标出开始增加字符串
        System.out.println(str2.insert(0,"dang"));

    }
}
