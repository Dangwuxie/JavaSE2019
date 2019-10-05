package dxc.JVM.内存分配和回收策略;

/**
 * @author 灵魂编程者
 * @Title: LongYearsToTenured
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/1 18:56
 */

/*
* 在Survivor的From和to区域来回复制15次之后依旧存活的对象放入老年代；
*
* */
public class LongYearsToTenured {

    private static final int _1MB = 1024*1024;

    public static void testAll(){
        byte[] all1,all2,all3;
        all1 = new byte[_1MB/4];

        //什么时候进入老年代取决于-XX:MaxTenuringThreshold的设定
        all2 = new byte[4*_1MB];
        all3 = new byte[4*_1MB];
        all3 = null;
        all3 = new byte[4*_1MB];

    }

    public static void main(String[] args) {
        testAll();
    }

}
/*
[GC (Allocation Failure) [DefNew
Desired survivor size 524288 bytes, new threshold 1 (max 1)
- age   1:     942360 bytes,     942360 total
: 6582K->920K(9216K), 0.0071791 secs] 6582K->5016K(19456K), 0.0072527 secs]
[Times: user=0.02 sys=0.00, real=0.01 secs]
//-XX:MaxTenuringThreshold=1的时候，第二次gc后新生代内存使用变成0K；
[GC (Allocation Failure) [DefNew
Desired survivor size 524288 bytes, new threshold 1 (max 1)
: 5016K->0K(9216K), 0.0024786 secs] 9112K->5012K(19456K), 0.0025134 secs]
[Times: user=0.00 sys=0.00, real=0.00 secs]
Heap
 def new generation   total 9216K, used 4178K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
  eden space 8192K,  51% used [0x00000000fec00000, 0x00000000ff014930, 0x00000000ff400000)
  from space 1024K,   0% used [0x00000000ff400000, 0x00000000ff400000, 0x00000000ff500000)
  to   space 1024K,   0% used [0x00000000ff500000, 0x00000000ff500000, 0x00000000ff600000)
 tenured generation   total 10240K, used 5012K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
   the space 10240K,  48% used [0x00000000ff600000, 0x00000000ffae50f0, 0x00000000ffae5200, 0x0000000100000000)
 Metaspace       used 3499K, capacity 4498K, committed 4864K, reserved 1056768K
  class space    used 387K, capacity 390K, committed 512K, reserved 1048576K
* */