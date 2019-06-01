import java.util.EmptyStackException;
import java.util.Stack;

/**
 * /*char[] data = A.toCharArray();
 *         Stack myStack = new Stack();
 *         int i = 0;
 *         for ( i = 0 ;i < n;i++){
 *             if (data[i] == '('||data[i] == '{'||data[i] == '['){
 *                 myStack.push(data[i]);
 *             }else if ((data[i] == ')')&& i != 0){
 *                 if (myStack.peek().equals('(')){
 *                     myStack.pop();
 *                 }else {
 *                     break;
 *                 }
 *             }else if ((data[i] == '}')&& i != 0){
 *                 if (myStack.peek().equals('{')){
 *                     myStack.pop();
 *                 }else {
 *                     break;
 *                 }
 *             }else if ((data[i] == ']')&& i != 0){
 *                 if (myStack.peek().equals('[')) {
 *                     myStack.pop();
 *                 }else {
 *                     break;
 *                 }
 *             }else if (myStack.isEmpty()){
 *                 break;
 *             }else {
 *                 continue;
 *             }
 *         }
 *         if (i == n && myStack.isEmpty()){
 *             return true;
 *         }else {
 *             return false;
 *         }
 */

class Parenthesis {
    public static boolean chkParenthesis(String A, int n) {
        Stack<Character> lefts = new Stack<Character>();
        if(A == null || A.length() != n){
            return false;
        }
        for(int i = 0; i < n; i++){
            if(A.charAt(i) == '('){
                lefts.push(A.charAt(i));
            }else if(A.charAt(i) == ')'){
                if(lefts.empty()){
                    return false;
                }else{
                    lefts.pop();
                }
            }else{
                return false;
            }
        }
        if(!lefts.empty()){
            return false;
        }else{
            return true;
        }

    }
}
public class Test1 {
    public static void main(String[] args) {
        String A = "(())";
        System.out.println(Parenthesis.chkParenthesis(A,A.length()));
    }
}
