package dxc.JVM.内存分配和回收策略;

/**
 * @author 灵魂编程者
 * @Title: YoungGenerationGC
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/1 17:12
 */

/*
    -XX:+PrintGCDetails
    -XX:+UseSerialGC
    -Xms20M
    -Xmx20M
    -Xmn10M
    -XX:SurvivorRatio=8
* */
public class YoungGenerationGC {

    private static final int _1MB = 1024*1024;
    public static void testAllocation(){
        byte[] all1,all2,all3,all4;
        all1 = new byte[2 * _1MB];
        all2 = new byte[2 * _1MB];
        all3 = new byte[2 * _1MB];
        //出现minor gc
        all4 = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        testAllocation();
    }
}
/*

[GC (Allocation Failure)
[DefNew: 6326K->664K(9216K), 0.0087236 secs]
6326K->4760K(19456K), 0.0095802 secs]
[Times: user=0.02 sys=0.00, real=0.01 secs]
Heap
 def new generation   total 9216K, used 7045K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
  eden space 8192K,  77% used [0x00000000fec00000, 0x00000000ff23b638, 0x00000000ff400000)
  from space 1024K,  64% used [0x00000000ff500000, 0x00000000ff5a6110, 0x00000000ff600000)
  to   space 1024K,   0% used [0x00000000ff400000, 0x00000000ff400000, 0x00000000ff500000)
 tenured generation   total 10240K, used 4096K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
   the space 10240K,  40% used [0x00000000ff600000, 0x00000000ffa00020, 0x00000000ffa00200, 0x0000000100000000)
 Metaspace       used 3499K, capacity 4498K, committed 4864K, reserved 1056768K
  class space    used 387K, capacity 390K, committed 512K, reserved 1048576K

Process finished with exit code 0

*/