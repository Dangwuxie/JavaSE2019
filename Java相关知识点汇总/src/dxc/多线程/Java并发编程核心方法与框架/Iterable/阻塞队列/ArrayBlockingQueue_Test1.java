package dxc.多线程.Java并发编程核心方法与框架.Iterable.阻塞队列;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author 灵魂编程者
 * @Title: ArrayBlockingQueue_Test1
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/12 15:52
 */

/*
* 使用ArrayBlockingQueue时，如果满了，继续put元素，就会异常
* 如果是空的，take元素，那么出现异常；
* */
public class ArrayBlockingQueue_Test1 {

    public static void main(String[] args) {
        ArrayBlockingQueue queue = new ArrayBlockingQueue(3);
        queue.add("a1");
        queue.add("a2");
        queue.add("a3");
        System.out.println(queue.size());
        System.out.println(System.currentTimeMillis());
        queue.add("a4");
        System.out.println(System.currentTimeMillis());
    }
}
