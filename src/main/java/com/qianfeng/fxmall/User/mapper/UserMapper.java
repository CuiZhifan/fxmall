package com.qianfeng.fxmall.User.mapper;

import com.qianfeng.fxmall.User.bean.WxbMemeber;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    WxbMemeber checkedMemeber(@Param("account") String account);
}
