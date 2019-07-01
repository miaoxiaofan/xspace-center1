package com.xspace.accountcenter;

import java.io.Serializable;

/**
 * @author wmiao
 * @description
 * @date 2019/4/22
 */

public class MarketCenterRespVo implements Serializable {
    private static final long serialVersionUID = 7871702959104026344L;
    /*
         应答编码
         */
    private String finishTime;
    /*
    接口返回描述
     */
    private String message;
    /*
    应答时间戳，格式yyyyMMddHHmmss
     */
    private String orderNo;


    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    @Override
    public String toString() {
        return "MarketCenterRespVo{" +
                "finishTime='" + finishTime + '\'' +
                ", message='" + message + '\'' +
                ", orderNo='" + orderNo + '\'' +
                '}';
    }
}
