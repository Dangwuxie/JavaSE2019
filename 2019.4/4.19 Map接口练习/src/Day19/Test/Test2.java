package Day19.Test;

import java.util.Stack;

public class Test2 {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(111);
        stack.push(222);
        stack.push(333);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
