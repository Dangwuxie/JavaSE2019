package com.cashierdesk.service;

import com.cashierdesk.dao.OrderDao;
import com.cashierdesk.entity.Order;

import java.util.List;

/**
 * @author 灵魂编程者
 * @Title: OrderService
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/8/25 23:20
 */
public class OrderService {
    //提供订单服务，展示订单以及创建订单，交付订单
    private OrderDao orderDao;

    public OrderService() {
        this.orderDao = new OrderDao();
    }

    public List<Order> queryOrderByAccount(Integer accountId){
        return this.orderDao.queryOrderByAccount(accountId);
    }

    public boolean commitOrder(Order order){
        return this.orderDao.commitOrder(order);
    }
}
