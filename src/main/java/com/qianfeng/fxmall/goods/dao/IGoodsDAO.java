package com.qianfeng.fxmall.goods.dao;

import com.qianfeng.fxmall.goods.bean.WxbGood;

import java.util.List;

public interface IGoodsDAO {

    /**
     * 分页查找
     * @param page  页数
     * @return  查找到的集合
     */
    List<WxbGood> queryGoodsByPage(Integer page) throws Exception;

    /**
     * 添加
     * @param wxbGood 需要添加的商品类
     */
    void insertGoods(WxbGood wxbGood) throws Exception;
}
