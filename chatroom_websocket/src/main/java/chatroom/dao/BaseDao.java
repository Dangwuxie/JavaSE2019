package chatroom.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author Dangxuchao
 * @Title: JDBCUtils1
 * @ProjectName chatroom_websocket
 * @Description: 基于DruidDataSource
 * @date 2019/8/17 21:54
 */
public class BaseDao {
    private static DruidDataSource dataSource;
    static{

        try {
            Properties properties = new Properties();
            properties.load(new FileReader(
                    "D:\\Github\\JavaSE2019\\chatroom_websocket\\src\\main\\resources\\datasource.properties"));
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static DruidPooledConnection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            System.out.println("获取数据源失败");
        }
        return null;
    }

    public static void closeResources(Statement stmt, Connection conn){
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
    public static void closeResources(ResultSet rs, Statement stmt, Connection conn){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        closeResources(stmt,conn);
    }
}
