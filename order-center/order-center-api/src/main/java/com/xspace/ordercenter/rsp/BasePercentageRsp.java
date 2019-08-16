package com.xspace.ordercenter.rsp;

import java.io.Serializable;

/**
 * @author wmiao
 * @description
 * @date 2019/8/8
 */

public class BasePercentageRsp implements Serializable {
    private static final long serialVersionUID = 2944646034840834793L;
    /**
     * 行业分类名称
     */
    private String name;
    /**
     * 公司行业分类百分比
     */
    private String value;

    public BasePercentageRsp() {
    }

    public BasePercentageRsp(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
