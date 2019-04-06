package com.qianfeng.fxmall.goods.dao.Impl;

import com.qianfeng.fxmall.commons.mybatis.MyBatisSessionFactoryUtils;
import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.dao.IGoodsDAO;
import com.qianfeng.fxmall.goods.mapper.GoodsMapper;
import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

public class GoodsProxy implements InvocationHandler {
    private IGoodsDAO dao;

    public GoodsProxy(IGoodsDAO dao) {
        this.dao = dao;
    }

    private  SqlSession session;
    private GoodsMapper goodsMapper;

    private void Before() throws Exception {
        session = MyBatisSessionFactoryUtils.getSession();
        goodsMapper = session.getMapper(GoodsMapper.class);
    }

    private void After() throws Exception {
        session.commit();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Before();

        After();
        return null;
    }
}
