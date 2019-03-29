package com.qianfeng.fxmall.goods.service.Impl;

import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.dao.IGoodsDAO;
import com.qianfeng.fxmall.goods.dao.Impl.GoodsDaoImpl;
import com.qianfeng.fxmall.goods.service.IGoodsService;

import java.util.List;

public class GoodsServiceImpl implements IGoodsService {

    private IGoodsDAO dao = new GoodsDaoImpl();

    @Override
    public List<WxbGood> queryGoodsByPage(Integer page) throws Exception {
        List<WxbGood> list;
        if (page<1)page=1;
        list = dao.queryGoodsByPage(page);
        return list;
    }

    @Override
    public void insertGoods(WxbGood wxbGood) {

    }
}
