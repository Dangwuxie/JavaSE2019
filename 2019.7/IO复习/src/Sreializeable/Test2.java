package Sreializeable;

import java.util.function.Function;

/**
 * @author Dangxuchao
 * @Title: Test2
 * @ProjectName IO复习
 * @Description: transient关键字
 * @date 2019/8/7 11:29
 */
public class Test2 {
    public static void main(String[] args) {
        Integer a = new Integer(300);
        Integer b = new Integer(500);
        String str = "hello";
        StringBuilder sb = new StringBuilder("C++");
        swap(a,b,str,sb);
        System.out.println("a="+a+",b="+b);
        System.out.println(str);
        System.out.println(sb);
    }
    public static void swap(Integer a,Integer b,String str,StringBuilder sb){
        str += "word";
        sb.append("Java");
        Class cla = int.class;
    }
}
