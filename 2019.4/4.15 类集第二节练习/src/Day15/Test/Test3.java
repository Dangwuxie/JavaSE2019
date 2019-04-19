package Day15.Test;

import java.util.*;

public class Test3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("apple");
        list.add("hello");
        list.add("java");
        //取得ArrayList的双向迭代器
        ListIterator<String> iterator = list.listIterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+"、");
        }
        System.out.println();
        System.out.println("反过来");
        while(iterator.hasPrevious()){
            System.out.print(iterator.previous()+"、");
        }
    }
}
