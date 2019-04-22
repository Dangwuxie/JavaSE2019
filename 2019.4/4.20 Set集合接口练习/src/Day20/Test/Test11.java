package Day20.Test;

//是使用Enumeration枚举输出

import java.util.Enumeration;
import java.util.Vector;

public class Test11 {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("A");
        vector.add("B");
        vector.add("B");
        vector.add("C");
        vector.add("D");
        vector.add("E");
        vector.add("F");
        Enumeration<String> enumeration = vector.elements();
        while(enumeration.hasMoreElements()){
            System.out.print(enumeration.nextElement()+"  ");
        }
    }
}
