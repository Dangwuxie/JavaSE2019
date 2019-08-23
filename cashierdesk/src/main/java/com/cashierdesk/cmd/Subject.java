package com.cashierdesk.cmd;

import com.cashierdesk.entity.Account;

/**
 * @author 灵魂编程者
 * @Title: Subject
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/8/21 14:22
 */
public class Subject {
    /*
    * 观察对象
    * account，账户，当用户登陆成功之后设置account
    * */
    //new一个Account对象，这个对象存储了登陆账户的信息
    private Account account ;

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return this.account;
    }



}
