package Day03.Test;

//节点结构
class Node{
    Object data;
    Node next;
}
public class Test2 {
    public static void main(String[] args) {
        Node first = new Node();
        first.data = 1;
        Node second = new Node();
        second.data = 2;
        Node third = new Node();
        third.data = 3;
        first.next = second;
        second.next = third;
        for (Node temp = first;temp != null;temp = temp.next){
            System.out.print(temp.data+"  ");
        }
    }
}
