package com.cashierdesk.cmd.impl.order;

import com.cashierdesk.cmd.Subject;
import com.cashierdesk.cmd.annotation.CommandMate;
import com.cashierdesk.cmd.annotation.CustomerCommand;
import com.cashierdesk.cmd.impl.AbstractCommand;
import com.cashierdesk.entity.Order;

import java.util.List;

/**
 * @author 灵魂编程者
 * @Title: OrderBrowseCommand
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/8/21 14:10
 */
@CommandMate(
        name = "LLDD",
        desc = "浏览订单",
        group="订单信息"

)
@CustomerCommand
public class OrderBrowseCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        System.out.println("以下是我的订单信息：");
        //因为order订单有多个项，
        //所以继续使用List来添加从数据库表中获取的order条目
        List<Order> orderList =
                this.orderService.queryOrderByAccount(subject.getAccount().getId());


    }
}
