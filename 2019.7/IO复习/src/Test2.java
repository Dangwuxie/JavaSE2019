import java.io.File;
import java.io.IOException;

/**
 * @author Dangxuchao
 * @Title: Test2
 * @ProjectName IO复习
 * @Description: 判断文件是否存在，删除文件
 * @date 2019/7/31 23:44
 */
public class Test2 {
    public static void main(String[] args) {
        File file2 = new File("C:\\Users\\dangwuxie\\Desktop\\DXC\\730.txt");
        if (!file2.exists()){
            try {
                file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            file2.delete();
        }
    }
}
