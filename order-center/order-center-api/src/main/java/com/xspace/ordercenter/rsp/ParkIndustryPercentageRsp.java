package com.xspace.ordercenter.rsp;

import java.io.Serializable;

/**
 * @author wmiao
 * @description
 * @date 2019/7/31
 */

public class ParkIndustryPercentageRsp implements Serializable {
    private static final long serialVersionUID = -757447167884327105L;
    /**
     * 公司行业分类百分比
     */
    private String companyRate;

    /**
     * 公司行业分类计数
     */
    private Integer companyNum;
    /**
     * 行业分类名称
     */
    private String industryName;
    /**
     * 行业分类编码
     */
    private String industryCode;

    public Integer getCompanyNum() {
        return companyNum;
    }

    public void setCompanyNum(Integer companyNum) {
        this.companyNum = companyNum;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public String getCompanyRate() {
        return companyRate;
    }

    public void setCompanyRate(String companyRate) {
        this.companyRate = companyRate;
    }

    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }
}
