import java.io.File;
import java.util.Date;

/**
 * @author Dangxuchao
 * @Title: Test3
 * @ProjectName IO复习
 * @Description: 目标：File文件操作类
 * @date 2019/8/1 0:02
 */
public class Test3 {
    public static void main(String[] args) {
        /*File file3 = new File("C:"
                +File.separator+"Users"
                +File.separator+"dangwuxie"
                +File.separator+"Desktop"
                +File.separator+"DXC"
                +File.separator+"730.txt");
        String parentPath = file3.getParent();//取得父路径
        System.out.println(parentPath);
        *//*C:\Users\dangwuxie\Desktop\DXC*//*
        //然后取得父类对象，输出父类对象的父类=路径
        File parentFile = file3.getParentFile();
        String ParentPPatnname = parentFile.getParent();
        System.out.println(ParentPPatnname);
        *//*C:\Users\dangwuxie\Desktop*/

        //下面创建一个目录(就是创建了一个文件夹),现在DXC目录下是没有803.txt文件的
        //803它的父路径存在，所以创建，
        /*File file4 = new File("C:"
                +File.separator+"Users"
                +File.separator+"dangwuxie"
                +File.separator+"Desktop"
                +File.separator+"DXC"
                +File.separator+"803a.txt");
        if (!file4.exists()){
            file4.mkdirs();
        }*/


        //换一个父路径
        /*File file4a = new File("C:"
                +File.separator+"Users"
                +File.separator+"dangwuxie"
                +File.separator+"Desktop"
                +File.separator+"DXC"
                +File.separator+"803b");
        if (!file4a.exists()){
            boolean flag = file4a.mkdir();
            System.out.println(flag);
        }*/


        //对文件信息的一些列操作
        /*File file3 = new File("C:"
                +File.separator+"Users"
                +File.separator+"dangwuxie"
                +File.separator+"Desktop"
                +File.separator+"DXC"
                +File.separator+"730.txt");
        File file4 = new File("C:"
                +File.separator+"Users"
                +File.separator+"dangwuxie"
                +File.separator+"Desktop"
                +File.separator+"DXC");
        System.out.println(file4.isDirectory());//判断路径是不是一个目录，DXC是一个目录，此处应该输出true
        System.out.println(file3.isFile());//判断路径是不是一个文件，可能是一个目录；

        if (file3.exists() && file3.isFile()){
        //判断路径是否存在
            System.out.println("文件大小："+file3.length());
            System.out.println("最后一次修改日期："+new Date(file3.lastModified()));
            System.out.println(file3.lastModified());
        }*/
        /*
            true
            true
            文件大小：4
            最后一次修改日期：Sat Aug 03 18:32:02 CST 2019
        */


        //取得目录的全部组成信息
        File file4 = new File("C:"
                +File.separator+"Users"
                +File.separator+"dangwuxie"
                +File.separator+"Desktop"
                +File.separator+"DXC");
        if (file4.exists() && file4.isDirectory()){
            //判断路径是否存在，以及是不是一个文件
            //下面列出所有内容
            printAll(file4);
        }
    }

    public static void printAll(File fileTemp){
        if (fileTemp.exists()&&fileTemp.isDirectory()){
            File[] result = fileTemp.listFiles();
            for(File filetemp : result){
                System.out.println(filetemp);
                if (filetemp.isDirectory()){
                    printAll(filetemp);
                }
            }
        }
    }
}
