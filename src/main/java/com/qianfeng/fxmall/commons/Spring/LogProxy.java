package com.qianfeng.fxmall.commons.Spring;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LogProxy {
    Logger logger = Logger.getLogger(LogProxy.class);
    @Around("execution(public * com.qianfeng.fxmall.*.service.Impl.*.*(..))")
    public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("----------------------执行方法-----------------------");
        try {
            String kind = joinPoint.getKind();
            Object[] args = joinPoint.getArgs();
            StringBuilder stringBuilder = new StringBuilder();
            for(Object o:args){
                if(o!=null){
                    stringBuilder.append(o.toString());
                }
            }
            logger.info("连接点类型"+kind+": 值"+stringBuilder.toString());
            Object proceed = joinPoint.proceed();
            logger.info("返回值："+proceed);
            logger.info("----------------------执行完毕-----------------------");
            return proceed;
        } catch (Throwable throwable) {
//            throwable.printStackTrace();
            logger.warn(throwable.getMessage());
            logger.info("----------------------异常信息-----------------------");
            throw throwable;
        }
    }
}
