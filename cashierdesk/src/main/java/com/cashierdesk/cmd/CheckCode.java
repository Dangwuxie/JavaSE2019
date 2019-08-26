package com.cashierdesk.cmd;

import com.cashierdesk.cmd.impl.AbstractCommand;
import com.cashierdesk.entity.Account;

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
        while (true){
            System.out.print(">>>");
            String line = scanner.nextLine();
             //trim() :返回字符串的副本，忽略前导空白和尾部空白
            String commandLine = line.trim().toUpperCase();
            //此时输入了命令，commandLine,还没有登陆
            Account account = subject.getAccount();
            if (account == null){
                //如果账户此时是空的，就应该先让用户登陆
                //把命令传进去，然后执行；
                Commands.getEntranceCommand(commandLine).execute(subject);
            }else {
                switch (account.getAccountType()){
                    case ADMIN:
                        Commands.getAdminCommand(commandLine).execute(subject);
                        break;
                    case CUSTOMER:
                        Commands.getCustomerCommand(commandLine).execute(subject);
                        break;
                    default:
                }
            }
        }
    }

    public static void main(String[] args) {
        Subject subject = new Subject();
        new CheckCode().execute(subject);
    }

}
