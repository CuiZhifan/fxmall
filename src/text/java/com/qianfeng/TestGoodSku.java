package com.qianfeng;

import com.qianfeng.fxmall.goodssku.bean.WxbGoodSku;
import com.qianfeng.fxmall.goodssku.service.IGoodsSkuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestGoodSku {
    @Autowired
    private IGoodsSkuService service;

    @Test
    public void testInsert(){
        WxbGoodSku wxbGoodSku = new WxbGoodSku();
        wxbGoodSku.setSkuId(UUID.randomUUID().toString().substring(0,10).replace("-",""));
        wxbGoodSku.setSkuName("测试");
        wxbGoodSku.setSkuCost("12");
        wxbGoodSku.setSkuPrice("11");
        wxbGoodSku.setSkuPmoney("10");
        wxbGoodSku.setGoodId("1");
//        wxbGoodSku.setOrderNo(1L);
        wxbGoodSku.setServiceMoney("6");
        service.insertGoodsSku(wxbGoodSku);
        System.out.println(wxbGoodSku);
    }

    @Test
    public void testSelectByGoodId(){
        List<WxbGoodSku> list = service.selectByGoodsId("73515420");
        list.forEach((d)-> System.out.println(d));
    }

    @Test
    public void testStringToObj(){
        List<WxbGoodSku> list = service.StringToObj("newid|1|1|1|1|1|$newid|2|2|2|2|2|$newid|3|3|3|3|3|$");
        System.out.println(list);
    }
}
