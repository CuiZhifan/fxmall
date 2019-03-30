package com.qianfeng;

import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.dao.IGoodsDAO;
import com.qianfeng.fxmall.goods.dao.Impl.GoodsDaoImpl;
import org.junit.Test;
import java.util.UUID;


public class TestDAO {

    @Test
    public void testinsert(){
        WxbGood wxbGood = new WxbGood();
        wxbGood.setGoodId(UUID.randomUUID().toString().replace("-","").substring(0,10));
        wxbGood.setGoodName("代码");
        wxbGood.setGoodPic("1.jpg");
        wxbGood.setGoodPic1("2.jpg");
        wxbGood.setGoodPic2("3.jpg");
        wxbGood.setPromoteDesc("掉一根头发月薪+1块");
        wxbGood.setSkuTitle("用生命敲代码");
        wxbGood.setSkuCost("生命还不够吗");
        wxbGood.setSkuPrice("升职加薪赢取白富美");
        wxbGood.setSkuPmoney("二手白富美");
        wxbGood.setTypeId(UUID.randomUUID().toString().replace("-","").substring(0,10));
        wxbGood.setState(0);
        java.sql.Timestamp time = new java.sql.Timestamp(System.currentTimeMillis());
        wxbGood.setCreateTime(time);
        wxbGood.setToped(0);
        wxbGood.setRecomed(0);
        IGoodsDAO Dao = new GoodsDaoImpl();
        try {
            Dao.insertGoods(wxbGood);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testDelete(){
        IGoodsDAO Dao = new GoodsDaoImpl();
        try {
            Dao.deleteGoods("44671132");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
