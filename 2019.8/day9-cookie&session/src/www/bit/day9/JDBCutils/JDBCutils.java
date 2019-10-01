package www.bit.day9.JDBCutils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Dangxuchao
 * @Title: JDBCutils
 * @ProjectName day7-servlet&http&request
 * @Description: JDBC工具类，使用druid连接池
 * @date 2019/8/8 15:25
 */
public class JDBCutils {

    private static DataSource ds;
    static{
        try {
            //加载配置文件
            Properties pro = new Properties();
            //使用class来加载配置文件获取字节输入流
            InputStream in = JDBCutils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(in);
            //初始化连接池对象
            ds = DruidDataSourceFactory.createDataSource(pro);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //1、获取连接池对象
    public static DataSource getDataSource(){
        return ds;
    }
    //2、获取连接connection对象
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

}
