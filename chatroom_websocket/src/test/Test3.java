import lombok.Generated;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author Dangxuchao
 * @Title: Test3
 * @ProjectName chatroom_websocket
 * @Description: TODO
 * @date 2019/8/18 11:12
 */
class Person{
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
}

public class Test3 {
    public static void add(Integer ia) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<Integer> cls = (Class<Integer>) ia.getClass();

        Field value = cls.getDeclaredField("value");
        value.setAccessible(true);
        value.set(ia,100);


    }
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, NoSuchFieldException, InstantiationException {

        Integer a = 10;
        add(a);
        System.out.println(a);

    }

}
