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
    //加一个，需要购买的货物的数量
    private Integer buyNum;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("【商品信息】:").append("\n")
                .append("【商品编号】").append(this.getId()).append("\n")
                .append("【商品名称】").append(this.getName()).append("\n")
                .append("【商品介绍】").append(this.getIntroduce()).append("\n")
                .append("【商品库存】").append(this.getStock()).append(this.getUnit()).append("\n")
                .append("【商品价格】").append(String.format("%.2f",1.00D*this.getPrice() / 100))
                .append("元").append("\n")
                .append("【商品折扣】").append(this.getDiscount()).append("折").append("\n");
        sb.append("==============================================================");

        return sb.toString();
    }
}
