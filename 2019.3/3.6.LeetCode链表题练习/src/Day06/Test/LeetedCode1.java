package Day06.Test;

 public class LeetedCode1 {
     private Node head;
     private int size;
     public LeetedCode1(){
         head = null;
         size = 0;
     }
     private class Node{
         Object val;
         Node next;
         public Node(Object val){
             this.val = val;
         }
         public Node(Object val, Node next){
             this.val = val;
             this.next = next;
         }
     }
     public void addFist(Object data){
         Node newnode = new Node(data);
         newnode.next = head;
         head = newnode;
         size++;
     }
     public Object[] toArray(){

         Object[] dabs = new Object[size];
         int i = 0;
         for (Node temp = head;temp != null;temp = temp.next){
             dabs[i++] = temp.val;
         }
         return dabs;
     }

     public Node reverseList(){
         Node dummyhead = new Node(-1);
         dummyhead.next = head;
         Node f = head;
         Node s = f.next;
         if (head == null || head.next == null){
             return head;
         }else{
             while(s != null){
                 f.next = s.next;
                 s.next = dummyhead.next;
                 dummyhead.next = s;
                 s = f.next;
             }
         }
            return dummyhead.next;
     }
     public void printReverseLise(Node node){
         for (Node temp = node;temp != null;temp = temp.next){
             System.out.print(temp.val+" ");
         }
     }
     public boolean isPalindrome() {
         if(head == null || head.next==null){
             return true;
         }else{
             if(head.next.next == null&&head.val == head.next.val){
                 return true;
             }else if(head.next.next == null&&head.val != head.next.val){
                 return false;
             }
             Node fast = head;
             Node low = head;
             while(low != null&&fast != null&&fast.next != null){
                 fast = fast.next.next;
                 low = low.next;
             }
             Node dummyhead1 = new Node(-1);
             //找到中间节点；
             Node mid = low;
             dummyhead1.next = mid;
             Node f = mid;
             Node s = f.next;
             while(s != null){
                 f.next = s.next;
                 s.next = dummyhead1.next;
                 dummyhead1.next = s;
                 s = f.next;
             }
             fast = head;
             low = dummyhead1;
             while(fast != null){
                 if(fast.val != low.next.val){
                     return false;
                 }else {
                     fast = fast.next;
                     low = low.next;
                 }
             }

         }
         return true;
     }
 }

