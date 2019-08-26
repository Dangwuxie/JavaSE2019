package com.cashierdesk.entity;

import com.cashierdesk.common.OrderStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
/**
 * @author 灵魂编程者
 * @Title: Order
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/8/21 13:13
 */
@Data
public class Order {
    private String id;
    private Integer account_id;
    private String account_name;
    private LocalDateTime create_time;
    private LocalDateTime finish_time;
    //实际支付的钱
    private Integer actual_amount;
    //总金额
    private Integer total_money;
    //订单状态
    private OrderStatus order_status;

    private List<OrderItem> orderItemList = new ArrayList<>();


}
