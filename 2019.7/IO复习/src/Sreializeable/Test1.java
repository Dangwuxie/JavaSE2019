package Sreializeable;

import java.io.*;

/**
 * @author Dangxuchao
 * @Title: Test1
 * @ProjectName IO复习
 * @Description: 序列化
 * @date 2019/8/7 11:06
 */
public class Test1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("C:\\Users\\dangwuxie\\Desktop\\DXC\\C.txt");
       /* Person person = new Person("党旭超",22);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(person);
        oos.close();*/
       ObjectInputStream ooi = new ObjectInputStream(new FileInputStream(file));
       Object obj = ooi.readObject();
        System.out.println(obj);
       ooi.close();
    }
}
