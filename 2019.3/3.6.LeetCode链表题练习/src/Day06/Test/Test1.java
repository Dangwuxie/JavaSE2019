package Day06.Test;
/*反转一个单链表。
        示例:
        输入: 1->2->3->4->5->NULL
        输出: 5->4->3->2->1->NULL
        */
 public class Test1 {

    public static void main(String[] args) {
        LeetedCode1 leetedCode1 = new LeetedCode1();
        leetedCode1.addFist(1);
        leetedCode1.addFist(0);
       // leetedCode1.addFist(3);
       // leetedCode1.addFist(2);
        leetedCode1.addFist(1);
        Object[] dabs = leetedCode1.toArray();
        for (Object o : dabs){
            System.out.print(o+" ");
        }
        System.out.println();
        //leetedCode1.printReverseLise(leetedCode1.reverseList());
        System.out.println(leetedCode1.isPalindrome());

    }
 }
/**
 * Definition for singly-linked list.
 *
 */



