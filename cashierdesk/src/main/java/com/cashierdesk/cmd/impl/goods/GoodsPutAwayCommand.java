package com.cashierdesk.cmd.impl.goods;

import com.cashierdesk.cmd.Subject;
import com.cashierdesk.cmd.annotation.AdminCommand;
import com.cashierdesk.cmd.annotation.CommandMate;
import com.cashierdesk.cmd.impl.AbstractCommand;

/**
 * @author 灵魂编程者
 * @Title: GoodsPutAwayCommand
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/8/21 14:09
 */
//商品上架

@CommandMate(
        name = "SJSP",
        desc = "上架商品",
        group="商品信息"

)
@AdminCommand
public class GoodsPutAwayCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {

    }
}
