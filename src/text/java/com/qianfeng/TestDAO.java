package com.qianfeng;

import com.qianfeng.fxmall.goods.bean.WxbGood;
import org.junit.Test;



public class TestDAO {
    public int A(int n){
        if(n==1||n==2){
            return 1;
        }else{
            int x = A(n-2)+A(n-1);
            return  x;
        }
    }
    @Test
    public void test(){
        for(int i=1;i<30;i++){
            System.out.print(A(i)+",");
        }
    }
}
