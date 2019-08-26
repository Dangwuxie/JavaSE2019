package com.cashierdesk.cmd.impl.goods;

import com.cashierdesk.cmd.Subject;
import com.cashierdesk.cmd.annotation.AdminCommand;
import com.cashierdesk.cmd.annotation.CommandMate;
import com.cashierdesk.cmd.impl.AbstractCommand;
import com.cashierdesk.entity.Goods;

/**
 * @author 灵魂编程者
 * @Title: GoodsUpdateCommand
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/8/21 14:10
 */
//更新

@CommandMate(
        name = "GXSP",
        desc = "更新商品",
        group="商品信息"

)
@AdminCommand
public class GoodsUpdateCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {

        System.out.println("更新商品");
        System.out.println("请输入想要更新商品的编号");
        int goodsId = scanner.nextInt();
        Goods goods = this.goodsService.getGoods(goodsId);
        if (goods == null){
            System.out.println("输入商品编号有误，请查看商品列表后重新输入：");
            return;//结束本次函数
        }else{
            //此时就是查询到了对应编号的商品了
            //先打印一下
            //确认更新，依次输入将要修改的商品的每一个信息，六个信息
            System.out.println("要更新的商品信息如下：");
            System.out.println(goods);
            printlnInfo("要更新的商品简介");
            String introduce = scanner.nextLine();
            printlnInfo("要更新的商品库存");
            int stock = scanner.nextInt();
            printlnInfo("要更新的商品单位(个、包、箱、桶、瓶、千克)");
            String unit = scanner.nextLine();
            printlnInfo("要更新的商品价格(元),保留小数点后两位");
            int price = new Double(100 * scanner.nextDouble()).intValue();
            printlnInfo("要更新的商品折扣(90,九折；75，75折)");
            int discount = scanner.nextInt();

            System.out.println("请确认是否更新：('y'表示是，'n'表示否)");
            String ensure = scanner.nextLine().trim().toUpperCase();
            if ("y".equals(ensure)){
                goods.setIntroduce(introduce);
                goods.setStock(stock);
                goods.setUnit(unit);
                goods.setPrice(price);
                goods.setDiscount(discount);

                //把这个goods设置好之后，传到dao层，然后更新数据库
                boolean effect = this.goodsService.modifyGoods(goods);
                if (effect){
                    System.out.println("恭喜你更新商品成功！");
                }else {
                    System.out.println("不好意思，商品更新失败。。。。");
                }
            }else {
                System.out.println("你选择了不更新此商品");
            }

        }
    }
}
