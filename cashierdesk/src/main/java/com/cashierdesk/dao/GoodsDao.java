package com.cashierdesk.dao;

import com.cashierdesk.entity.Goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> eeaddf556a5d8af909586f56926d14dff007e299
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
<<<<<<< HEAD
        List<Goods> goodsList = new ArrayList<>();
        try{
            connection = this.getConnection(true);
            String sql = "select id,name,introduce,stock,unit,price,discount" +
                    " from goods";
            preparedStatement = connection.prepareStatement(sql);
            //此时查询出来的resultSet是一批商品信息，不止一个
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                //next() 将光标从当前位置向前移一行。
                // 如果光标往后移动一位之后还有值，那么继续进来
                //结果集存放很多goods
                //结果集需要存放到Goods的对象中,定义一个方法返回Goods对象
                Goods goods = this.extractGoods(resultSet);
                //需要一个List集合来保存解析出来的所有(每一条)goods信息
                if (goods != null){
                    goodsList.add(goods);
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeResource(resultSet,preparedStatement,connection);
        }
        return goodsList;
    }
    public Goods extractGoods(ResultSet resultSet) throws SQLException {
        //解析resultSet集合
        Goods goods = new Goods();
        goods.setId(resultSet.getInt("id"));
        goods.setName(resultSet.getString("name"));
        goods.setIntroduce(resultSet.getString("introduce"));
        goods.setStock(resultSet.getInt("stock"));
        goods.setUnit(resultSet.getString("unit"));
        goods.setPrice(resultSet.getInt("price"));
        goods.setDiscount(resultSet.getInt("discount"));

        return goods;
    }

    public boolean putAwayService(Goods goods){
        //直接操作数据库，插入表goods数据
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean effect = false;

        try{
            connection = this.getConnection(true);
            String sql = "insert into goods(id,name,introduce," +
                    "stock,unit,price,discount) values(?,?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);

            effect = (preparedStatement.executeUpdate() == 1);
=======
        try{
            connection = this.getConnection(true);

>>>>>>> eeaddf556a5d8af909586f56926d14dff007e299


        } catch (SQLException e) {
            e.printStackTrace();
        }
<<<<<<< HEAD

=======
>>>>>>> eeaddf556a5d8af909586f56926d14dff007e299
    }
}
