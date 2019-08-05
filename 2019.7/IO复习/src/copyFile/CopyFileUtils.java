package copyFile;

import java.io.*;

/**
 * @author Dangxuchao
 * @Title: CopyFileUtils
 * @ProjectName IO复习
 * @Description:
 * 专门用来拷贝文件的类，功能
 * 1、判断要拷贝的问价是否存在
 * 2、判断目标文件的父路径是否存在(如果不存在可以创建一个)
 * 3、文件拷贝
 * @date 2019/8/6 0:06
 */
public class CopyFileUtils {
    private CopyFileUtils() {
    }

    /*
    * 先判断源文件是否存在
    * */
    public static boolean fileIsExists(String sourcePath){
        return new File(sourcePath).exists();
    }

    /*
    * 判断要拷贝的目标路径父路径是否存在,若不存在就创建一个
    * */
    public static boolean createParentPant(String targetPath){
        File file = new File(targetPath);
        if (!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
            return true;
        }
        return true;
    }

    /*
    * 下面就是文件拷贝了，由于我们不知道要拷贝的文件是什么，不一定是字符
    * 所以就是用字节流
    * */
    public static boolean copyFile(String sourcePath,String targetPath){
        /*
        * 以及判断过这两个路径是没有问题的，此时就是用字节流读InputStream进来，
        * 然后再用字节流OutputStream除去
        * */
        File sourceFile = new File(sourcePath);
        File targetFile = new File(targetPath);
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(sourceFile);
            out = new FileOutputStream(targetFile);
            byte[] data = new byte[1];
            long start = System.currentTimeMillis();
            int temp = 0;
            while ((temp = in.read(data)) != -1){
                out.write(data);
            }
            long end = System.currentTimeMillis();
            System.out.println("耗时："+(end-start)+"毫秒");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return true;

    }


}
