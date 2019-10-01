package com.bit.day4.druid;

import com.bit.utils.jdbc_utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Dangxuchao
 * @Title: Druid_Test2
 * @ProjectName JDBC
 * @Description: TODO
 * @date 2019/8/4 22:10
 */
public class Druid_Test2 {
    //使用一下新的工具类jdbc_utils
    public static void main(String[] args) {
        /*
        * 完成一个添加的操作：
        * 给account表添加一条记录
        *
        * */
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            //1、获取连接
            conn = jdbc_utils.getConnection();
            //2、定义sql
            //String sql = "insert into account values(null,?,?)";
            String sql = "delete from account where id=?";
            //3、获取执行sql对象
            pstmt = conn.prepareStatement(sql);
            //pstmt.setString(1,"小二");
            //pstmt.setDouble(2,3000);
            pstmt.setInt(1,4);
            //4、z执行sql
            int count = pstmt.executeUpdate();
            System.out.println(count);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbc_utils.close(pstmt,conn);
        }
    }


}
