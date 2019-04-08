package com.qianfeng;

import org.junit.Test;

public class TestSth {

    public void TPF(String str){
        switch (str){
            case "a*":{
                System.out.println("A");
            }break;
            case "b*":{
                System.out.println("B");
            }break;
            case "c*":{
                System.out.println("C");
            }break;
        }
    }

    @Test
    public void testCase(){
        String a1 = "ab";
        String a2 = "abc";
        String b1 = "b*";
        String c1 = "Ca";
        TPF(a1);
        TPF(a2);
        TPF(b1);
        TPF(c1);
    }
}
