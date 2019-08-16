package com.xspace.ordercenter.bean;

import java.io.Serializable;

public class TManagerCompanyRecommend implements Serializable {
    /**
     * 主键id
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

    /**
     * 推荐指数
     */
    private Integer ourRatings;

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

    public Integer getOurRatings() {
        return ourRatings;
    }

    public void setOurRatings(Integer ourRatings) {
        this.ourRatings = ourRatings;
    }

    public TManagerCompanyRecommend(Integer managerCode, Integer companyCode, Integer ourRatings) {
        this.managerCode = managerCode;
        this.companyCode = companyCode;
        this.ourRatings = ourRatings;
    }
}