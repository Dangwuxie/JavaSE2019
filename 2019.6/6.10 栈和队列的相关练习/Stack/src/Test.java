

/**
 * @author Dangxuchao
 * @Title: Test
 * @ProjectName 6.10 栈和队列的相关练习
 * @Description: 测试栈的基本实现
 * @date 2019/6/10 0:43
 */
public class Test {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(10);
        for (int i = 0;i < 10;i++){
            stack.push(i+1);
        }

        for (int i = 0;i < 10;i++){
            System.out.print(stack.pop()+" ");
        }
    }
}
