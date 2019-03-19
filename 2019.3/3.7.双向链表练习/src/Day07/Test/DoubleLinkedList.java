package Day07.Test;

/**
 * 基于双向链表的线性表
 */
public class DoubleLinkedList implements Sequence {
    private Node head;
    private Node tail;
    private int size;
    private class Node{
        Node prev;
        Object data;
        Node next;
        public Node(Object data) {
            this.data = data;
        }
        public Node(Node prev, Object data, Node next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }

    /**
     * 尾插法；插在tail后面；
     * @param data 要存储的元素
     */
    @Override
    public void add(Object data) {
        //产生新节点，尾插入链表中；
        //首先第一步实例化新的节点，前驱指向tail，后驱指向null;
        //判断该链表头节点是否为空，如果为空，那就是链表为空链表
        //head此时就是尾节点tail；
        //如果头节点不为空，那么尾节点的next指向新节点，
        //此时两个节点之间的两条线都连上来
        //最后tail指向新的节点，新节点再次成为尾节点；
        Node newnode = new Node(tail,data,null);
        if (head == null){
            head = newnode;
        }else{
            tail.next = newnode;
        }
        tail = newnode;
        size++;

    }

    /**
     * 移除对应下标的链表节点；
     * @param index 要删除的元素下标
     * @return
     */
    @Override
    public boolean remove(int index) {
        rangeCheck(index);
        Node cur = node(index);
        Node prev = cur.prev;
        Node next = cur.next;
        /*if (cur.prev == null && cur.next != null){
            cur = cur.next;
            cur.prev = null;
            head = cur;
        }else if (cur.next == null && cur.prev != null){
            cur = cur.prev;
            cur.next = null;
            tail = cur;
        }else if (cur.prev == null&& cur.next == null){
            cur.data = null;
        }
        else{
            prev.next = cur.next;
            next.prev = cur.prev;
            cur.data = null;
            cur.prev = cur.next = null;
        }*/
        if (prev == null){
            head = cur.next;
        }else{
            prev.next = cur.next;
            cur.prev = null;
        }
        if (next == null){
            tail = cur.prev;
        }else{
            prev.next = cur.next;
            cur.prev = null;
        }
       /*
        if (prev == null){
            head = cur.next;
        }else if (next == null){
            tail = cur.prev;
        }else{
            prev.next = cur.next;
            cur.prev = null;
        }*/
        size--;
        return false;
    }

    @Override
    public Object get(int index) {
        rangeCheck(index);
        Node temp = head;
        for (int i = 0;i < index;i++){
            temp = temp.next;
        }
        return temp.data;
    }

    /**
     *
     * @param data 要查找的元素内容
     * @return
     */
    @Override
    public boolean contains(Object data) {

        for(Node temp = head;temp != null;temp = temp.next){
            if (temp.data == data){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object set(int index, Object newData) {
        rangeCheck(index);
        Node temp = head;
        for (int i = 0;i < index;i++){
            temp = temp.next;
        }
        temp.data = newData;
        return null;
    }

    public Node node(int index){
        Node node = head;
        for (int i = 0;i < index;i++){
            node = node.next;
        }
        return node;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (Node temp = head;temp != null;temp = temp.next){
            if (temp.next == null){
                temp.data = 0;
            }
            temp = temp.next;
            temp.prev = null;
        }
    }

    @Override
    public Object[] toArray() {
        Object[] data = new Object[size];
        int i = 0;
        for (Node temp = head;temp != null;temp = temp.next){
            data[i++] = temp.data;
        }
        return data;
    }
    private void rangeCheck(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("越界异常");
        }
    }
}
