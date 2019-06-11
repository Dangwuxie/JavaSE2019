import java.util.Scanner;
import java.util.Stack;

/**
 * @author Dangxuchao
 * @Title: Expr
 * @ProjectName 6.10 栈和队列的相关练习
 * @Description: 表达式求值，利用栈来实现；
 *
 * @date 2019/6/10 17:40
 */
class Expr {
    public static void main(String[] args) {

        String[] str = new String[]{"10","6","9","5","+","-11","*","/","*","17","+","5","+"};

        System.out.println(evalRPN(str));

        /*char ch = '5';
        int chs = '5'-'0';
        System.out.println(chs*2);*/

    }
    public static int evalRPN(String[] tokens) {

        Stack<Integer> stackNum = new Stack<>();
        for (int i = 0;i < tokens.length;i++){
            String strs = tokens[i];
            if (strs.length() == 1){
                char ch = strs.charAt(0);
                if (ch - '0' >= 0 && ch - '0'<= 9){
                    stackNum.push(Integer.valueOf(strs));
                }else {
                    if (stackNum.size() < 2){
                        break;
                    }
                    int temp2 = stackNum.pop();
                    int temp1 = stackNum.pop();

                    switch (ch){
                        case '+':
                            stackNum.push(temp1+temp2);
                            break;
                        case '-':
                            stackNum.push(temp1-temp2);
                            break;
                        case '*':
                            stackNum.push(temp1*temp2);
                            break;
                        case '/':
                            stackNum.push(temp1/temp2);
                            break;
                    }
                }
            }else {
                stackNum.push(Integer.valueOf(strs));
            }
        }
        return stackNum.pop();
    }
}