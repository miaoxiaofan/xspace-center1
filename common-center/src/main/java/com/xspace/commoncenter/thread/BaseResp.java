package com.xspace.commoncenter.thread;



import java.io.Serializable;

/**
 * 基础返回对象
 * 
 * @author wm
 *
 */
public class BaseResp implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 4360749510983851099L;

    public static final String SUCCESS = "0";
    public static final String FAIL = "1";

    /**
     * 返回码，默认成功。
     */
    private String code = SUCCESS;
    /**
     * 返回信息
     */
    private String msg;

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

    @Override
    public String toString() {
        return "BaseRespVo [code=" + code + ", msg=" + msg + "]";
    }

    /**
     * 返回失败
     * 
     * @param errorMsg
     */
    public void fail(String errorMsg) {
        this.fail(FAIL, errorMsg);
    }

    /**
     * 返回失败
     * 
     * @param errorCode
     * @param errorMsg
     */
    public void fail(String errorCode, String errorMsg) {
        this.code = errorCode;
        this.msg = errorMsg;
    }

    /**
     * 判断返回是否成功
     * 
     * @return
     */
    public boolean isSuccess() {
        return SUCCESS.equals(this.code);
    }

}
