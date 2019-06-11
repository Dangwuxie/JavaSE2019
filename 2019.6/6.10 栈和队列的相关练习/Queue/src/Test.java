/**
 * @author Dangxuchao
 * @Title: Test
 * @ProjectName 6.10 栈和队列的相关练习
 * @Description: TODO
 * @date 2019/6/10 20:45
 */
public class Test {
    public static void main(String[] args) {
       ArrayLoopQueue queue = new ArrayLoopQueue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.dequeue();
        queue.enqueue(6);
        queue.enqueue(7);
    }
}
