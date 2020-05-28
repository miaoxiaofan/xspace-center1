package com.xspace.commoncenter.test;

import com.alibaba.fastjson.JSONObject;

import java.util.Vector;

/**
 * @author wmiao
 * @description
 * @date 2019/12/23
 */

public  abstract  class TEss {

    public  String getMss() {
        return "222";


    }

    public  static void  ccc(){
        String reqMsg="dfagfd";
        RequestObject requestObject = JSONObject.parseObject(reqMsg, RequestObject.class);
    }


    public static void main(String[] args) {
        try {
            ccc();


            Vector<String>  a=new Vector<>();

           // a.forEach();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
