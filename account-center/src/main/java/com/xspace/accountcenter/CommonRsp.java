package com.xspace.accountcenter;

/**
 * @author wmiao
 * @description
 * @date 2019/6/24
 */

public class CommonRsp <T> {

    private String  code;
    private static final String SUCESS="0";
    private static final String FAIL="999";
    private String msg;
    private  T data;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public  Boolean isSuccess(){
        return  SUCESS.equals(code)?true:false;
    }
    public   void fail(String code,String msg){
        this.code=code;
        this.msg=msg;
    }


}
