package com.qianfeng.fxmall.goodssku.service.Impl;

import com.qianfeng.fxmall.goodssku.bean.WxbGoodSku;
import com.qianfeng.fxmall.goodssku.mapper.GoodsSkuMapper;
import com.qianfeng.fxmall.goodssku.service.IGoodsSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GoodsSkuServiceImpl implements IGoodsSkuService {
    @Autowired
    private GoodsSkuMapper goodsSkuMapper;
    @Override
    public void insertGoodsSku(WxbGoodSku wxbGoodSku) {
        goodsSkuMapper.insertGoodsSku(wxbGoodSku);
    }
}
