package com.qianfeng.fxmall.goods.dao.Impl;

import com.qianfeng.fxmall.commons.info.SystemConstantsUtils;
import com.qianfeng.fxmall.commons.mybatis.MyBatisSessionFactoryUtils;
import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.dao.IGoodsDAO;
import com.qianfeng.fxmall.goods.mapper.GoodsMapper;

import java.util.List;

public class GoodsDaoImpl implements IGoodsDAO {

    static GoodsMapper goodsMapper = MyBatisSessionFactoryUtils.getSession().getMapper(GoodsMapper.class);

    @Override
    public List<WxbGood> queryGoodsByPage(Integer page) throws Exception{
        List<WxbGood> goods = goodsMapper.queryGoodsByPage(page, SystemConstantsUtils.Page.PAGE_SIZE);
        return goods;
    }

    @Override
    public void insertGoods(WxbGood wxbGood) throws Exception {
        goodsMapper.insertGoods(wxbGood);
    }
}
