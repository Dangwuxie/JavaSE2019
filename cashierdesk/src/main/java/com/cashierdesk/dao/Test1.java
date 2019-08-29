package com.cashierdesk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author 灵魂编程者
 * @Title: Test1
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/8/29 16:16
 */
public class Test1 extends BaseDao{

    public static void main(String[] args) {
        new Test1().test();
    }
    public void test(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = this.getConnection(true);
            String updateOrderStatus =
                    "update `order` set order_status=?";
            preparedStatement = connection.prepareStatement(updateOrderStatus);

            preparedStatement.setInt(
                    1,1);
            /*preparedStatement.setTimestamp(
                    2,Timestamp.valueOf(LocalDateTime.now()));*/



            int effect = preparedStatement.executeUpdate();
            System.out.println(effect);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeResource(null,preparedStatement,connection);
        }
    }
}
