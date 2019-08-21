package com.cashierdesk.entity;
import lombok.Data;
/**
 * @author 灵魂编程者
 * @Title: Goods
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/8/21 13:09
 */
@Data
public class Goods {
    private Integer id;
    private String name;
    //介绍
    private String introduce;
    //库存
    private Integer stock;
    //单位
    private String unit;
    //价格
    private Integer price;
    //折扣，90，9折
    private Integer discount;
}
