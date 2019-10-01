package com.bit.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author Dangxuchao
 * @Title: jdbc_utils
 * @ProjectName JDBC
 * @Description: 连接池工具类
 * @date 2019/8/4 19:28
 */
public class jdbc_utils {
    //定义一个成员变量
    private static DataSource ds;
    static {
        //加载配置文件
        Properties pro = new Properties();
        try {
            pro.load(jdbc_utils.class.getClassLoader().getResourceAsStream("druid.properties"));

            //获取DataSource
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取连接的方法
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    //归还资源
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
    public static void close(Statement stmt,Connection conn,ResultSet rs){
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
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static DataSource getDs(){
        return ds;
    }
}
