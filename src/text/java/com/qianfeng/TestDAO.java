package com.qianfeng;

import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.dao.IGoodsDAO;
import com.qianfeng.fxmall.goods.dao.Impl.GoodsDaoImpl;
import com.qianfeng.fxmall.goods.service.IGoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestDAO {

//    @Autowired
//    private IGoodsDAO dao;
    @Autowired
    private IGoodsService service;
    @Test
    public void testselect(){

        try {
            List<WxbGood> list = service.queryGoodsByPage(1);
            System.out.println("结果"+list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加
     */
    @Test
    public void testinsert(){
        WxbGood wxbGood = new WxbGood();
        wxbGood.setGoodId(UUID.randomUUID().toString().replace("-","").substring(0,10));
        wxbGood.setGoodName("Python代码");
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
        try {
            service.insertGoods(wxbGood);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除
     */
    @Test
    public void testDelete(){
        IGoodsDAO Dao = new GoodsDaoImpl();
        try {
            Dao.deleteGoods("44671132");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改
     */
    @Test
    public void testupdate(){
        WxbGood wxbGood = new WxbGood();
        wxbGood.setGoodId("pb1n3rya");
        wxbGood.setGoodName("代码");
        wxbGood.setGoodPic("1.jpg");
        wxbGood.setGoodPic1("2.jpg");
        wxbGood.setGoodPic2("3.jpg");
        wxbGood.setPromoteDesc("掉一根头发月薪+1块");
        wxbGood.setSkuTitle("用生命敲代码");
        wxbGood.setSkuCost("生命还不够吗");
        wxbGood.setSkuPrice("升职加薪赢取白富美");
        wxbGood.setSkuPmoney("二手白富美");
        wxbGood.setTypeId("0"+(new Random().nextInt(8)+1));
        wxbGood.setState(0);
        java.sql.Timestamp time = new java.sql.Timestamp(System.currentTimeMillis());
        wxbGood.setCreateTime(time);
        wxbGood.setToped(0);
        wxbGood.setRecomed(0);
        IGoodsDAO Dao = new GoodsDaoImpl();
        try {
            Dao.updateGoods(wxbGood);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectById(){
        WxbGood wxbGood = service.queryGoodsById("6298e76bee");
        System.out.println(wxbGood);
    }
}
