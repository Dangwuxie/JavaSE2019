package com.cashierdesk.common;

import lombok.Getter;
import lombok.ToString;

/**
 * @author 灵魂编程者
 * @Title: OrderStatus
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/8/21 13:16
 */
@ToString
@Getter
public enum OrderStatus {
    //账户的状态，开启或者停用
    PAYING(1,"待支付"),OK(2,"支付完成");

    private int flg;
    private String desc;

    OrderStatus(int flg, String desc) {
        this.flg = flg;
        this.desc = desc;
    }

    public static OrderStatus valueOf(int flg){
        for (OrderStatus orderStatus:values()){
            if (orderStatus.flg == flg){
                return orderStatus;
            }
        }
        throw new RuntimeException("accountStatus flg"+flg+"找不到！");
    }
}
