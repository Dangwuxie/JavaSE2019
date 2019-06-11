/**
 * @author Dangxuchao
 * @Title: Test
 * @ProjectName 6.10 栈和队列的相关练习
 * @Description: TODO
 * @date 2019/6/10 20:45
 */
public class Test {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.enqueue(1);
        arrayQueue.enqueue(2);
        arrayQueue.enqueue(3);
        arrayQueue.enqueue(4);
        arrayQueue.enqueue(5);
        arrayQueue.enqueue(6);
        System.out.println(arrayQueue.isEmpty());
        System.out.println(arrayQueue.getSize());
        System.out.println(arrayQueue.dequeue());
    }
}
