package Day03.Test;
//火车类
public class LinkedList4 {
    //火车头节点
    private Node head;
    //火车长度
    private int size;
    public LinkedList4() {
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

    public void add4(Object data){
        //创建新节点存放数据；
        Node newnode4 = new Node(data);
        //下面就是进行节点的拼装；
        newnode4.next = head;
        head = newnode4;
        size++;
    }
    public void addElement4(int index,Object data){
        if (index < 0 || index >= size ){
            throw new IndexOutOfBoundsException("数组越界异常");
        }
        else if (index == 0){
            add4(data);
        }else{
            Node prev = head;
            for (int i = 0;i < index-1;i++){
                prev = prev.next;
            }
            Node node4 = new Node(data);
            node4.next = prev.next;
            prev.next = node4;
            size++;
        }

    }
    public boolean replaceElement(int index,Object data){
        Node prev = head;
        for (int i = 0;i < index-1;i++){
            prev = prev.next;
        }
        Node node = new Node(data);
        prev.next.data = null;
        node.next = prev.next.next;
        prev.next.next = null;
        prev.next = node;
        return true;
    }
    public boolean seekElement(Object data){
        for (Node temp = head;temp != null;temp = temp.next){
            if (temp.data == data)
                return true;
        }
        return false;
    }
    public void reverseBetween(int m,int n) {
        Node m2 = head;
        Node n2 = head;
        for(int i = 0;i < m-1;i++){
            m2 = m2.next;
        }
        for(int i = 0;i < n-1;i++){
            n2 = n2.next;
        }
        Node prev666 = new Node(-1);
        prev666 = m2;
        Node m3 = m2.next;
        while(m3 != n2.next){
            m2.next = m3.next;
            m3.next = prev666.next;
            prev666.next = m3;
            m3 = m2.next;
        }
    }
    public void removeElements(int index){
        if (index < 0 || index >=size){
            throw new IndexOutOfBoundsException("数组越界异常");
        }else{
            Node prev = head;
            for (int i = 0;i < index-1;i++){
                prev = prev.next;
            }
            System.out.println(prev.data);

            Node cur = prev.next;
            System.out.println(cur.data);
            prev.next = cur.next;
            cur.next = cur = null;
            size--;

        }

    }
    public Object[] toArray(){
        Object[] dabs = new Object[size];
        int i = 0;
        for (Node temp = head;temp != null;temp = temp.next){
            dabs[i++] = temp.data;
        }
        return dabs;
    }

}
