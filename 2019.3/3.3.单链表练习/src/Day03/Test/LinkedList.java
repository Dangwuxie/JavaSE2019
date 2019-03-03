package Day03.Test;

public class LinkedList {
    //火车头节点
    private Node head;
    private int size;

    public LinkedList() {
        size = 0;
        head = null;
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
    //将节点头插入火车
    public void addFist(Object data){
        //创建新的节点
        Node newNode = new Node(data);
        //将当前节点指向原来火车的头节点；
        newNode.next = head;
        head = newNode;
    }
    //在任意位置插入节点
    public void add(int index,Object data){
        //判断index是否合法；
        if (index < 0 || index >size){
            throw new IndexOutOfBoundsException("index Illegal");
        }
        if (index == 0){
            addFist(data);
        }else {
            //找到index的前驱节点
            Node prev = head;
            for (int i = 0;i <index-1;i++){
                prev = prev.next;
            }
            Node newNode = new Node(data);
            newNode.next = prev.next;
            prev.next = newNode;
        }

    }
    public void addLast(Object data){
        add(size,data);
    }
    public void traverseLink(){
        for (Node temp = head;temp!=null;temp = temp.next){
            System.out.println(temp.data+"  ");
        }
    }
}
