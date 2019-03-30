package com.qianfeng.fxmall.goods.dao.Impl;

import com.qianfeng.fxmall.commons.info.SystemConstantsUtils;
import com.qianfeng.fxmall.commons.mybatis.MyBatisSessionFactoryUtils;
import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.dao.IGoodsDAO;
import com.qianfeng.fxmall.goods.mapper.GoodsMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class GoodsDaoImpl implements IGoodsDAO {

    @Override
    public List<WxbGood> queryGoodsByPage(Integer page) throws Exception{
        GoodsMapper goodsMapper = MyBatisSessionFactoryUtils.getSession().getMapper(GoodsMapper.class);
        List<WxbGood> goods = goodsMapper.queryGoodsByPage(page, SystemConstantsUtils.Page.PAGE_SIZE);
        return goods;
    }

    @Override
    public void insertGoods(WxbGood wxbGood) throws Exception {
        SqlSession session = MyBatisSessionFactoryUtils.getSession();
        GoodsMapper goodsMapper = session.getMapper(GoodsMapper.class);
        goodsMapper.insertGoods(wxbGood);
        session.commit();
    }

    @Override
    public void deleteGoods(String goodId) throws Exception {
        SqlSession session = MyBatisSessionFactoryUtils.getSession();
        GoodsMapper goodsMapper = session.getMapper(GoodsMapper.class);
        goodsMapper.deleteGoods(goodId);
        session.commit();
    }
}
