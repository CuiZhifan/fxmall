package com.qianfeng.fxmall.commons.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("*.jsp")
public class JSPBasePathFilter implements Filter{

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) arg0;
        String path = req.getContextPath();
        String basePath = req.getScheme()+"://"+req.getServerName()+
                ":"+req.getServerPort()+path+"/";
        req.setAttribute("basePath", basePath);
        arg2.doFilter(arg0,arg1);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

}
