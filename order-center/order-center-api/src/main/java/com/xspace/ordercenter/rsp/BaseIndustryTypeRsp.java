package com.xspace.ordercenter.rsp;

import java.io.Serializable;

/**
 * @author wmiao
 * @description
 * @date 2019/8/8
 */

public class BaseIndustryTypeRsp implements Serializable {
    private static final long serialVersionUID = -2404102771156299398L;

    private String name;
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BaseIndustryTypeRsp() {
    }

    public BaseIndustryTypeRsp(String name, String code) {
        this.name = name;
        this.code = code;
    }
}
