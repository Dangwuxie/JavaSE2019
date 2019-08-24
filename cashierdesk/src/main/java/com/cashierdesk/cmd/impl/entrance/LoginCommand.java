package com.cashierdesk.cmd.impl.entrance;

import com.cashierdesk.cmd.Subject;
import com.cashierdesk.cmd.annotation.CommandMate;
import com.cashierdesk.cmd.annotation.EntranceCommand;
import com.cashierdesk.cmd.impl.AbstractCommand;
import com.cashierdesk.common.AccountStatus;
import com.cashierdesk.entity.Account;

import java.sql.SQLOutput;

/**
 * @author 灵魂编程者
 * @Title: LoginCommand
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/8/21 14:08
 */

@CommandMate(
        name = "DL",
        desc = "登陆",
        group="入口命令"

)
@EntranceCommand
public class LoginCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        //首先你要判断当前账号是否已经登陆，不能重复登陆
        //如果account值不为空，就是登陆过了
        Account account = subject.getAccount();
        if (account != null){
            System.out.println("你已经登陆过了，不要重复登陆！");
        }
        System.out.println("输入用户名：");
        String username = scanner.nextLine();
        System.out.println("输入密码：");
        String password = scanner.nextLine();

        /*
        * 接下来就是要操作数据库了
        * 通过Accountservice业务层操作dao层，操作数据库
        * */
        account = this.accountService.login(username,password);

        if (account != null
                && account.getAccountStatus() == AccountStatus.UNLOCK){
            System.out.println(account.getAccountType()+"登陆成功");
            subject.setAccount(account);
            
        }else {
            System.out.println("密码或者用户名错误！");
        }

    }
}
