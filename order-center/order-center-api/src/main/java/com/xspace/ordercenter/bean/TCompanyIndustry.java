package com.xspace.ordercenter.bean;

import java.io.Serializable;

public class TCompanyIndustry implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 公司编码
     */
    private Integer companyCode;

    /**
     * 行业分类编码
     */
    private Byte industryCode;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(Integer companyCode) {
        this.companyCode = companyCode;
    }

    public Byte getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(Byte industryCode) {
        this.industryCode = industryCode;
    }
}