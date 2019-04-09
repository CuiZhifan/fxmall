package com.qianfeng.fxmall.goodssku.service;

import com.qianfeng.fxmall.goodssku.bean.WxbGoodSku;

import java.util.List;

public interface IGoodsSkuService {
    void insertGoodsSku(WxbGoodSku wxbGoodSku);

    List<WxbGoodSku> selectByGoodsId(String goodId);
}
