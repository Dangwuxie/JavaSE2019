package Day11.Test;
//使用transient关键字进行序列化选择性保存

import java.io.*;

class Person9 implements Serializable{
    private transient String name;
    private Integer age;

    public Person9(String name, Integer age) {
        super();
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person [name = "+name+"age = "+age+"]";
    }
}
public class Test9 {
    public static final File FILE = new File("C:\\Users\\" +
            "dangwuxie\\Desktop\\DXC\\JavaIO\\a.txt");
    public static void main(String[] args) throws Exception {
        ser(new Person9("李四",666));
        dser();
    }
    //先序列化
    public static void ser(Object obj) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE));
        oos.writeObject(obj);
        oos.close();
    }
    //然后再反序列化
    public static void dser() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE));
        System.out.println(ois.readObject());
        ois.close();
    }
}
