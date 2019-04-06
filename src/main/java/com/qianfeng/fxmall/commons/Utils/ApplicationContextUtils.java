package com.qianfeng.fxmall.commons.Utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextUtils {
    private static ApplicationContext applicationContext;
    public static void init(){
        applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
