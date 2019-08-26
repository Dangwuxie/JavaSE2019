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
        order.setCreate_time(resultSet.getTimestamp("create_time").toLocalDateTime());
        Timestamp finish_time = resultSet.getTimestamp("finish_time");
        //次数如果订单还没有完成支付，那么就不会提取到数据
        if (finish_time!=null){
            order.setFinish_time(finish_time.toLocalDateTime());
        }
        order.setActual_amount(resultSet.getInt("actual_amount"));
        order.setTotal_money(resultSet.getInt("total_money"));
        order.setOrder_status(OrderStatus.valueOf(resultSet.getInt("order_status")));

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
}
