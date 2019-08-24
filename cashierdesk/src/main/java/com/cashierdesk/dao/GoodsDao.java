package com.cashierdesk.dao;

import com.cashierdesk.entity.Goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 灵魂编程者
 * @Title: GoodsDao
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/8/24 23:08
 */
public class GoodsDao extends BaseDao {
    public List<Goods> quarryAllgoods(){
        //这里边，直接连接数据库查询数据库，查询goods信息，就是list集合
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = this.getConnection(true);



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
