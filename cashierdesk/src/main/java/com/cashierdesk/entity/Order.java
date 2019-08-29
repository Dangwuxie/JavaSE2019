package com.cashierdesk.entity;

import com.cashierdesk.common.OrderStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    //这个就是每个订单中存放的每一个商品信息；
    private List<OrderItem> orderItemList = new ArrayList<>();


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("【订单信息】*************************************").append("\n");
        sb.append("\t").append("【用户名称】：").append(this.getAccount_name()).append("\n");
        sb.append("\t").append("【订单编号】：").append(this.getId()).append("\n");
        sb.append("\t").append("【订单状态】：").append(this.getOrder_status().getDesc()).append("\n");
        sb.append("\t").append("【创建时间】：").append(this.timeToString(this.getCreate_time())).append("\n");
        if (this.getOrder_status() == OrderStatus.OK) {
            sb.append("\t").append("【完成时间】：")
                    .append(this.timeToString(this.getFinish_time())).append("\n");
        }

        sb.append("【订单金额】*************************************").append("\n");
        sb.append("\t").append("【总金额】：").append(this.moneyToString(this.getTotal_money()))
                .append(" 元 ").append("\n");
        sb.append("\t").append("【优惠金额】：").append(this.moneyToString(this.getDiscount()))
                .append(" 元 ").append("\n");
        sb.append("\t").append("【应支付金额】：").append(this.moneyToString(this.getActual_amount()))
                .append(" 元 ").append("\n");

        return sb.toString();
    }

    private String moneyToString(int money) {
        return String.format("%.2f", 1.00D * money / 100);
    }

    private String timeToString(LocalDateTime time) {
        return DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(time);
    }

    //优惠
    public Integer getDiscount() {
        return this.getTotal_money() - this.getActual_amount();
    }

}
