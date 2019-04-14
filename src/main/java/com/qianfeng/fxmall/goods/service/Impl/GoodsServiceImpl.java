package com.qianfeng.fxmall.goods.service.Impl;

import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.mapper.GoodsMapper;
import com.qianfeng.fxmall.goods.service.IGoodsService;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
@Component
public class GoodsServiceImpl implements IGoodsService {
//    @Autowired
//    private IGoodsDAO dao;
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<WxbGood> queryGoodsByPage(Integer page) throws Exception {
        List<WxbGood> list;
        if (page==null||page<1)page=1;
//        list = dao.queryGoodsByPage(page);
        page = (page-1)*5;
        list = goodsMapper.queryGoodsByPage(page,5);
        list.forEach((d)-> System.out.println(d));
        return list;
    }

    @Override
    public void insertGoods(WxbGood wxbGood) {
        goodsMapper.insertGoods(wxbGood);
    }

    @Override
    public WxbGood queryGoodsById(String goodId) {
        WxbGood wxbGood = null;
        wxbGood = goodsMapper.queryGoodsById(goodId);
        return wxbGood;
    }

    @Override
    public String uploadFile(MultipartFile uploadFile) throws IOException {
        String filename = uploadFile.getOriginalFilename().substring(uploadFile.getOriginalFilename().lastIndexOf("."));
        long timeMillis = System.currentTimeMillis();
        filename = timeMillis+"Pic"+filename;
        FileOutputStream fileInputStream = null;
        FTPClient ftp = new FTPClient();
        //连接FTP服务器，默认端口是21
        ftp.connect("192.168.53.23",21);
        //匿名用户必须使用anonymous登录，密码是邮箱
        boolean login = ftp.login("anonymous", "243975576@qq.com");
        int replyCode = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(replyCode)) {
            System.out.println("获取响应失败");
            return null;
        }
        //设置接收文件类型为二进制文件
        ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
        //服务器上创建images文件夹
        ftp.makeDirectory("images");
        //切换ftp默认文件夹
        ftp.changeWorkingDirectory("images");
        //获取内存文件
        InputStream inputStream = uploadFile.getInputStream();
        //将用户上传的图片上传到ftp服务器上
        ftp.storeFile(filename, inputStream);
        //退出登录
        ftp.logout();
        return "http://localhost/images/"+filename;
    }

}
