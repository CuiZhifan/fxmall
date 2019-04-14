package com.qianfeng.fxmall.goods.VO;

import org.springframework.web.multipart.MultipartFile;

public class AddPicsVO {
    MultipartFile uploadGood;
    MultipartFile uploadGood1;
    MultipartFile uploadGood2;

    public MultipartFile getUploadGood() {
        return uploadGood;
    }

    public void setUploadGood(MultipartFile uploadGood) {
        this.uploadGood = uploadGood;
    }

    public MultipartFile getUploadGood1() {
        return uploadGood1;
    }

    public void setUploadGood1(MultipartFile uploadGood1) {
        this.uploadGood1 = uploadGood1;
    }

    public MultipartFile getUploadGood2() {
        return uploadGood2;
    }

    public void setUploadGood2(MultipartFile uploadGood2) {
        this.uploadGood2 = uploadGood2;
    }
}
