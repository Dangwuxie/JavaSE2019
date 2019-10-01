package dxc.JVM.内存分配和回收策略;

/**
 * @author 灵魂编程者
 * @Title: TenuredGenerationGC
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/1 17:44
 */
/*
    大对象直接进入老年代
     -XX:+UseSerialGC
     (PretenureSizeThreshold的设置只对Serial和ParNew两个垃圾收集器有效)
    -XX:PrintGCDtails
    -Xms20M
    -Xmx20M
    -Xmn10M
    -XX:SurvivorRatio=8
    -XX:PretenureSizeThreshold=3145728

*/

public class TenuredGenerationGC {

    private static final int _1MB = 1024*1024;
    public static void testAll(){
        byte[] all;
        //-XX:PretenureSizeThreshold=3145728,
        //此时设置的是3MB，大于的话会直接放入老年代
        all = new byte[4*_1MB];

    }
    public static void main(String[] args) {
        testAll();
    }
}
/*
Heap
 def new generation   total 9216K, used 2394K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
  eden space 8192K,  29% used [0x00000000fec00000, 0x00000000fee56980, 0x00000000ff400000)
  from space 1024K,   0% used [0x00000000ff400000, 0x00000000ff400000, 0x00000000ff500000)
  to   space 1024K,   0% used [0x00000000ff500000, 0x00000000ff500000, 0x00000000ff600000)
 tenured generation   total 10240K, used 4096K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
   the space 10240K,  40% used [0x00000000ff600000, 0x00000000ffa00010, 0x00000000ffa00200, 0x0000000100000000)
 Metaspace       used 3499K, capacity 4498K, committed 4864K, reserved 1056768K
  class space    used 387K, capacity 390K, committed 512K, reserved 1048576K

* */