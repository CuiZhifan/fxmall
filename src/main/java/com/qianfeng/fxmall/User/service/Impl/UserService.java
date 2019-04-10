package com.qianfeng.fxmall.User.service.Impl;

import com.qianfeng.fxmall.User.VO.UserInfoVO;
import com.qianfeng.fxmall.User.bean.WxbMemeber;
import com.qianfeng.fxmall.User.mapper.UserMapper;
import com.qianfeng.fxmall.User.service.IUserService;
import com.qianfeng.fxmall.commons.Utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public WxbMemeber login(UserInfoVO user) throws Exception {
        if(null == user.getUsername()){
            throw new NullPointerException("用户名为空");
        }
        WxbMemeber wxbMemeber = userMapper.checkedMemeber(user.getUsername());
        if(wxbMemeber==null){
            throw new NullPointerException("用户名错误");
        }
        String password = MD5Utils.md5(user.getPassword(),wxbMemeber.getMemeberId() + wxbMemeber.getName());
        if(!password.equals(wxbMemeber.getPassword())){
            throw new Exception("密码错误");
        }
        return wxbMemeber;
    }
}
