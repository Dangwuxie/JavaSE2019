package com.cashierdesk.dao;

/*import com.mysql.jdbc.Connection;*/
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

}
