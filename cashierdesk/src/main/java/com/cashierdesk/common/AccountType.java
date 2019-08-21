package com.cashierdesk.common;

/**
 * @author 灵魂编程者
 * @Title: AccountType
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/8/21 13:15
 */
public enum AccountType {
    //账户的状态，开启或者停用
    ADMIN(1,"管理员"),CUSTOMER(2,"客户");

    private int flg;
    private String desc;
    AccountType(int flg, String desc) {
        this.flg = flg;
        this.desc = desc;
    }

    public AccountType valueOf(int flg){
        for (AccountType accountType:values()){
            if (accountType.flg == flg){
                return accountType;
            }
        }
        throw new RuntimeException("accountStatus flg"+flg+"找不到！");
    }
}
