package www.bit.com;

import www.bit.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Dangxuchao
 * @Title: JdbcTest9
 * @ProjectName JDBC
 * @Description: JDBC实现事务管理
 * @date 2019/8/4 13:49
 */
public class JdbcTest9 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;

        try {
            //获取连接
            conn = JdbcUtils.getConnection();
            //开始事务
            conn.setAutoCommit(false);

            //定义sql
            //张三
            String sql1 = "update account set balance = balance-? where id=?";
            //李四
            String sql2 = "update account set balance = balance+? where id=?";

            //获取执行sql对象
           pstmt1 = conn.prepareStatement(sql1);
           pstmt2 = conn.prepareStatement(sql2);

           //设置参数
            pstmt1.setDouble(1,500);
            pstmt1.setInt(2,1);

            pstmt2.setDouble(1,500);
            pstmt2.setInt(2,2);

            pstmt1.executeUpdate();
            pstmt2.executeUpdate();

            conn.commit();

        } catch (SQLException e) {
            //在catch里面进行回滚的操作
            try {
                if (conn !=null){
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JdbcUtils.close(pstmt1,conn);
            JdbcUtils.close(pstmt2,null);
        }
    }
}
