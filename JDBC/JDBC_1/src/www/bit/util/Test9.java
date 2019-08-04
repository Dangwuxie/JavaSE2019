package www.bit.util;

import java.net.URL;

/**
 * @author Dangxuchao
 * @Title: Test9
 * @ProjectName JDBC
 * @Description: 获取src路径下的文件的方式-->类加载器，ClassLoader
 * @date 2019/8/4 10:27
 */
public class Test9 {
    public static void main(String[] args) {
        ClassLoader classLoader = Test9.class.getClassLoader();
        URL res = classLoader.getResource("JDBC.properties");
        String path = res.getPath();
        System.out.println(path);
    }
}
