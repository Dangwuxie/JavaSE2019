package FileMerge;

import java.io.*;

/**
 * @author Dangxuchao
 * @Title: FileMerge
 * @ProjectName IO复习
 * @Description: TODO
 * @date 2019/8/6 22:47
 */
public class FileMerge {
    public static void main(String[] args) throws IOException {
        /**
         * 利用内存流进行文件合并，不用产生中间文件,
         * 只适合小的文件之间的合并
         */
        InputStream in1 = new FileInputStream(new File("C:\\Users\\dangwuxie\\Desktop\\DXC\\A.txt"));
        InputStream in2 = new FileInputStream(new File("C:\\Users\\dangwuxie\\Desktop\\DXC\\B.txt"));
        OutputStream out = new FileOutputStream(new File("C:\\Users\\dangwuxie\\Desktop\\DXC\\C.txt"));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        byte[] data = new byte[4];
        int len = 0;
        while ((len = in1.read(data)) !=-1){
            System.out.println(len);
            bos.write(data,0,len);
        }
        while ((len = in2.read(data)) != -1){
            System.out.println(len);
            bos.write(data,0,len);
        }
        out.write(bos.toByteArray());
        System.out.println(out);
        in1.close();
        in2.close();
        bos.close();
        out.close();

    }
}
