package dxc.JVM;

/**
 * @author 灵魂编程者
 * @Title: ReferenceCountingGC
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/22 23:16
 */

/*
* -XX:+PrintGCDetails
* */
public class ReferenceCountingGC {
    public Object instance = null;
    private static final int _1MB = 1024*1024;

    private byte[] bigSize = new byte[2 * _1MB];
    public static void main(String[] args) {
        ReferenceCountingGC r1 = new ReferenceCountingGC();
        ReferenceCountingGC r2 = new ReferenceCountingGC();
        r1.instance = r2;
        r2.instance = r1;

        r1 = null;
        r2 = null;

        System.gc();
    }
}
/*

[GC (System.gc())
 [PSYoungGen: 6728K->776K(18944K)] 6728K->784K(62976K), 0.0022263 secs]
[Times: user=0.00 sys=0.00, real=0.00 secs]
[Full GC (System.gc()) [PSYoungGen: 776K->0K(18944K)]
 [ParOldGen: 8K->662K(44032K)] 784K->662K(62976K),
 [Metaspace: 3493K->3493K(1056768K)], 0.0135576 secs]
 [Times: user=0.03 sys=0.00, real=0.01 secs]

Heap

 PSYoungGen      total 18944K, used 164K [0x00000000eb400000, 0x00000000ec900000, 0x0000000100000000)
  eden space 16384K, 1% used [0x00000000eb400000,0x00000000eb4290d0,0x00000000ec400000)
  from space 2560K, 0% used [0x00000000ec400000,0x00000000ec400000,0x00000000ec680000)
  to   space 2560K, 0% used [0x00000000ec680000,0x00000000ec680000,0x00000000ec900000)
 ParOldGen       total 44032K, used 662K [0x00000000c1c00000, 0x00000000c4700000, 0x00000000eb400000)
  object space 44032K, 1% used [0x00000000c1c00000,0x00000000c1ca5bf8,0x00000000c4700000)
 Metaspace       used 3499K, capacity 4498K, committed 4864K, reserved 1056768K
  class space    used 387K, capacity 390K, committed 512K, reserved 1048576K

 */