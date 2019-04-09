package com.qianfeng.fxmall.goodssku.mapper;

import com.qianfeng.fxmall.goodssku.bean.WxbGoodSku;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsSkuMapper {
    void insertGoodsSku(WxbGoodSku wxbGoodSku);

    List<WxbGoodSku> selectByGoodsId(@Param("goodId") String goodId);
}
