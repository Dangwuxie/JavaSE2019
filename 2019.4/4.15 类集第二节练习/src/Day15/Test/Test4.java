package Day15.Test;

import java.util.*;

public class Test4 {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("hello");
        vector.add("apple");
        vector.add("hello");
        vector.add("java");

        Enumeration<String> enumeration =
                vector.elements();
        while (enumeration.hasMoreElements()){
            System.out.print(enumeration.nextElement()+"、");
    }
    }
}
