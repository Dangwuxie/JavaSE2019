package com.cashierdesk.entity;

import com.cashierdesk.common.AccountStatus;
import com.cashierdesk.common.AccountType;
import lombok.Data;
/**
 * @author 灵魂编程者
 * @Title: Account
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/8/21 13:04
 */
/*
* 账户信息，存储登陆的账户一些信息
* */
@Data
public class Account {
    private Integer id;
    private String username;
    private String password;
    private String name;
    //此处需要枚举，因为账号的类型分为管理员和用户,AccountType类用来枚举
    private AccountType accountType;

    private AccountStatus accountStatus;


}
