package com.cashierdesk.cmd.impl.common;

import com.cashierdesk.cmd.Subject;
import com.cashierdesk.cmd.annotation.AdminCommand;
import com.cashierdesk.cmd.annotation.CommandMate;
import com.cashierdesk.cmd.annotation.CustomerCommand;
import com.cashierdesk.cmd.annotation.EntranceCommand;
import com.cashierdesk.cmd.impl.AbstractCommand;

/**
 * @author 灵魂编程者
 * @Title: QuitCommand
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/8/21 14:08
 */
@CommandMate(
        name = "TCXT",
        desc = "退出系统",
        group="公共命令"

)
@AdminCommand
@CustomerCommand
@EntranceCommand
public class QuitCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        System.out.println("退出系统，欢迎下次使用！");
        this.scanner.close();
        //exit(int status)   终止当前正在运行的 Java 虚拟机。
        System.exit(0);
    }
}
