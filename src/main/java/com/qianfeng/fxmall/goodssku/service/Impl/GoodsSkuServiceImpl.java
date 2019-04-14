package com.qianfeng.fxmall.goodssku.service.Impl;

import com.qianfeng.fxmall.goodssku.bean.WxbGoodSku;
import com.qianfeng.fxmall.goodssku.mapper.GoodsSkuMapper;
import com.qianfeng.fxmall.goodssku.service.IGoodsSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GoodsSkuServiceImpl implements IGoodsSkuService {
    @Autowired
    private GoodsSkuMapper goodsSkuMapper;
    @Override
    public void insertGoodsSku(WxbGoodSku wxbGoodSku) {
        goodsSkuMapper.insertGoodsSku(wxbGoodSku);
    }

    @Override
    public List<WxbGoodSku> selectByGoodsId(String goodId) {
        List<WxbGoodSku> list = goodsSkuMapper.selectByGoodsId(goodId);
        return list;
    }

    @Override
    public List<WxbGoodSku> StringToObj(String sku_str) {
        List<WxbGoodSku> list = new ArrayList<>();
        //newid|1|1|1|1|1|$newid|2|2|2|2|2|$newid|3|3|3|3|3|$
        sku_str = sku_str.substring(0,sku_str.length()-1).replace("newid","");
        String[] skus= sku_str.split("\\$");
        //|1|1|1|1|1|
        //|2|2|2|2|2|
        //|3|3|3|3|3|
        for(String s:skus){
            int length = s.length();
            String[] sku = s.substring(1,length-1).split("\\|");
            WxbGoodSku wxbGoodSku = new WxbGoodSku();
            wxbGoodSku.setSkuName(sku[0]);
            wxbGoodSku.setSkuCost(sku[1]);
            wxbGoodSku.setSkuPrice(sku[2]);
            wxbGoodSku.setSkuPmoney(sku[3]);
            wxbGoodSku.setServiceMoney(sku[4]);
            list.add(wxbGoodSku);
        }
        return list;
    }
}
