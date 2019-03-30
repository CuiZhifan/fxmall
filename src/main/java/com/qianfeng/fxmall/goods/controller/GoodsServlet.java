package com.qianfeng.fxmall.goods.controller;

import com.qianfeng.fxmall.commons.Servlet.BaseServlet;
import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.service.IGoodsService;
import com.qianfeng.fxmall.goods.service.Impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GoodsServlet extends BaseServlet {

    IGoodsService service = new GoodsServiceImpl();

    public void selectGoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageStr = req.getParameter("page");
        List<WxbGood> goods = null;
        try {
            goods = service.queryGoodsByPage(Integer.parseInt(pageStr == null ? "0" : pageStr));
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("goodsList",goods);
        req.getRequestDispatcher("goods/goods_list.jsp").forward(req,resp);
    }

    public void addGoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
