package com.qianfeng;

import com.qianfeng.fxmall.User.VO.UserInfoVO;
import com.qianfeng.fxmall.User.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestUser {

    @Autowired
    private IUserService service;

    @Test
    public void testLogin(){
        UserInfoVO userInfoVO = new UserInfoVO();
        userInfoVO.setUsername("jack520009");
        userInfoVO.setPassword("1234");
        try {
            service.login(userInfoVO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
