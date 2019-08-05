package copyFile;

import java.io.File;
import java.io.IOException;

/**
 * @author Dangxuchao
 * @Title: CopyFile
 * @ProjectName IO复习
 * @Description: TODO
 * @date 2019/8/6 0:08
 */
public class CopyFile {
    public static void main(String[] args) throws IOException {
        String sourcePath = "C:\\Users\\dangwuxie\\Desktop\\图片\\8_5.JPG";
        String targetPath = "C:\\Users\\dangwuxie\\Desktop\\DXC\\8_5.JPG";

        System.out.println(CopyFileUtils.fileIsExists(sourcePath));
        System.out.println(CopyFileUtils.createParentPant(targetPath));
        if (CopyFileUtils.copyFile(sourcePath,targetPath)){
            System.out.println("拷贝成功！");
        }else {
            System.out.println("拷贝失败！");
        }
    }
}
