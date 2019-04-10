package Day11.Test;



//字节拷贝：由于要拷贝的内容不一定是文字数据，
//所以此次采用字节流
public class CopyFile {

    public static void main(String[] args) throws Exception {
        //File file = new File("C:\\Users\\dangwuxie\\Desktop\\DXC\\410.txt");
        //System.out.println(file.exists());
        String sourcePath = "C:\\Users\\dangwuxie\\Desktop\\DXC\\Java410\\风景.jpg";
        String destPath = "C:\\Users\\dangwuxie\\Desktop\\DXC\\Java00\\风景.jpg";
        if (CopyTypeFileUtil.fileIsExists(sourcePath)){
            CopyTypeFileUtil.createParentsDir(destPath);
        }
        if (CopyTypeFileUtil.copyFile(sourcePath,destPath)){
            System.out.println("拷贝成功");
        }else{
            System.out.println("源文件不存在，无法拷贝");
        }
    }
}
