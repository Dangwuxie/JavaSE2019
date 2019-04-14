package Day13.Test;


import java.util.ArrayList;
import java.util.List;

public class Test1 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(6);
        list.add(8);
        System.out.println(list);
        System.out.println(list.contains(4));
        System.out.println(list.size());
        System.out.println(list.remove(2));
        System.out.println(list.get(1));
        System.out.println(list.set(1,5));
        System.out.println(list);
    }
}
