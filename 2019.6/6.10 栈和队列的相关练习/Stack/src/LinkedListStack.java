/**
 * @author Dangxuchao
 * @Title: LinkedListStack
 * @ProjectName 6.10 栈和队列的相关练习
 * @Description: 基于链表实现的栈
 * @date 2019/6/10 17:14
 */
public class LinkedListStack {
    private class Node{
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node top = null;

    public void push(int value){
        Node newNode = new Node(value,null);
        //首先判断栈是否为空
        if (top == null){
            top = newNode;
        }else {
            //挂上value节点，在top节点后面；
            newNode.next = top;
            top = newNode;
        }
    }

    public int pop(){
        if (top == null){
            throw new StackOverflowError("栈为空");
        }
        int value = top.data;
        top = top.next;
        return value;
    }

    public int peek(){
        if (top == null){
            throw new StackOverflowError("栈为空");
        }
        return top.data;
    }
}
