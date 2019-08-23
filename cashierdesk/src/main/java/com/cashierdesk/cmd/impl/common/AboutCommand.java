package com.cashierdesk.cmd.impl.common;

import com.cashierdesk.cmd.Subject;
import com.cashierdesk.cmd.annotation.AdminCommand;
import com.cashierdesk.cmd.annotation.CommandMate;
import com.cashierdesk.cmd.annotation.CustomerCommand;
import com.cashierdesk.cmd.annotation.EntranceCommand;
import com.cashierdesk.cmd.impl.AbstractCommand;

/**
 * @author 灵魂编程者
 * @Title: AboutCommand
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/8/21 14:08
 */
@CommandMate(
        name = "GYXT",
        desc = "关于系统",
        group="公共命令"

)
@AdminCommand
@CustomerCommand
@EntranceCommand
public class AboutCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        System.out.println("*****基于字符界面的购物车交付系统*******");
        System.out.println("************作者：灵魂编程者***********");
        System.out.println("**********时间：2019-08-05************");
        System.out.println("**************************************");
    }
}
