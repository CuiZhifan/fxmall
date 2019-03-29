package com.qianfeng.fxmall.commons.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisSessionFactoryUtils {
    private static SqlSessionFactory sessionFactory;
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();

    static {
        initSessionFactory();
    }

    private static void initSessionFactory(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis.cfg.xml");
            sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory(){
        if (sessionFactory == null) {
            initSessionFactory();
        }
        return sessionFactory;
    }

    public static SqlSession getSession(){
        SqlSession session = threadLocal.get();
        if (session == null){
            session = getSqlSessionFactory().openSession();
            threadLocal.set(session);
        }
        return  session;
    }
}
