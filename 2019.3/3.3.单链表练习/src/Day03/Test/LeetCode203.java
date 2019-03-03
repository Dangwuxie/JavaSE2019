package Day03.Test;

/**
 * Definition for singly-linked list.
 *
 * }
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        //第一步，判断首个节点是否为空。并且判断
        //如果链表的头节元素点就是所要删除的元素
        while(head != null&&head.val == val){
            head = head.next;
        }
        if (head == null){
            return null;
        }
        //如果第一个节点不是所要删除的元素，
        //而且不为空；
        ListNode prev = new ListNode(-1);
        prev = head;
        while (prev.next != null){
             if (prev.next.val == val){
                 prev.next = prev.next.next;
             }else{
                 prev = prev.next;
             }
        }
        return head;
    }
}
public class LeetCode203{
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        Solution solution = new Solution();
        solution.removeElements(node1,6);
        for (ListNode temp = node1;temp != null;temp = temp.next){
            System.out.print(temp.val+"->");
        }
    }
}


  /**  ListNode dummyHead = new ListNode(6);
        dummyHead.next = head;
                ListNode cur = dummyHead;
                while(cur.next != null){
                if(cur.next.val == val){
                if(cur.next.next != null){
                cur.next = cur.next.next;
                }else{
                cur.next = null;
                }
                }else{
                cur = cur.next;
                }
                }
                if(dummyHead.next == null){
                return null;
                }else{
                dummyHead = dummyHead.next;
                }
                return dummyHead;*/