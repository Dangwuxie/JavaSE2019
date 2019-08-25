package com.cashierdesk.cmd.impl.goods;

import com.cashierdesk.cmd.Subject;
import com.cashierdesk.cmd.annotation.AdminCommand;
import com.cashierdesk.cmd.annotation.CommandMate;
import com.cashierdesk.cmd.annotation.CustomerCommand;
import com.cashierdesk.cmd.impl.AbstractCommand;
import com.cashierdesk.entity.Goods;

import java.util.List;

/**
 * @author 灵魂编程者
 * @Title: GoodsBrowseCommand
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/8/21 14:09
 */

@CommandMate(
        name = "LLSP",
        desc = "浏览商品",
        group="商品信息"

)
@AdminCommand
@CustomerCommand
public class GoodsBrowseCommand extends AbstractCommand {
    //商品浏览
    @Override
    public void execute(Subject subject) {
        System.out.println("浏览商品：");
        //查询所有商品
        List<Goods> goodsList = this.goodsService.quarryAllgoods();
<<<<<<< HEAD

        if (goodsList.isEmpty()){
            System.out.println("商品为空");
        }else{
            //否则就遍历它
            for (Goods goods:goodsList) {
                System.out.println(goods);
            }

        }

=======
>>>>>>> eeaddf556a5d8af909586f56926d14dff007e299
    }
}
