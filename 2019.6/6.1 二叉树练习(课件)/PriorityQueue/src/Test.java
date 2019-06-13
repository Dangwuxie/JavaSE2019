import java.util.Arrays;

/**
 * @author Dangxuchao
 * @Title: Test
 * @ProjectName 6.1 二叉树练习(课件)
 * @Description: 优先队列测试
 * @date 2019/6/13 14:28
 */
public class Test {
    public static void main(String[] args) throws Exception {

        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.enQueue(10);
        priorityQueue.enQueue(8);
        priorityQueue.enQueue(9);
        priorityQueue.enQueue(7);
        priorityQueue.enQueue(1);
        priorityQueue.enQueue(4);
        priorityQueue.enQueue(6);
        priorityQueue.enQueue(3);
        priorityQueue.enQueue(2);
        priorityQueue.enQueue(5);
        System.out.println(Arrays.toString(priorityQueue.array));
        System.out.println(priorityQueue.deQueue());
        System.out.println(Arrays.toString(priorityQueue.array));
        System.out.println(priorityQueue.deQueue());
        System.out.println(Arrays.toString(priorityQueue.array));
        System.out.println(priorityQueue.deQueue());
        System.out.println(Arrays.toString(priorityQueue.array));
        System.out.println(priorityQueue.deQueue());
        System.out.println(Arrays.toString(priorityQueue.array));
        System.out.println(priorityQueue.deQueue());
    }
}
/*
运行结果：
    [10, 8, 9, 7, 5, 4, 6, 3, 2, 1]
    10
    [9, 8, 6, 7, 5, 4, 1, 3, 2, 1]
    9
    [8, 7, 6, 3, 5, 4, 1, 2, 2, 1]
    8
    [7, 5, 6, 3, 2, 4, 1, 2, 2, 1]
    7
    [6, 5, 4, 3, 2, 1, 1, 2, 2, 1]
    6

 */