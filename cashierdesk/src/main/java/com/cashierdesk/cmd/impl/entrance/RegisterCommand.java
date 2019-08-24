package com.cashierdesk.cmd.impl.entrance;

import com.cashierdesk.cmd.Subject;
import com.cashierdesk.cmd.annotation.CommandMate;
import com.cashierdesk.cmd.annotation.EntranceCommand;
import com.cashierdesk.cmd.impl.AbstractCommand;
import com.cashierdesk.common.AccountStatus;
import com.cashierdesk.common.AccountType;
import com.cashierdesk.entity.Account;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author 灵魂编程者
 * @Title: RegisterCommand
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/8/21 14:08
 */

@CommandMate(
        name = "ZC",
        desc = "注册",
        group="入口命令"

)
@EntranceCommand
public class RegisterCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        //在这个里面开始注册
        System.out.println("请输入用户名：");
        String username = scanner.nextLine();
        System.out.println("请输入密码：");
        String password1 = scanner.nextLine();
        System.out.println("请再次确认密码：");
        String password2 = scanner.nextLine();
        if (!password1.equals(password2)){
            System.out.println("两次密码不一致！");
            return;
        }

        System.out.println("请输入真实姓名：");
        String name = scanner.nextLine();

        System.out.println("请选择账户类型：1.管理员 2.普通用户");
        int accountType = scanner.nextInt();
        AccountType accountType2 = AccountType.valueOf(accountType);

        System.out.println("请设置账户状态：1.启用 2.停用");
        int  accountStatus = scanner.nextInt();
        AccountStatus accountStatus2 = AccountStatus.valueOf(accountStatus);

        //不可以被改变的账户对象
        final Account account = new Account();
        account.setUsername(username);
        account.setPassword(password1);
        account.setName(name);
        account.setAccountType(accountType2);
        account.setAccountStatus(accountStatus2);

        //调用service层，dao层，存入数据库
        boolean registerStatus =  this.accountService.register(account);
        if (registerStatus){
            System.out.println("恭喜你！注册成功！");
        }else {
            System.out.println("不好意思，注册失败，可能是数据库蹦了。。。");
        }
    }
}










