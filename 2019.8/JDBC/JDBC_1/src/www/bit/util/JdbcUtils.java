package www.bit.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author Dangxuchao
 * @Title: JdbcUtils
 * @ProjectName JDBC
 * @Description: TODO
 * @date 2019/8/4 9:36
 */
public class JdbcUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;
    static{
        //读取资源文件，获取值
        Properties pro = new Properties();
        //加载文件
        try {
            pro.load(new FileReader("D:\\Github\\JavaSE2019\\JDBC\\JDBC_1\\src\\JDBC.properties"));
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
    public static void close(Statement stmt,Connection conn){
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
}
