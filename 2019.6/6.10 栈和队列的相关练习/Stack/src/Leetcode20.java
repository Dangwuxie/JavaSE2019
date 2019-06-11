import java.util.Scanner;
import java.util.Stack;

/**
 * @author Dangxuchao
 * @Title: Leetcode20
 * @ProjectName 6.10 栈和队列的相关练习
 * @Description: 括号匹配问题；
 * @date 2019/6/10 20:20
 */
public class Leetcode20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            System.out.println(isValid(scanner.nextLine()));
        }
    }
    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0;i < chars.length;i++){
            if (chars[i] == '('||chars[i] == '['||chars[i] == '{'){
                stack.push(chars[i]);
            }else if (chars[i] == ')'&& !stack.isEmpty()){
                if (stack.peek() == '('){
                    stack.pop();
                    continue;
                }else {
                    break;
                }
            }else if (chars[i] == ']'&& !stack.isEmpty()) {
                if (stack.peek() == '[') {
                    stack.pop();
                    continue;
                } else {
                    break;
                }
            }else if (chars[i] == '}'&& !stack.isEmpty()) {
                if (stack.peek() == '{') {
                    stack.pop();
                    continue;
                } else {
                    break;
                }
            }else if(stack.isEmpty()) {
                return false;
            }
        }
        if (stack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
