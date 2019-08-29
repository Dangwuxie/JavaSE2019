package com.cashierdesk.dao;

import com.cashierdesk.common.OrderStatus;
import com.cashierdesk.entity.Order;
import com.cashierdesk.entity.OrderItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 灵魂编程者
 * @Title: OrderDao
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/8/25 23:22
 */
public class OrderDao extends BaseDao{
    //OrderDao层就是直接与数据库连接操作的层
    List<Order> orderList = new ArrayList<>();

    public boolean commitOrder(Order order){
        //连接数据库，实现具体的订单插入操作
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        //编写两条sql语句，分别插入order表和orderItem表中
        String insertOrderSql = "insert into `order`" +
                "(id, account_id, create_time, finish_time" +
                ", actual_amount, total_money, order_status," +
                " account_name) values (?,?,?,?,?,?,?,?)";

        String insertOrderItemSql = "insert into order_item(" +
                "order_id, goods_id, goods_name, goods_introduce," +
                " goods_num, goods_unit, goods_price, " +
                "goods_discount) VALUES (?,?,?,?,?,?,?,?)";

        boolean isInsertSQL = false;
        try{
            //这个try语句里面就是设置预编译语句
            //首先关闭单条语句自动事务提交，因为每一次order或者orderItem的更新
            //多条SQL语句的执行是不可分割的
            connection =  this.getConnection(false);

            //然后先预编译order订单的sql语句，此时需要插入语句
            preparedStatement = connection.prepareStatement(insertOrderSql);

            preparedStatement.setString(1,order.getId());
            preparedStatement.setInt(2,order.getAccount_id());
            //设置为数据库的时间格式
            preparedStatement.setTimestamp(
                    3, Timestamp.valueOf(order.getCreate_time()));
            preparedStatement.setTimestamp(
                    4,order.getFinish_time()==null?null: Timestamp.valueOf(order.getFinish_time()));
            preparedStatement.setInt(5,order.getActual_amount());
            preparedStatement.setInt(6,order.getTotal_money());
            preparedStatement.setInt(7,order.getOrder_status().getFlg());
            preparedStatement.setString(8,order.getAccount_name());

            isInsertSQL = (preparedStatement.executeUpdate() == 1);

            preparedStatement = connection.prepareStatement(insertOrderItemSql);
            //下面就是取出当前的order中的商品清单了，
            for (OrderItem orderItem:order.getOrderItemList()){
                preparedStatement.setString(1,orderItem.getOrderId());
                preparedStatement.setInt(2,orderItem.getGoodsId());
                preparedStatement.setString(3,orderItem.getGoodsName());
                preparedStatement.setString(4,orderItem.getGoodsIntroduce());

                preparedStatement.setInt(5,orderItem.getGoodsNum());
                preparedStatement.setString(6,orderItem.getGoodsUnit());
                preparedStatement.setInt(7,orderItem.getGoodsPrice());
                preparedStatement.setInt(8,orderItem.getGoodsDiscount());

                //注意一下，这里为了节省时间，可以使用statement对象的批命令处理
                //添加进批命令处理
                preparedStatement.addBatch();
            }

            //循环完了之后，执行执行这一批命令
            int[] insertOrderItem = preparedStatement.executeBatch();

            //因为这一批命令是一次事务，所以必须每一句都执行成功
            for (int i:insertOrderItem){
                isInsertSQL = (i == 1);
            }
            if (isInsertSQL){
                //此处代表所有语句执行成功，可以提交事务
                connection.commit();
            }else {
                //否则就是至少有一句没有提交成功，需要回滚事务
                connection.rollback();
            }

        } catch (SQLException e) {
            System.out.println("2输入错误，请重新输入你所需要的操作:");
            //此处为何还需要判断一下???
            if (connection!=null){
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }finally {
            this.closeResource(null,preparedStatement,connection);
        }
        return isInsertSQL;
    }

    public List<Order> queryOrderByAccount(Integer accountId){
        //进入此方法查询数据库order表，返回一个List集合
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            connection = this.getConnection(true);
            String sql = this.getSql("@query_order_by_account");
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,accountId);

            resultSet = preparedStatement.executeQuery();
            Order order = null;

            while(resultSet.next()){
                //因为一个账户可以有很多订单，所以查询出来的订单不止一个
                //如果从订单列表中查询出来有订单,就循环获取i的订单对象
                if (order == null){
                    order = new Order();
                    //下面把从数据库中查询出来的数据设置进Order对象中
                    //提取
                    this.extract(order,resultSet);
                    orderList.add(order);
                    //本来此处可以直接跳出，到达下一次循环，可是表单还需要添加表单项，
                    //所以需要执行到下面的代码
                }
                //如果不为空，先获取当前的order的id，需要判断一下是不是同一个订单
                String orderId = resultSet.getString("order_id");
                //获取resultSet中的数据，获取orderid之后，
                //因为要给当前的表单添加表单项，
                // 所以需要判断表单项中存储的对应订单的id是不是相同
                //如果相同那就需要new一个新的订单然后
                // 添加这个当前查到的orderid项全部添加进当前order类中的
                // OrderItemList中去
                if (!orderId.equals(order.getId())){
                    order = new Order();
                    this.extract(order,resultSet);
                    orderList.add(order);
                }

                OrderItem orderItem = this.orderItemExtract(resultSet);
                order.getOrderItemList().add(orderItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeResource(resultSet,preparedStatement,connection);
        }
        return orderList;
    }

    private void extract(final Order order,ResultSet resultSet) throws SQLException {
        //提取数据集中的数据到具体的order对象中去
        order.setId(resultSet.getString("order_id"));
        order.setAccount_id(resultSet.getInt("account_id"));
        order.setAccount_name(resultSet.getString("account_name"));
        order.setCreate_time(
                resultSet.getTimestamp("create_time").toLocalDateTime());
        Timestamp finish_time = resultSet.getTimestamp("finish_time");
        //次数如果订单还没有完成支付，那么就不会提取到数据
        if (finish_time!=null){
            order.setFinish_time(finish_time.toLocalDateTime());
        }
        order.setActual_amount(resultSet.getInt("actual_amount"));
        order.setTotal_money(resultSet.getInt("total_money"));
        order.setOrder_status(
                OrderStatus.valueOf(resultSet.getInt("order_status")));

    }

    private OrderItem orderItemExtract(ResultSet resultSet) throws SQLException {
        //下面就是提取resultset结果集中的数据到orderItem对象中
        OrderItem orderItem = new OrderItem();
        //此处的order-id和订单中的order-id应该是对应的；
        orderItem.setOrderId(resultSet.getString("order_id"));
        orderItem.setGoodsId(resultSet.getInt("goods_id"));
        orderItem.setGoodsName(resultSet.getString("goods_name"));
        orderItem.setGoodsIntroduce(resultSet.getString("goods_introduce"));

        orderItem.setGoodsNum(resultSet.getInt("goods_num"));
        orderItem.setGoodsUnit(resultSet.getString("goods_unit"));
        orderItem.setGoodsPrice(resultSet.getInt("goods_price"));
        orderItem.setGoodsDiscount(resultSet.getInt("goods_discount"));

        return null;

    }

    //用户提交订单之后更新订单信息
    public boolean updateOrderStatus(Order order){
        //此处更新订单的提交时间以及状态
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = this.getConnection(true);
            String updateOrderStatus =
                    "update `order` set order_status=?,finish_time=? where account_id=?";
            preparedStatement = connection.prepareStatement(updateOrderStatus);

            preparedStatement.setInt(
                    1,order.getOrder_status().getFlg());
            preparedStatement.setTimestamp(
                    2,Timestamp.valueOf(order.getFinish_time()));

            preparedStatement.setInt(3,order.getAccount_id());

            boolean effect = (preparedStatement.executeUpdate() >= 1);

            return effect;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeResource(null,preparedStatement,connection);
        }

        return false;
    }


}
