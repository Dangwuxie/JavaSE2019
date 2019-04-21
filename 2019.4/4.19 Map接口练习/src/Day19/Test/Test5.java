package Day19.Test;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Collections;
import java.util.Properties;

public class Test5 {
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\dangwuxie\\Desktop\\6666.properties");
        Properties properties = new Properties();
       /* properties.setProperty("user","root");
        properties.setProperty("password","123456");
        properties.store(new FileOutputStream(file),"database 999");*/
       properties.load(new FileInputStream(file));
        System.out.println(properties.getProperty("user"));
        System.out.println(properties.getProperty("password"));

    }
}
