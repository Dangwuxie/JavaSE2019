import org.junit.Test;

import java.sql.*;

/**
 * @author Dangxuchao
 * @Title: JDBC_Test1
 * @ProjectName chatroom_websocket
 * @date 2019/8/16 21:21
 */
public class JDBC_Test1 {
    @Test
    public void test(){

        try {
            //1、加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、获取数据库驱动Connection
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql:///day7","root","123456");
            //3、执行sql
            /*String sql = "select * from user";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);// stmt.executeUpdate()*/
            //3\1,使用PreparedStatement对象解决sql注入问题
            String sql = "select * from user"+"where username = ? and password = ?";
            //预编译SQL
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,"zs");
            ps.setString(2,"123");
            ResultSet rs = ps.executeQuery();
            //4、遍历结果集
            if (rs.next()){
                System.out.println("登陆成功");
            }else {
                System.out.println("登陆失败");
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
