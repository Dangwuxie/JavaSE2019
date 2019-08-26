package com.cashierdesk.cmd.impl.order;

import com.cashierdesk.cmd.Subject;
import com.cashierdesk.cmd.annotation.CommandMate;
import com.cashierdesk.cmd.annotation.CustomerCommand;
import com.cashierdesk.cmd.impl.AbstractCommand;
import com.cashierdesk.common.OrderStatus;
import com.cashierdesk.entity.Goods;
import com.cashierdesk.entity.Order;
import com.cashierdesk.entity.OrderItem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 灵魂编程者
 * @Title: OrderPayCommand
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/8/21 14:10
 */

@CommandMate(
        name = "ZFDD",
        desc = "支付订单",
        group="订单信息"

)
@CustomerCommand
public class OrderPayCommand extends AbstractCommand {
    /*
    * 订单支付页面
    * */
    @Override
    public void execute(Subject subject) {
        System.out.println("请输入你要购买的货物id以及数量(逗号使用英文字符)：");
        System.out.println("id及数量用-隔开，多个货物之间逗号隔开，比如：3-4，2-2");
        //解析从输入端输入的字符串
        //如果不是指定格式就报错，重新选择
        String selectGoods = scanner.nextLine();
        String[] strings = selectGoods.split(",");
        //new一个Goods列表，存放当前所选购的goods的id以及数量，
        // new一个Goods对象就添加一个
        List<Goods> goodsList = new ArrayList<>();

        //写个for循环解析输入语句，添加商品goods对象
        for (String string:strings){
            //每次取出来的字符串都是这种：2-3
            String[] strings2 = string.split("-");
            //然后从数据库取得该商品对象goods，设置goods的购买总数buyNum
            Goods goods = this.goodsService.getGoods(Integer.parseInt(strings2[0]));
            goods.setBuyNum(Integer.parseInt(strings2[1]));
            //给商品订单添加商品信息
            goodsList.add(goods);
        }

        //此时已经设置好要当前这么一个订单的多个商品的信息
        //创建一个Order对象，订单的信息，账户id和姓名，
        // 创建时间、完成时间、实际金额，总金额，以及订单状态
        Order order = new Order();
        //由于订单的orderId不是自增的，所以必须设置一下,
        // 此处直接设置订单号为当前时间转换成String类型
        order.setId(String.valueOf(System.currentTimeMillis()));
        order.setAccount_id(subject.getAccount().getId());
        order.setAccount_name(subject.getAccount().getName());
        order.setOrder_status(OrderStatus.PAYING);
        order.setCreate_time(LocalDateTime.now());
        //还差个完成时间和订单总金额跟实际金额

        int totalMoney = 0;
        int actualAmount = 0;

        //下面就是取出goodslist中的每一个goods来计算总金额和实际支付金额
        for (Goods goods:goodsList){
            //这里我们要把goods里面的每一个购买商品的信息添加进入当前的订单中去
            OrderItem orderItem = new OrderItem();
            //注意，每个订单项的第一个字段的值是跟他的订单id是相同的
            orderItem.setOrderId(order.getId());

            orderItem.setGoodsId(goods.getId());
            orderItem.setGoodsName(goods.getName());
            orderItem.setGoodsIntroduce(goods.getIntroduce());
            orderItem.setGoodsNum(goods.getStock());
            orderItem.setGoodsUnit(goods.getUnit());
            orderItem.setGoodsPrice(goods.getPrice());
            orderItem.setGoodsDiscount(goods.getDiscount());

            //设置用户要购买的数量
            orderItem.setGoodsNum(goods.getBuyNum());

            //然后添加进入当前的订单
            order.getOrderItemList().add(orderItem);

            //每次添加一个商品goods以及数量之后计算一下金额
            //实际金额就是当前的商品总金额乘以折扣
            int tempMoney = orderItem.getGoodsPrice()*orderItem.getGoodsNum();
            totalMoney += tempMoney/100;
            actualAmount+= tempMoney*orderItem.getGoodsDiscount()/100;

        }
        //完后设置一下当前订单的金额
        order.setTotal_money(totalMoney);
        order.setActual_amount(actualAmount);

        /*
        *。。。这里貌似有问题
        *  原代码讲的是加入订单项中
        * */

        System.out.println(order);//这里要输出订单需要order重写一下toString方法
        System.out.println("以上为订单信息，请选择支付或者其他：输入zf代表支付成功：");
        String confirm = scanner.next();

        if ("zf".equals(confirm)){
            //此时代表支付订单，就提交订单到订单列表，就行了
            //首先完成当前订单的finish时间以及支付状态
            order.setFinish_time(LocalDateTime.now());
            order.setOrder_status(OrderStatus.OK);

            //下面就需要把这次创建的订单提交到数据库，
            boolean commitOrder = this.orderService.commitOrder(order);
            if (commitOrder){
                //提交成功
                /*
                * 提交成功后就需要把目前数据库中
                * 的goods表单中的购买的goods的数量更新
                * */
                for (Goods goods:goodsList){
                    //此时就是更新商品的数量了
                    boolean isUpdate =
                            this.goodsService.updateGoodsAfterPay(goods,goods.getBuyNum());
                }
            }

        }else {
            //此时代表提交不成功，
            System.out.println("你没有支付当前订单！");


        }

    }
}
