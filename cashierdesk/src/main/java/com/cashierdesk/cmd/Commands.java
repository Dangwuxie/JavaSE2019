package com.cashierdesk.cmd;

import com.cashierdesk.cmd.annotation.AdminCommand;
import com.cashierdesk.cmd.annotation.CommandMate;
import com.cashierdesk.cmd.annotation.CustomerCommand;
import com.cashierdesk.cmd.annotation.EntranceCommand;
import com.cashierdesk.cmd.impl.account.AccountBrowseCommand;
import com.cashierdesk.cmd.impl.account.AccountPasswordCommand;
import com.cashierdesk.cmd.impl.account.AccountStatuseSetCommand;
import com.cashierdesk.cmd.impl.common.AboutCommand;
import com.cashierdesk.cmd.impl.common.HelpCommand;
import com.cashierdesk.cmd.impl.common.QuitCommand;
import com.cashierdesk.cmd.impl.entrance.LoginCommand;
import com.cashierdesk.cmd.impl.entrance.RegisterCommand;
import com.cashierdesk.cmd.impl.goods.GoodsBrowseCommand;
import com.cashierdesk.cmd.impl.goods.GoodsPutAwayCommand;
import com.cashierdesk.cmd.impl.goods.GoodsSoldOutCommand;
import com.cashierdesk.cmd.impl.goods.GoodsUpdateCommand;
import com.cashierdesk.cmd.impl.order.OrderBrowseCommand;
import com.cashierdesk.cmd.impl.order.OrderPayCommand;

import java.util.*;

/**
 * @author 灵魂编程者
 * @Title: Commands
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/8/21 15:19
 */
public class Commands {
    //此类统一管理命令，分类命令
    /*
    * 写一个map集合，保存三个命令。
    * final修饰，无法修改
    * */
    public static final Map<String,Command> ADMIN_COMMANDS = new HashMap<>();
    public static final Map<String,Command> CUSTOMER_COMMANDS = new HashMap<>();
    public static final Map<String,Command> ENTRANCE_COMMANDS = new HashMap<>();

    //存放所有命令的集合
    private static final Set<Command> COMMANDS = new HashSet<>();

    private static final Command CACHED_HELP_COMMANDS;

    //当程序启动起来的时候，所有的命令已经分类完毕了，全部放到集合里面
    //静态代码块可以实现此功能,静态代码块一加载后，
    // 所有的命令都会加载到COMMANDS这个集合里面
    //
    static{
        Collections.addAll(
                COMMANDS,
                new AccountBrowseCommand(),
                new AccountPasswordCommand(),
                new AccountStatuseSetCommand(),

                new AboutCommand(),
                //HelpCommand
                CACHED_HELP_COMMANDS = new HelpCommand(),
                new QuitCommand(),

                new LoginCommand(),
                new RegisterCommand(),

                new GoodsBrowseCommand(),
                new GoodsPutAwayCommand(),
                new GoodsSoldOutCommand(),
                new GoodsUpdateCommand(),

                new OrderBrowseCommand(),
                new OrderPayCommand()

        );
        //遍历命令集合，然后看他是什么注解，
        for (Command command:COMMANDS){
            //此时利用反射将命令进行分类，放到不同的Map里面
            Class<?> cls = command.getClass();
            //获取注解,
            //通过反射获得class文件中的注解
            /*拿到不同类的注解，*/
            AdminCommand adminCommand =
                    cls.getDeclaredAnnotation(AdminCommand.class);
            CustomerCommand customerCommand =
                    cls.getDeclaredAnnotation(CustomerCommand.class);
            EntranceCommand entranceCommand =
                    cls.getDeclaredAnnotation(EntranceCommand.class);

            CommandMate commandMate =
                    cls.getDeclaredAnnotation(CommandMate.class);

            //利用反射将所有的command命令信息放到map表里面
            if (commandMate != null){
                continue;
            }
            String commandKey = commandMate.name();
            if (adminCommand != null){
                ADMIN_COMMANDS.put(commandKey,command);
            }
            if (customerCommand != null){
                CUSTOMER_COMMANDS.put(commandKey,command);
            }
            if (entranceCommand != null){
                ENTRANCE_COMMANDS.put(commandKey,command);
            }

        }
    }
    //得到缓存的命令，帮助、关于等命令
    public static Command getCachedHelpCommands(){
        return CACHED_HELP_COMMANDS;
    }

    public static Command getCustomerCommand(String commandKey){
        //遍历map，返回就行
        return getCommand(commandKey,CUSTOMER_COMMANDS);
    }public static Command getEntranceCommand(String commandKey){
        //遍历map，返回就行
        return getCommand(commandKey,ENTRANCE_COMMANDS);
    }
    //
    public static Command getAdminCommand(String commandKey){
        //遍历map，返回就行
        return getCommand(commandKey,ADMIN_COMMANDS);
    }
    public static Command getCommand(String commandKey,Map<String,Command> commandMap){
        //遍历响应的Map，根据commandKey得到对应的value值
        //getOrDefault的意思就是说，找不到的话就返回一个缓存好的命令
        //CACHED_HELP_COMMANDS就是默认命令，帮助命令
        return commandMap.getOrDefault(commandKey,CACHED_HELP_COMMANDS);

    }

}
