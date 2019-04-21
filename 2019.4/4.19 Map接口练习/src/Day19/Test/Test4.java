package Day19.Test;

import java.util.Properties;

public class Test4 {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","123456");
        System.out.println(properties.getProperty("user"));
        System.out.println(properties.getProperty("password"));
        System.out.println(properties.getProperty("charSet"));
        System.out.println(properties.getProperty("charSet","UTF-8"));

    }
}
