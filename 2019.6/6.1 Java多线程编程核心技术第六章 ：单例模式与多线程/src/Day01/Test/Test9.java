package Day01.Test;

import java.io.*;

/**
 * @author Dangxuchao
 * @Title: Test9
 * @ProjectName 6.1 Java多线程编程核心技术第六章 ：单例模式与多线程
 * @Description: 8、懒汉模式的解决方案5：序列化与反序列化实现；
 * @date 2019/6/7 10:49
 */

class MyObject9 implements Serializable{
    private static final long serialVersionUID = 888L;
    private static class MyObject9Handler{
        private static final MyObject9 object9 = new MyObject9();
    }

    public MyObject9() {
    }
    public static MyObject9 getInstance(){
        return MyObject9Handler.object9;
    }
    protected Object readResolve(){
        System.out.println("调用了方法");
        return MyObject9Handler.object9;
    }
}
public class Test9 {
    public static void main(String[] args) {
        try{
            MyObject9 myObject9 = MyObject9.getInstance();
            FileOutputStream fosRef = new FileOutputStream(
                    new File("C:\\Users\\dangwuxie\\Desktop\\6-7.txt"));
            ObjectOutputStream oosRef = new ObjectOutputStream(fosRef);
            oosRef.writeObject(myObject9);
            oosRef.close();
            fosRef.close();
            System.out.println(myObject9.hashCode());

        }catch (FileNotFoundException a){
            a.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        try {
            FileInputStream fisRef = new FileInputStream(
                    new File("C:\\Users\\dangwuxie\\Desktop\\6-7.txt"));
            ObjectInputStream iosRef = new ObjectInputStream(fisRef);
            MyObject9 myObject9 = (MyObject9) iosRef.readObject();
            iosRef.close();
            fisRef.close();
            System.out.println(myObject9.hashCode());
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
/*
运行结果：

    1173230247
    调用了方法
    1173230247

 */