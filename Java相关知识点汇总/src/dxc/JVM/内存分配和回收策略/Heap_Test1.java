package dxc.JVM.内存分配和回收策略;

import java.util.ArrayList;

/**
 * @author 灵魂编程者
 * @Title: Heap_Test1
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/5 16:39
 */
public class Heap_Test1 {

    byte[] _100KB = new byte[1024*100];

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Heap_Test1> lists = new ArrayList<>();

        while (true){
            lists.add(new Heap_Test1());
            Thread.sleep(100);
        }

    }
}
