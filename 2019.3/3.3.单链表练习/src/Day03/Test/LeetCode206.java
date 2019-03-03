package Day03.Test;

/**
 * Definition for singly-linked list.

 * }
 */
class ListNode206 {
    int val;
    ListNode206 next;

    ListNode206(int x) {
        val = x;
    }
}
class Solution206 {
    public ListNode206 reverseList(ListNode206 head) {
      if (head == null){
          return null;
      }
      ListNode206 prev206 = new ListNode206(0);
      prev206 = head;
      ListNode206 prev2061 = new ListNode206(0);
      while(prev206.next != null){
          prev2061 = prev206.next;
          prev206 = prev206.next;
      }
      prev206.next = null;
      prev2061.next = reverseList(head);
      return prev2061;
    }
}



public class LeetCode206 {
    public static void main(String[] args) {
        ListNode206 node1 = new ListNode206(1);
        ListNode206 node2 = new ListNode206(2);
        ListNode206 node3 = new ListNode206(3);
        ListNode206 node4 = new ListNode206(6);
        ListNode206 node5 = new ListNode206(4);
        ListNode206 node6 = new ListNode206(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        Solution206 solution206 = new Solution206();
        System.out.println(solution206.reverseList(node1).val);
        System.out.println(solution206.reverseList(node2).val);
    }

}
