package com.qianfeng.fxmall.commons.Spring;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LogProxy {
    Logger logger = Logger.getLogger(LogProxy.class);
    @Around("execution(public * com.qianfeng.fxmall.*.service.Impl.*.*(..))")
    public Object logging(ProceedingJoinPoint joinPoint){
        logger.info("---------------------------------------------");
        try {
            String kind = joinPoint.getKind();
            Object[] args = joinPoint.getArgs();
            StringBuilder stringBuilder = new StringBuilder();
            for(Object o:args){
                stringBuilder.append(o.toString());
            }
            logger.info("连接点类型"+kind+": 值"+stringBuilder.toString());
            Object proceed = joinPoint.proceed();
            logger.info("返回值："+proceed);
            logger.info("---------------------------------------------");
            return proceed;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            logger.warn(throwable.getMessage());
            logger.info("---------------------------------------------");
        }
        return null;
    }
}
