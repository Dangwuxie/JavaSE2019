package Day20.Test;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_ADDPeer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Test10 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        ListIterator<String> listIterator = list.listIterator();
        System.out.println("从前向后输出");
        while (listIterator.hasNext()){
            System.out.print(listIterator.next()+"  ");
        }
        System.out.println();
        System.out.println("从后向前输出：");
        while (listIterator.hasPrevious()){
            System.out.print(listIterator.previous()+"  ");
        }

    }
}
