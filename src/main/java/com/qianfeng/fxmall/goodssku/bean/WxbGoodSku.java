package com.qianfeng.fxmall.goodssku.bean;


public class WxbGoodSku {

  private String skuId;
  private String skuName;
  private String skuCost;
  private String skuPrice;
  private String skuPmoney;
  private String goodId;
  private long orderNo;
  private String serviceMoney;


  public String getSkuId() {
    return skuId;
  }

  public void setSkuId(String skuId) {
    this.skuId = skuId;
  }


  public String getSkuName() {
    return skuName;
  }

  public void setSkuName(String skuName) {
    this.skuName = skuName;
  }


  public String getSkuCost() {
    return skuCost;
  }

  public void setSkuCost(String skuCost) {
    this.skuCost = skuCost;
  }


  public String getSkuPrice() {
    return skuPrice;
  }

  public void setSkuPrice(String skuPrice) {
    this.skuPrice = skuPrice;
  }


  public String getSkuPmoney() {
    return skuPmoney;
  }

  public void setSkuPmoney(String skuPmoney) {
    this.skuPmoney = skuPmoney;
  }


  public String getGoodId() {
    return goodId;
  }

  public void setGoodId(String goodId) {
    this.goodId = goodId;
  }


  public long getOrderNo() {
    return orderNo;
  }

  public void setOrderNo(long orderNo) {
    this.orderNo = orderNo;
  }


  public String getServiceMoney() {
    return serviceMoney;
  }

  public void setServiceMoney(String serviceMoney) {
    this.serviceMoney = serviceMoney;
  }

  @Override
  public String toString() {
    return "WxbGoodSku{" +
            "skuId='" + skuId + '\'' +
            ", skuName='" + skuName + '\'' +
            ", skuCost='" + skuCost + '\'' +
            ", skuPrice='" + skuPrice + '\'' +
            ", skuPmoney='" + skuPmoney + '\'' +
            ", goodId='" + goodId + '\'' +
            ", orderNo=" + orderNo +
            ", serviceMoney='" + serviceMoney + '\'' +
            '}';
  }
}
