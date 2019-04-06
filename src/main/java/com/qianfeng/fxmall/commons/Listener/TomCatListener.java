package com.qianfeng.fxmall.commons.Listener;

import com.qianfeng.fxmall.commons.Utils.ApplicationContextUtils;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TomCatListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ApplicationContextUtils.init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
