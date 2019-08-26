package com.cashierdesk.cmd.impl.goods;

import com.cashierdesk.cmd.Subject;
import com.cashierdesk.cmd.annotation.AdminCommand;
import com.cashierdesk.cmd.annotation.CommandMate;
import com.cashierdesk.cmd.impl.AbstractCommand;
import com.cashierdesk.entity.Goods;

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
        //商品上架
        System.out.println("上架商品");
        this.printlnInfo("商品名称");
        String name = scanner.nextLine();
        this.printlnInfo("商品介绍");
        String introduce = scanner.nextLine();
        this.printlnInfo("商品库存");
        int stock = scanner.nextInt();
        this.printlnInfo("商品单位(个、包、箱、桶、瓶、千克)");
        String unit = scanner.next();
        this.printlnInfo("商品价格(元),保留小数点后两位");
        int price = new Double(100 * scanner.nextDouble()).intValue();
        this.printlnInfo("商品折扣(90,九折；75，75折)");
        int discount = scanner.nextInt();
        System.out.println("----------------------------------------");
        System.out.println(discount);
        System.out.println("----------------------------------------");
        //new一个Goods类，然后设置这一项goods的属性,
        //此时定义的goods不能加final属性，因为可能要修改
        Goods goods = new Goods();
        goods.setName(name);
        goods.setIntroduce(introduce);
        goods.setStock(stock);
        goods.setUnit(unit);
        goods.setPrice(price);
        goods.setDiscount(discount);

        boolean effect = this.goodsService.putAwayService(goods);
        if (effect){
            System.out.println("上架成功");
        }else {
            System.out.println("货架满了，卖出去点再上架新产品吧！");
        }
    }
}
