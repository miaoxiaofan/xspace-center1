package com.xspace.commoncenter.enums;


/**
 * 异常类
 */
public enum BaseErrorEnum {
    BASE_ERROR_9999("BASE_ERROR_9999", "系统异常"),
    BASE_ERROR_0001("BASE_ERROR_0001", "手机号为空"),
    BASE_ERROR_0002("BASE_ERROR_0002", "手机号格式有误"),
    BASE_ERROR_0003("BASE_ERROR_0003", "已经打过卡,无需再打卡");

    private String code;
    private String msg;

    BaseErrorEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

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
}


