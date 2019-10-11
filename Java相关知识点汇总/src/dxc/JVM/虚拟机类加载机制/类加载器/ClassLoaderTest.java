package dxc.JVM.虚拟机类加载机制.类加载器;

/**
 * @author 灵魂编程者
 * @Title: ClassLoaderTest
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/11 20:50
 */
/*
* 不同的类加载器对instance的影响
* */

public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader myClassLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return super.loadClass(name);

            }
        };


    }
}
