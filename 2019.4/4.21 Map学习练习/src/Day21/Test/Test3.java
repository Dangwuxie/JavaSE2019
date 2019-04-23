package Day21.Test;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test3 {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"123");
        map.put(2,"456");
        map.put(3,"789");
        //重复一次
        map.put(4,"123");
        //先将Map集合转为Set集合
        Set<Map.Entry<Integer,String>> set = map.entrySet();
        //获取Iterator对象；
        Iterator<Map.Entry<Integer,String>> iterator = set.iterator();
        while(iterator.hasNext()){
            //System.out.print(iterator.next()+" ");
            Map.Entry<Integer,String> entry = iterator.next();
        }
    }
}
