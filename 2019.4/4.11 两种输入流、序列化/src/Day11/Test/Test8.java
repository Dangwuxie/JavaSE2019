package Day11.Test;
//实现对象序列化
import java.io.*;
class Person implements Serializable{
    private String name;
    private Integer age;
    public Person(String name, Integer age) {
        super();
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person [name = "+name+"age = "+age+"]";
    }
}
public class Test8 {
    public static File file = new File(
            "C:\\Users\\dangwuxie\\Desktop\\DXC\\JavaIO\\a.txt");
    public static void main(String[] args) throws Exception {
        dser();
        //ser(new Person("张三",22));
    }
    //系列化 ObjectOutputStream类实现;
    /*public static void ser(Object obj) throws Exception{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(obj);
        oos.close();
    }*/
    //反序列化 ObjectInputStream 类来实现
    public static void dser() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        System.out.println(ois.readObject());
        ois.close();
    }
}
