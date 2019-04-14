package com.qianfeng.fxmall.goods.controller;
import com.qianfeng.fxmall.goods.VO.AddPicsVO;
import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.service.IGoodsService;
import com.qianfeng.fxmall.goodssku.bean.WxbGoodSku;
import com.qianfeng.fxmall.goodssku.service.IGoodsSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/Goods")
public class GoodsController {
//    private IGoodsService service = (IGoodsService) ApplicationContextUtils.getApplicationContext().getBean("goodsServiceImpl");
//    private IGoodsSkuService skuService = (IGoodsSkuService) ApplicationContextUtils.getApplicationContext().getBean("goodsSkuServiceImpl");

    @Autowired
    private IGoodsService service;
    @Autowired
    private IGoodsSkuService skuService;

    @RequestMapping("/GoodsList")
    public String selectGoods(Integer page, Model model){
        List<WxbGood> goods = null;
        try {
            goods = service.queryGoodsByPage(page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("goodsList",goods);
        return "/goods/goods_list.jsp";
    }

    @RequestMapping("/GoodsInfo")
    public String selectGoodById(String good_id,Model model){
        WxbGood goods = service.queryGoodsById(good_id);
        model.addAttribute("goods",goods);
        List<WxbGoodSku> list = skuService.selectByGoodsId(good_id);
        model.addAttribute("goodsskus",list);
        model.addAttribute("size",list.size());
        return "/goods/goods_add.jsp";
    }

    @RequestMapping("/GoodsAdd")
    public String addGoods(WxbGood wxbGood,AddPicsVO pics,String sku_str){
        List<WxbGoodSku> list = skuService.StringToObj(sku_str);
        //随机生成ID
        wxbGood.setGoodId(UUID.randomUUID().toString().substring(0,10).replace("-",""));
        //上传图片，并将地址存入对象
        try {
            wxbGood.setGoodPic(service.uploadFile(pics.getUploadGood()));
            wxbGood.setGoodPic1(service.uploadFile(pics.getUploadGood1()));
            wxbGood.setGoodPic2(service.uploadFile(pics.getUploadGood2()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //生成当前时间
        wxbGood.setCreateTime(new java.sql.Timestamp(System.currentTimeMillis()));
        //将对象添加到数据库
        service.insertGoods(wxbGood);
        list.forEach((d)->{
            d.setGoodId(wxbGood.getGoodId());
            d.setSkuId(UUID.randomUUID().toString().substring(0,10).replace("-",""));
            skuService.insertGoodsSku(d);
        });
        //返回goods列表
        return "redirect:/Goods/GoodsList";
    }
}
