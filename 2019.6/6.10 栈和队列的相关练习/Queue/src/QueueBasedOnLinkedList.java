/**
 * @author Dangxuchao
 * @Title: QueueBasedOnLinkedList
 * @ProjectName 6.10 栈和队列的相关练习
 * @Description: 基于链表实现的队列
 * @date 2019/6/11 12:37
 */
public class QueueBasedOnLinkedList<E> implements Queue<E> {
    private class Node{
        E data;
        Node next;

        public Node(E data) {
            this.data = data;
        }
    }

    private Node head = null;
    private Node tail = null;

    /**
     * 入队
     * @param e
     */
    @Override
    public void enqueue(E e) {
        if (tail == null){
            Node newNode = new Node(e);
            head = newNode;
            tail = newNode;
        }else {
            Node newNode = new Node(e);
            tail.next = newNode;
            tail = tail.next;
        }
    }

    /**
     * 出队
     * @return
     */
    @Override
    public E dequeue() {
        if (head == null) {
            throw new ArrayIndexOutOfBoundsException("队列已空");
        }else {
            //此时出队
            E result = head.data;
            head = head.next;
            return result;
        }
    }

    @Override
    public E peek() {
       return head.data;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    /**
     * 输出队列中的所有节点值；
     */
    public void printAll(){
        Node p = head;
        while (p != null){
            System.out.print(p.data+" ");
            p = p.next;
        }
        System.out.println();
    }
}
