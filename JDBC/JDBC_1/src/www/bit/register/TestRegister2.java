package www.bit.register;

import www.bit.util.JdbcUtils;

import java.sql.*;
import java.util.Scanner;

/**
 * @author Dangxuchao
 * @Title: TestRegister2
 * @ProjectName JDBC
 * @Description: 改良版本
 * @date 2019/8/4 13:16
 */
public class TestRegister2 {
    public static void main(String[] args) {
        //键盘录入
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();
        login(username,password);
    }
    /*
     1、通过键盘登入用户名和密码
     2、判断用户是否登陆成功
    */
    public static void login(String username,String password){
        if (username==null && password==null){
            return ;
        }
        Connection connT = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            //获取数据库链接
            connT =  JdbcUtils.getConnection();
            String sql = "select * from user where username=? and password= ?";
            pstmt = connT.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            rs = pstmt.executeQuery();
            //判断结果集有没有数据，并且确认一些
            //System.out.println(rs.next());
            if (rs.next()){
                System.out.println(rs);
                System.out.println("登陆成功");

            }else {
                System.out.println("登陆失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(rs,pstmt,connT);
        }
    }
}
