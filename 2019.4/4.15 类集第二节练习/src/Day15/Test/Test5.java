package Day15.Test;

import java.util.Enumeration;
import java.util.Vector;

public class Test5 {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("hello");
        vector.add("apple");
        vector.add("hello");
        vector.add("java");
        for (String str : vector){
            System.out.print(str+"、");
        }

    }
}
