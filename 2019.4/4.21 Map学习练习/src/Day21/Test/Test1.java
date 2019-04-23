package Day21.Test;

import java.util.HashMap;
import java.util.Map;

//Map基本操作
public class Test1 {

    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"123");
        map.put(2,"456");
        map.put(3,"789");
        //重复一次
        map.put(2,"456");
        System.out.println(map);
        System.out.println(map.get(2));
        //查找不到的话返回null;
        System.out.println(map.get(22));

    }
}
