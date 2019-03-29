package com.qianfeng.fxmall.goods.service.Impl;

import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.dao.IGoodsDAO;
import com.qianfeng.fxmall.goods.dao.Impl.GoodsDaoImpl;
import com.qianfeng.fxmall.goods.service.IGoodsService;

import java.util.List;

public class GoodsServiceImpl implements IGoodsService {

    IGoodsDAO dao = new GoodsDaoImpl();

    @Override
    public List<WxbGood> queryGoodsByPage(Integer page) {
        List<WxbGood> list = null;
        if (page<1)page=1;
        try {
            list = dao.queryGoodsByPage(page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void insertGoods(WxbGood wxbGood) {

    }
}
