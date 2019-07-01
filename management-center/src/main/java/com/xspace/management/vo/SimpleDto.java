package com.xspace.management.vo;

import java.io.Serializable;

/**
 * @author wmiao
 * @description
 * @date 2019/5/30
 */

public class SimpleDto implements Serializable {
    private static final long serialVersionUID = 4970048089728233515L;


    private String  name;
    private Integer age;
    private String  time;
    private String msg;
    private String   msgCode;

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
