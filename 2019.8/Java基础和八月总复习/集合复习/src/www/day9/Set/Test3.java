package www.day9.Set;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author 灵魂编程者
 * @Title: Test3
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/5 9:11
 */
public class Test3 {
    public static void main(String[] args) {
        /*String str1 = "hello";
        char[] ch = {'h','e','l','l','o'};
        System.out.println("ch="+ch);
        System.out.println(ch);*/
        /*System.out.println(str1.equals(ch));*/
        Map<Integer,String> map = new Hashtable<>();
        /*map.put(null,"1");*/
        map.put(1,null);
        map.put(2,null);
        map.put(3,null);
        /*map.put(null,"22");*/
        System.out.println(map);

    }
}
