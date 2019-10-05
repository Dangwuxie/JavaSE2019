package dxc.JVM.内存分配和回收策略;

/**
 * @author 灵魂编程者
 * @Title: SameAgeToTenured
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/1 19:33
 */
public class SameAgeToTenured {

    private static final int _1MB = 1024*1024;

    public static void testAll(){
        byte[] acc1,acc2,acc3,acc4;

        acc1 = new byte[_1MB/4];
        //acc2 = new byte[_1MB/4];

        acc3 = new byte[4*_1MB];
        acc4 = new byte[4*_1MB];
        acc4 = null;
        acc4 = new byte[4*_1MB];

    }

    public static void main(String[] args) {
        testAll();
    }
}
/*
//两个256k的对象，年龄相同，大小加起来是Survivor的一半，所以可以直接进入老年代；
* [GC (Allocation Failure) [DefNew: 6838K->1024K(9216K), 0.0070274 secs] 6838K->5272K(19456K), 0.0070960 secs] [Times: user=0.00 sys=0.02, real=0.01 secs]
[GC (Allocation Failure) [DefNew: 5120K->0K(9216K), 0.0019618 secs] 9368K->5272K(19456K), 0.0019900 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
Heap
 def new generation   total 9216K, used 4178K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
  eden space 8192K,  51% used [0x00000000fec00000, 0x00000000ff014930, 0x00000000ff400000)
  from space 1024K,   0% used [0x00000000ff400000, 0x00000000ff400000, 0x00000000ff500000)
  to   space 1024K,   0% used [0x00000000ff500000, 0x00000000ff500000, 0x00000000ff600000)
 tenured generation   total 10240K, used 5272K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
   the space 10240K,  51% used [0x00000000ff600000, 0x00000000ffb260f0, 0x00000000ffb26200, 0x0000000100000000)
 Metaspace       used 3499K, capacity 4498K, committed 4864K, reserved 1056768K
  class space    used 387K, capacity 390K, committed 512K, reserved 1048576K
* */

/*
* 注销其中一个 new byte[_1MB/4]之后：注意老年代的内存适用率；
*
*"C:\Program Files\Java\jdk1.8.0_131\bin\java.exe" -XX:+PrintGCDetails -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -XX:+UseSerialGC "-javaagent:C:\Java IDEA\IntelliJ IDEA 2018.1.6\lib\idea_rt.jar=2391:C:\Java IDEA\IntelliJ IDEA 2018.1.6\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_131\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\rt.jar;D:\Github\JavaSE2019\Java相关知识点汇总\out\production\Java相关知识点汇总" dxc.JVM.内存分配和回收策略.SameAgeToTenured
[GC (Allocation Failure) [DefNew: 6582K->920K(9216K), 0.0068074 secs] 6582K->5016K(19456K), 0.0068761 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
[GC (Allocation Failure) [DefNew: 5016K->0K(9216K), 0.0029007 secs] 9112K->5012K(19456K), 0.0029373 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
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