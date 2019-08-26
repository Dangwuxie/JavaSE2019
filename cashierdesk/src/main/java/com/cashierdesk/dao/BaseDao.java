package com.cashierdesk.dao;

/*import com.mysql.jdbc.Connection;*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 灵魂编程者
 * @Title: BaseDao
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/8/23 14:23
 */
public class BaseDao {
    /*
    * 连接数据库datasourse
    * 返回Connection对象
    * 关闭conn,stmt，rs等
    * */
    private static volatile DataSource dataSource;//volatile保证


    private DataSource getDataSource(){
        if (dataSource == null){
            synchronized (DataSource.class){
                if (dataSource == null){
                    dataSource = new MysqlDataSource();
                    String host = "127.0.0.1";
                    String port = "3306";
                    ((MysqlDataSource) dataSource).setURL("jdbc:mysql://"+(host+":"+port)+"/cashierdesk?useSSL=false");
                    ((MysqlDataSource) dataSource).setUser("root");
                    ((MysqlDataSource) dataSource).setPassword("123456");
                }
            }
        }
        return dataSource;
    }
    protected Connection getConnection(boolean autoCommit) throws SQLException {
        Connection conn = (Connection) this.getDataSource().getConnection();
        //true，sql命令的提交由驱动负责；自己提交sql命令
        conn.setAutoCommit(autoCommit);
        return conn;

    }

    protected void closeResource(ResultSet rs, PreparedStatement pstmt,Connection conn){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (pstmt != null){
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
//这个看不懂
    public String getSql(String sqlName) {
        System.out.println("=====sqlName:"+sqlName);
        //InputStream 是字节流
        try (InputStream in = this.getClass()
                .getClassLoader()
                .getResourceAsStream("script/" + sqlName.substring(1) + ".sql");
             //这个方法是用来获取配置文件的，方法传入的参数是一个路径
             // 从1 开始提取的原因是：sqlName: @query_order_by_account 去掉@符号
        ) {
            if (in == null) {
                throw new RuntimeException("load sql " + sqlName + " failed");
            } else {

                //InputStreamReader :字节流 通向字符流的桥梁
                try (InputStreamReader isr = new InputStreamReader(in);
                     //BufferedReader -> 从字符输入流中读取文本并缓冲字符
                     BufferedReader reader = new BufferedReader(isr)) {

                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(reader.readLine());
                    String line;
                    while (( line = reader.readLine()) != null) {
                        stringBuilder.append(" ").append(line);
                    }

                    //System.out.println("value:" + stringBuilder.toString());
                    return stringBuilder.toString();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("load sql " + sqlName + " failed");
        }
    }
}
