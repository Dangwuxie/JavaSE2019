package com.cashierdesk.service;

import com.cashierdesk.dao.GoodsDao;
import com.cashierdesk.entity.Goods;

import java.util.List;

/**
 * @author 灵魂编程者
 * @Title: GoodsService
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/8/24 23:08
 */
public class GoodsService {

    public GoodsDao goodsDao;

    public GoodsService() {
        this.goodsDao = new GoodsDao();
    }

    public boolean updateGoodsAfterPay(Goods goods,int BuyNum){
        return this.goodsDao.updateGoodsAfterPay(goods,BuyNum);
    }

    public List<Goods> quarryAllgoods(){
        //这里边，调用goodsDao查询数据库，查询goods信息，就是list集合
        return this.goodsDao.quarryAllgoods();
    }


    public boolean putAwayService(Goods goods){
        //插入这个goods数据库中的goods表
        return this.goodsDao.putAwayService(goods);

    }

    public Goods getGoods(int goodsId){
        return goodsDao.getGoodsById(goodsId);
    }

    public boolean modifyGoods(Goods goods){
        return goodsDao.modifyGoods(goods);
    }
}
