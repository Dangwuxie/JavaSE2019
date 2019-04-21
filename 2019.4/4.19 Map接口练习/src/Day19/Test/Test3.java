package Day19.Test;


import java.util.LinkedList;
import java.util.Queue;

public class Test3 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(111);
        queue.add(222);
        queue.add(333);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
