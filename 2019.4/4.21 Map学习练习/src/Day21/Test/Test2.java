package Day21.Test;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"123");
        map.put(2,"456");
        map.put(3,"789");
        //重复一次
        map.put(4,"123");
        //取得map中的所有key信息；这个不能重复；
        Set<Integer> set = map.keySet();
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+"  ");
        }
        //取出map中所有的value信息,这个可以重复；
        //意思就是说key不能相同，但是value可以相同；
        Collection<String> collection = map.values();
        Iterator<String> iterator1 = collection.iterator();
        while (iterator1.hasNext()){
            System.out.print(iterator1.next()+"  ");
        }
    }
}
