package com.cashierdesk.service;

import com.cashierdesk.dao.Accountdao;
import com.cashierdesk.entity.Account;

/**
 * @author 灵魂编程者
 * @Title: AccountService
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/8/22 23:39
 */
/*
* 这是一个服务，就是程序运行起来的时候这个服务就需要启动起来
* */
public class AccountService {
    //启动这个服务
    //在这个里面操作dao层
    public Accountdao accountdao;

    public AccountService() {
        this.accountdao = new Accountdao();
    }

    //此类里面还需要完成登陆数据库的操作
    //提供一个方法
    public Account login(String username,String password){
       return accountdao.login(username,password);
    }

    public boolean register(Account account){
        return accountdao.register(account);
    }
}
