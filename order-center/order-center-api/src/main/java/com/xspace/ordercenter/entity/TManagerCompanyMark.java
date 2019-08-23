package com.xspace.ordercenter.entity;

import java.io.Serializable;

public class TManagerCompanyMark implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 网格经理编码
     */
    private Integer managerCode;

    /**
     * 公司编码
     */
    private Integer companyCode;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getManagerCode() {
        return managerCode;
    }

    public void setManagerCode(Integer managerCode) {
        this.managerCode = managerCode;
    }

    public Integer getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(Integer companyCode) {
        this.companyCode = companyCode;
    }
}