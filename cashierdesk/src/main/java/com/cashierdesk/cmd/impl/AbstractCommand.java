package com.cashierdesk.cmd.impl;

import com.cashierdesk.cmd.Command;
import com.cashierdesk.cmd.Subject;
import com.cashierdesk.service.AccountService;
import com.cashierdesk.service.GoodsService;
import com.cashierdesk.service.OrderService;

/**
 * @author 灵魂编程者
 * @Title: AbstractCommand
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/8/21 14:28
 */
public abstract class AbstractCommand implements Command {

    public void printlnInfo(String string){
        System.out.println("请输入"+string+":");
    }

    public AccountService accountService;
    public GoodsService goodsService;
    public OrderService orderService;
    public AbstractCommand(){
        this.accountService = new AccountService();
        this.goodsService = new GoodsService();
        this.orderService = new OrderService();

    }

}
