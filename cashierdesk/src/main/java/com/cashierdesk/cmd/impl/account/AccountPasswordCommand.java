package com.cashierdesk.cmd.impl.account;

import com.cashierdesk.cmd.Command;
import com.cashierdesk.cmd.Subject;
import com.cashierdesk.cmd.annotation.AdminCommand;
import com.cashierdesk.cmd.annotation.CommandMate;
import com.cashierdesk.cmd.impl.AbstractCommand;

/**
 * @author 灵魂编程者
 * @Title: AccountPasswordCommand
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/8/21 14:07
 */
@CommandMate(
        name = "MMCZ",
        desc = "密码重置",
        group="账户信息"

)
@AdminCommand
public class AccountPasswordCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        super.execute(subject);
    }
}
