import java.util.EmptyStackException;

/**
 * @author Dangxuchao
 * @Title: ArrayStack
 * @ProjectName 6.10 栈和队列的相关练习
 * @Description: 基于数组的顺序栈
 * @date 2019/6/10 0:34
 */
public class ArrayStack<E> {
    private int[] items;//数组
    private int count; //栈中元素个数
    private int n;//栈的大小

    //先初始化数组，申请一个大小为n的数组空间

    public ArrayStack(int n) {
        this.items = new int[n];
        this.count = 0;
        this.n = n;
    }

    //入栈操作
    public boolean push(int item){
        //如果数组空间不够了，之间返回false，入栈失败
        if (count == n) return false;

        //否则将otem放到下标为count的位置
        items[count++] = item;
        return true;
    }

    //出栈操作
    public int pop(){
        //若是栈为空。此时返回null;
        if (count == 0){
            throw new EmptyStackException();
        }
        int tmp = items[count-1];
        count--;
        return tmp;
    }
    //
    public int peek(){
        int tmp = items[count-1];
        return tmp;
    }

    public boolean isempty(){
        return n == count;
    }

    public int getSize(){
        return count;
    }
}
