package com.xspace.ordercenter.rsp;

import java.io.Serializable;
import java.util.List;

/**
 * @author wmiao
 * @description
 * @date 2019/8/8
 */

public class IndustryTypeRsp implements Serializable {

    private String  code;
    private String name;
    private List<BaseIndustryTypeRsp> children;

    public IndustryTypeRsp() {
    }

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

    public List<BaseIndustryTypeRsp> getChildren() {
        return children;
    }

    public void setChildren(List<BaseIndustryTypeRsp> children) {
        this.children = children;
    }

    public IndustryTypeRsp(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
