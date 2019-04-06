package com.qianfeng.fxmall.goods.service.Impl;

import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.mapper.GoodsMapper;
import com.qianfeng.fxmall.goods.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class GoodsServiceImpl implements IGoodsService {
//    @Autowired
//    private IGoodsDAO dao;
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<WxbGood> queryGoodsByPage(Integer page) throws Exception {
        List<WxbGood> list;
        if (page<1)page=1;
//        list = dao.queryGoodsByPage(page);
        list = goodsMapper.queryGoodsByPage(page,5);
        return list;
    }

    @Override
    public void insertGoods(WxbGood wxbGood) {
        goodsMapper.insertGoods(wxbGood);
    }

    @Override
    public WxbGood queryGoodsById(String goodId) {
        WxbGood wxbGood = null;
        wxbGood = goodsMapper.queryGoodsById(goodId);
        return wxbGood;
    }
}
