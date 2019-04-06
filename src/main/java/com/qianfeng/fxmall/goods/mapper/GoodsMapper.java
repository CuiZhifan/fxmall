package com.qianfeng.fxmall.goods.mapper;

import com.qianfeng.fxmall.goods.bean.WxbGood;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface GoodsMapper {
    /**
     * 分页查找
     * @param index 当前页数
     * @param size 每页数量
     * @return 查询结果集合
     */
    List<WxbGood> queryGoodsByPage(@Param("index") Integer index,@Param("size") Integer size);

    /**
     * 添加商品
     * @param wxbGood 添加的对象
     */
    void insertGoods(@Param("wxbGood") WxbGood wxbGood);

    /**
     * 删除商品
     * @param goodId 商品对应的ID
     */
    void deleteGoods(@Param("goodId") String goodId);

    /**
     * 更新商品
     * @param wxbGood   更新对象
     */
    void updateGoods(WxbGood wxbGood);

    /**
     * 根据Id查询商品
     * @param goodId 商品Id
     */
    WxbGood queryGoodsById(@Param("goodId") String goodId);
}
