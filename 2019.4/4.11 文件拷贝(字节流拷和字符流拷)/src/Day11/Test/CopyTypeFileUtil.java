package Day11.Test;

import java.io.*;

/**
 * 此类的作用有三个：
 * 1.判断源文件是否存在
 * 2.判断目标文件父路径是否存在，若不存在则创建父目录
 * 3.进行文件的拷贝
 */
public class CopyTypeFileUtil {

    private CopyTypeFileUtil() {
    }

    public static boolean fileIsExists(String path){
        return new File(path).exists();
    }
    //这里应该是要创建目标文件
    //就是要拷贝到那个文件里去 destPath应该是
    public static void createParentsDir(String path){
        File file = new File(path);
        if (!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
    }

    /**
     *
     * @param sourcePath 源文件路径
     * @param destPath 目标文件路径
     * @return 返回值，是否拷贝成功
     */
    public static boolean copyFile(String sourcePath,String destPath) throws Exception {
        long start = System.currentTimeMillis();
        FileInputStream fileInputStream = new FileInputStream(sourcePath);
        FileOutputStream fileOutputStream = new FileOutputStream(destPath);
        copyFileHandle(fileInputStream,fileOutputStream);
        long end = System.currentTimeMillis();
        System.out.println("耗时："+(end-start)+"毫秒");
        return true;
    }


    public static void copyFileHandle(InputStream input,OutputStream output) throws Exception {
        //最核心的部分，开辟缓冲区一次性读入多个内容
        byte[] data = new byte[256];
        int temp = 0;
        while ((temp = input.read(data)) != -1){
            output.write(data,0,temp);
        }
    }
}
