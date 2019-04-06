package com.qianfeng.fxmall.goods.controller;

import com.qianfeng.fxmall.commons.Servlet.BaseServlet;
import com.qianfeng.fxmall.commons.Utils.ApplicationContextUtils;
import com.qianfeng.fxmall.commons.info.SystemConstantsUtils;
import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.service.IGoodsService;
import com.qianfeng.fxmall.goods.service.Impl.GoodsServiceImpl;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class GoodsServlet extends BaseServlet {
//    ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    private IGoodsService service ;

    public void selectGoods(HttpServletRequest req, HttpServletResponse resp){
        service = ApplicationContextUtils.getApplicationContext().getBean(GoodsServiceImpl.class);
        String pageStr = req.getParameter("page");
        List<WxbGood> goods = null;
        try {
            goods = service.queryGoodsByPage(Integer.parseInt(pageStr == null ? "0" : pageStr));
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("goodsList",goods);
        try {
            req.getRequestDispatcher("goods/goods_list.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addGoods(HttpServletRequest req, HttpServletResponse resp){
        try {
            if (ServletFileUpload.isMultipartContent(req)) {
                ServletFileUpload upload = new ServletFileUpload();
                upload.setFileSizeMax(5 * 1024 * 1024);
                FileItemIterator itr = upload.getItemIterator(req);
                WxbGood wxbGood = new WxbGood();
                wxbGood.setGoodId(UUID.randomUUID().toString().replace("-","").substring(0,10));
                wxbGood.setTypeId(UUID.randomUUID().toString().replace("-","").substring(0,10));
                wxbGood.setState(0);
                java.sql.Timestamp time = new java.sql.Timestamp(System.currentTimeMillis());
                wxbGood.setCreateTime(time);
                wxbGood.setToped(0);
                wxbGood.setRecomed(0);
                int picNum = 0;
                while (itr.hasNext()) {
                    FileItemStream item = itr.next();
                    if (item.isFormField()) {
                        String value = Streams.asString(item.openStream(), "UTF-8");
                        switch (item.getFieldName()) {
                            case "good_name":{
                                wxbGood.setGoodName(value);
                            }break;
                            case "promote_desc":{
                                wxbGood.setPromoteDesc(value);
                            } break;
                            case "sku_title":{
                                wxbGood.setSkuTitle(value);
                            } break;
                            case "sku_cost":{
                                wxbGood.setSkuCost(value);
                            } break;
                            case "sku_price":{
                                wxbGood.setSkuPrice(value);
                            } break;
                            case "sku_pmoney":{
                                wxbGood.setSkuPmoney(value);
                            } break;
                        }
                    }else {
                        // 获得文件名，进行处理
                        String filename = item.getName();
                        String fileName = "/0v0.png";
                        if(filename!=null&&filename.lastIndexOf(".")>0){
                            fileName = UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf("."));
                        }
                        switch (picNum){
                            case 0:{
                                wxbGood.setGoodPic(fileName);
                                picNum++;
                            }break;
                            case 1:{
                                wxbGood.setGoodPic1(fileName);
                                picNum++;
                            }break;
                            case 2:{
                                wxbGood.setGoodPic2(fileName);
                                picNum++;
                            }break;
                        }
                        filename = SystemConstantsUtils.PicPath.UPLOAD_PATH + fileName;
                        if(!"/".equals(filename)){
                            FileOutputStream out = new FileOutputStream(filename);
                            Streams.copy(item.openStream(), out, true);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectGoodById(HttpServletRequest req, HttpServletResponse resp){
        String id = req.getParameter("good_id");
        WxbGood goods = service.queryGoodsById(id);
        req.setAttribute("goods",goods);
        try {
            req.getRequestDispatcher("goods/goods_add.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
