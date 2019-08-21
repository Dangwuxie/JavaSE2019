package com.cashierdesk.cmd;

import com.cashierdesk.cmd.impl.AbstractCommand;

/**
 * @author 灵魂编程者
 * @Title: CheckCode
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/8/21 23:19
 */
public class CheckCode extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        Commands.getCachedHelpCommands().execute(subject);
    }

    public static void main(String[] args) {
        Subject subject = new Subject();
        new CheckCode().execute(subject);
    }

}
