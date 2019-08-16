package com.xspace.commoncenter;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;

/**
 * 通用返回结果对象
 *
 * @author luoguohui
 * Created 2017/4/17 10:51
 */
public class ApiResultEntity {
    public static final int SUCCESS = 200;//请求成功
    public static final int FAIL = 400;//请求出错
    public static final int NOAUTH = 401;//未登录认证

    private int code;
    private HashMap<String, Object> datas;

    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public HashMap<String, Object> getDatas() {
        return datas;
    }

    public void setDatas(HashMap<String, Object> datas) {
        this.datas = datas;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ApiResultEntity() {
    }

    public ApiResultEntity(int code) {
        this.code = code;
    }

    public ApiResultEntity(int code, HashMap<String, Object> datas) {
        this.code = code;
        this.datas = datas;
    }

    public ApiResultEntity(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ApiResultEntity(int code, String msg, HashMap<String, Object> datas) {
        this.code = code;
        this.msg = msg;
        this.datas = datas;
    }

    public static ApiResultEntity SUCCESS(String msg, HashMap<String, Object> datas) {
        return new ApiResultEntity(SUCCESS, msg, datas);
    }

    public static ApiResultEntity SUCCESS(HashMap<String, Object> datas) {
        return new ApiResultEntity(SUCCESS, datas);
    }

    public static ApiResultEntity SUCCESS(String msg) {
        return new ApiResultEntity(SUCCESS, msg);
    }

    public static ApiResultEntity SUCCESS() {
        return new ApiResultEntity(SUCCESS);
    }

    public static ApiResultEntity FAILURE(String msg, HashMap<String, Object> datas) {
        return new ApiResultEntity(FAIL, msg, datas);
    }

    public static ApiResultEntity FAILURE(HashMap<String, Object> datas) {
        return new ApiResultEntity(FAIL, datas);
    }

    public static ApiResultEntity FAILURE(String msg) {
        return new ApiResultEntity(FAIL, msg);
    }

    public static ApiResultEntity FAILURE(int code, String msg) {
        return new ApiResultEntity(code, msg);
    }

    public static ApiResultEntity FAILURE() {
        return new ApiResultEntity(FAIL);
    }

    public static ApiResultEntity FAILURE(int code) {
        return new ApiResultEntity(code);
    }


    @Override
    public String toString() {
        return "ApiResultEntity:" + JSON.toJSONString(this);
    }
}
