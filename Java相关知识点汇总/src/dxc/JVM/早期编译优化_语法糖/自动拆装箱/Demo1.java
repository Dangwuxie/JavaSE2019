package dxc.JVM.早期编译优化_语法糖.自动拆装箱;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 灵魂编程者
 * @Title: Demo1
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/13 14:18
 */
public class Demo1 {

    public static void main(String[] args) {
        //变长参数
        List<Integer> list = Arrays.asList(1,2,3,4);
        int sum = 0;

        for (int o:list){
            sum+=o;
        }
        System.out.println(sum);
        System.out.println(list);

    }
}
