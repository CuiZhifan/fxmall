package com.qianfeng.fxmall.goods.mapper;

import com.qianfeng.fxmall.goods.bean.WxbGood;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {
    List<WxbGood> queryGoodsByPage(@Param("index") Integer index,@Param("size") Integer size);

    void insertGoods(@Param("wxbGood") WxbGood wxbGood);
}
