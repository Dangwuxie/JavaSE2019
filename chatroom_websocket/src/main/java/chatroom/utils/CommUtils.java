package chatroom.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author Dangxuchao
 * @Title: CommUtils
 * @ProjectName chatroom_websocket
 * @Description: 封装基础的工具方法，如加载配置文件，json序列化
 * @date 2019/8/17 20:28
 */
public class CommUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;
    private static final Gson gson = new GsonBuilder().create();
    static{
        //读取资源文件，获取值
        Properties pro = new Properties();
        //加载文件
        try {
            pro.load(new FileReader(
                    "D:\\Github\\JavaSE2019\\chatroom_websocket\\src\\main\\resources\\JDBC.properties"));
            //获取数据，赋值
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");

            //注册驱动
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //返回一个数据库链接对象
    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(url,user,password);
    }
    //加载驱动

    //释放资源
    public static void close(Statement stmt, Connection conn){
        if (stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet rs, Statement stmt, Connection conn){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close(stmt,conn);
    }
    public static String object2Json(Object obj) {
        return gson.toJson(obj);
    }

    public static Object json2Object(String jsonStr,Class objClass) {
        return gson.fromJson(jsonStr,objClass);
    }
    public static boolean strIsNull(String str){
        return str == null || str.equals("");
    }
}
