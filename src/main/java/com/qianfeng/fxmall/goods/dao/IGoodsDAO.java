package com.qianfeng.fxmall.goods.dao;

import com.qianfeng.fxmall.goods.bean.WxbGood;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 删除
     * @param goodId    商品Id
     */
    void deleteGoods(@Param("goodId") String goodId) throws Exception;

    /**
     * 更新
     * @param wxbGood   更新的商品
     */
    void updateGoods(WxbGood wxbGood) throws Exception;
}
