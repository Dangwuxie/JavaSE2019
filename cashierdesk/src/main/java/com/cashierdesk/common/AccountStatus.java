package com.cashierdesk.common;

import lombok.Getter;
import lombok.ToString;

/**
 * @author 灵魂编程者
 * @Title: AccountStatus
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/8/21 13:15
 */
@Getter
@ToString
public enum AccountStatus {
    //账户的状态，开启或者停用
    UNLOCK(1,"启用"),LOCK(2,"停用");
    private int flg;
    private String desc;
    AccountStatus(int flg, String desc) {
        this.flg = flg;
        this.desc = desc;
    }

    public static AccountStatus valueOf(int flg){
        for (AccountStatus accountStatus:values()){
            if (accountStatus.flg == flg){
                return accountStatus;
            }
        }
        throw new RuntimeException("accountStatus flg"+flg+"找不到！");
    }
}
