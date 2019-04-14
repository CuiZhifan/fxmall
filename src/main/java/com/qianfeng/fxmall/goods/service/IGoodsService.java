package com.qianfeng.fxmall.goods.service;

import com.qianfeng.fxmall.goods.bean.WxbGood;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IGoodsService {
    List<WxbGood> queryGoodsByPage(Integer page) throws Exception;

    void insertGoods(WxbGood wxbGood);

    WxbGood queryGoodsById(String goodId);

    String uploadFile(MultipartFile file) throws IOException;
}
