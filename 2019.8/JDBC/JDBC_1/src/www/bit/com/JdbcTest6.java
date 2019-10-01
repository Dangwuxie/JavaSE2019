package www.bit.com;

import java.sql.*;

/**
 * @author Dangxuchao
 * @Title: JdbcTest6
 * @ProjectName JDBC
 * @Description: TODO
 * @date 2019/8/3 15:45
 */
public class JdbcTest6 {
    public static void main(String[] args) {
        Connection conn6 = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            //1、注册驱动，将Driver类加载进来
            Class.forName("com.mysql.jdbc.Driver");
            //2、取得数据库链接对象Connection
            conn6 = DriverManager.getConnection("jdbc:mysql:///db4","root","123456");
            //3、写sql语句
            String sql = "select  *from account";
            //4、获取执行sql语句的对象Statement
            stmt = conn6.createStatement();
            //5、执行语句
            rs = stmt.executeQuery(sql);
            //6、处理结果
            //6.1、让光标向下移动一行
            rs.next();
            //6.2、获取数据
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double balance = rs.getDouble("balance");
            System.out.println(id+" "+name+" "+balance);
            //再下一行
            rs.next();
            int id2 = rs.getInt(1);
            String name2 = rs.getString(2);
            double balance2 = rs.getDouble(3);
            System.out.println(id2+" "+name2+" "+balance2);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (rs!=null){
                try {
                    conn6.close();
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
            if (conn6!=null){
                try {
                    conn6.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
