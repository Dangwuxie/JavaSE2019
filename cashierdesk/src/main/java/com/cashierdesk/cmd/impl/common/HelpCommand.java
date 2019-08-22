package com.cashierdesk.cmd.impl.common;

import com.cashierdesk.cmd.Command;
import com.cashierdesk.cmd.Commands;
import com.cashierdesk.cmd.Subject;
import com.cashierdesk.cmd.annotation.AdminCommand;
import com.cashierdesk.cmd.annotation.CommandMate;
import com.cashierdesk.cmd.annotation.CustomerCommand;
import com.cashierdesk.cmd.annotation.EntranceCommand;
import com.cashierdesk.cmd.impl.AbstractCommand;
import com.cashierdesk.entity.Account;

import java.util.*;

/**
 * @author 灵魂编程者
 * @Title: HelpCommand
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/8/21 14:08
 */
@CommandMate(
        name = "BZXX",
        desc = "帮助信息",
        group="公共命令"

)
@AdminCommand
@CustomerCommand
@EntranceCommand
public class HelpCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        System.out.println("helpCommand");
        Account account = subject.getAccount();
        if (account == null){
            //如果是空
            entranceHelp();
        }else{
            //如果不为空，那么就要判断是什么情况的命令了
            switch (account.getAccountType()){
                case CUSTOMER:
                    break;
                case ADMIN:
                    break;
                    default:
            }
        }
    }
    public void entranceHelp(){
        //调用map的values方法，会返回map所有的Value的集合
        print("欢迎！",Commands.ENTRANCE_COMMANDS.values());
    }
    public void print(String title, Collection<Command> collection){
        //打印欢迎
        System.out.println("**************"+title+"**************");

        Map<String,List<String>> helpInfo = new HashMap<>();
        //遍历它的命令
        for (Command command:collection){
            CommandMate commandMate =
                    command.getClass().getDeclaredAnnotation(CommandMate.class);

            //接下来group设置,
            String group = commandMate.group();//就是key
            //func里面放的是desc和name的值
            List<String> func = helpInfo.get(group);
            if (func == null){
                func = new ArrayList<>();
                helpInfo.put(group,func);
            }
            //不为空直接add就行
            func.add(commandMate.desc()+"("+commandMate.name()+")");
            //取出键值对的集合

        }
        int i = 0;
        for (Map.Entry<String,List<String>> entry : helpInfo.entrySet()){

            i++;
            System.out.println(i+"."+entry.getKey());

            int j = 0;
            for (String item:entry.getValue()){
                j++;
                System.out.println("\t"+(i)+"."+(j)+" "+item);
            }
        }
        System.out.println("输入菜单括号后面的编号(忽略大小写)，进行下一步操作");
        System.out.println("*********************************************");
    }
}
