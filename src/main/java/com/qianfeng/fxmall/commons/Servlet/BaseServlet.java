package com.qianfeng.fxmall.commons.Servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

/**
 * 自定义servlet的父类
 * Servlet implementation class BaseServlet
 */

public class BaseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public BaseServlet() {
        super();
    }

    private Logger logger = Logger.getLogger(BaseServlet.class);

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String m = request.getParameter("m");
//		System.out.println("调用方法"+m);
        logger.info("执行了方法："+m);
        try {
            Method method =
                    getClass().getMethod(m, HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(this, request,response);
//			logger.info(this.getClass().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
