package com.qianfeng.fxmall.goodssku.mapper;

import com.qianfeng.fxmall.goodssku.bean.WxbGoodSku;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsSkuMapper {
    public void insertGoodsSku(WxbGoodSku wxbGoodSku);
}
