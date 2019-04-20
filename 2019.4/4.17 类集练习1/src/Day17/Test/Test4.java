package Day17.Test;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;


public class Test4 {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("B");
        Object[] result = list.toArray();
        System.out.println(Arrays.toString(result));
    }
}