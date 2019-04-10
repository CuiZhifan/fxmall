package com.qianfeng.fxmall.User.service;

import com.qianfeng.fxmall.User.VO.UserInfoVO;
import com.qianfeng.fxmall.User.bean.WxbMemeber;

public interface IUserService {
    WxbMemeber login(UserInfoVO user) throws Exception;
}
