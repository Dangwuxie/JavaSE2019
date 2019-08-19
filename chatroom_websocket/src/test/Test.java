import java.sql.Connection;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Dangxuchao
 * @Title: Test
 * @ProjectName chatroom_websocket
 * @Description: TODO
 * @date 2019/8/19 15:32
 */
public class Test {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(2,"bb");
        map.put(3,"cc");
        map.put(1,"aa");
        map.put(1,"aa");

        System.out.println(map);
        /*Set<Integer> set = map.keySet();
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next());
        }
        Collection<String> connection = map.values();
        Iterator iterator1 = connection.iterator();
        while (iterator1.hasNext()){
            System.out.print(iterator1.next());
        }
        System.out.println();
        Set<Map.Entry<Integer, String>> set1 = map.entrySet();
        Iterator iterator2 = set1.iterator();
        while (iterator2.hasNext()){
            System.out.print(iterator2.next()+" ");
        }*/

    }
}
