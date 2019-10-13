package dxc.JVM.早期编译优化_语法糖.泛型;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 灵魂编程者
 * @Title: OverLoadDemo1
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/13 14:11
 */
public class OverLoadDemo1 {

    public static void main(String[] args) {
        //method(new ArrayList<String>());
        method(new ArrayList<Integer>());
    }

    /*public static String method(List<String> list){

        return "";
    }*/

    public static int method(List<Integer> list){

        return 0;
    }
}
