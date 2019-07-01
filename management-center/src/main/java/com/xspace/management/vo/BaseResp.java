package com.xspace.management.vo;

import java.io.Serializable;

/**
 * @author wmiao
 * @description
 * @date 2019/6/4
 */


public class BaseResp  implements Serializable {
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

    /*
    结果集
     */
    private DataResp datas;
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

    public DataResp getDatas() {
        return datas;
    }

    public void setDatas(DataResp datas) {
        this.datas = datas;
    }

    /**
     * 返回失败
     *
     * @param errorMsg
     */
    public void fail(String errorMsg) {
        this.code = FAIL;
        this.msg = errorMsg;
    }

    @Override
    public String toString() {
        return "BaseRespVo [code=" + code + ", msg=" + msg + "]";
    }

}
