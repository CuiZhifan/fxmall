package com.qianfeng.fxmall.User.Controller;

import com.qianfeng.fxmall.User.VO.JsonResultVO;
import com.qianfeng.fxmall.User.VO.UserInfoVO;
import com.qianfeng.fxmall.User.bean.WxbMemeber;
import com.qianfeng.fxmall.User.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService service;

    @ResponseBody
    @RequestMapping("/login")
    public JsonResultVO login(UserInfoVO userInfoVO, HttpSession session){
        WxbMemeber memeber;
        JsonResultVO jsonResultVO = new JsonResultVO();
        try {
            memeber = service.login(userInfoVO);
            session.setAttribute("login",memeber);
            jsonResultVO.setCode("true");
            jsonResultVO.setMsg("干得漂亮");
        } catch (Exception e) {
            e.printStackTrace();
            jsonResultVO.setCode("false");
            jsonResultVO.setMsg(e.getMessage());
        }
        return jsonResultVO;
    }

}
