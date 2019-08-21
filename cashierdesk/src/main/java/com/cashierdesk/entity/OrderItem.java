package com.cashierdesk.entity;
import lombok.Data;
/**
 * @author 灵魂编程者
 * @Title: OrderItem
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/8/21 13:20
 */
@Data
public class OrderItem {
    private Integer id;
    private String orderId;
    private Integer goodsId;
    private String goodsName;
    private String goodsIntroduce;
    //商品个数，数量
    private Integer goodsNum;
    //商品单位
    private String goodsUnit;
    //价格
    private Integer goodsPrice;
    //折扣
    private Integer goodsDiscount;
}
