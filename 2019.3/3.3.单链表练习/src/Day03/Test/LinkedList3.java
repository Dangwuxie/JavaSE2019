package Day03.Test;
//火车类
public class LinkedList3 {
    //火车头节点；
    private Node head;
    private int size;

    public LinkedList3() {
        head = null;
        size = 0;
    }
    //每个节点类
    private class Node{
        Object data;
        Node next;
        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
        public Node(Object data) {
            this.data = data;
        }
    }
    //将头节点插入火车
    public void addFist(Object data){
        //创建新的节点
        Node newnode = new Node(data);
        //将当前节点指向原来的火车头节点
        newnode.next = head;
        //然后Head重新指向新的节点
        head = newnode;
        //head = new Node(data,head);
        size++;
    }
    //在链表某处随机插入新的节点
    public void add(int index,Object data){
        //比如所add(2,3),就是指在插入第二个节点；
        //就是在第一个节点的后面；
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("数组越界异常");
        }
        if (index == 0){
            //直接调用前面头节点插入的方法；
            addFist(data);
        }
        //下面就是先找到index的前驱节点；
        Node prev = head;
        for (int i = 0;i < index-1;i++){
            prev = prev.next;
        }
        Node newNode = new Node(data);
        newNode.next = prev.next;
        prev.next = newNode;
        //prev.next = new Node(data,prev.next);
        size++;
    }
    public static void main(String[] args) {

    }
}
