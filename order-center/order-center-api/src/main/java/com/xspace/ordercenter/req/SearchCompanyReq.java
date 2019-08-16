package com.xspace.ordercenter.req;

import java.io.Serializable;

/**
 * @author wmiao
 * @description
 * @date 2019/8/2
 */

public class SearchCompanyReq implements Serializable {
    private static final long serialVersionUID = -8394122535036333672L;

    private String companyName;
    private String industryCode;
    private String intendedBusinessCode;
    private Integer pageNo;
    private Integer pageSize;
    private String managerCode;
    private String visitFlag;

    public String getManagerCode() {
        return managerCode;
    }

    public void setManagerCode(String managerCode) {
        this.managerCode = managerCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }

    public String getIntendedBusinessCode() {
        return intendedBusinessCode;
    }

    public void setIntendedBusinessCode(String intendedBusinessCode) {
        this.intendedBusinessCode = intendedBusinessCode;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getVisitFlag() {
        return visitFlag;
    }

    public void setVisitFlag(String visitFlag) {
        this.visitFlag = visitFlag;
    }

    @Override
    public String toString() {
        return "SearchCompanyReq{" +
                "companyName='" + companyName + '\'' +
                ", industryCode='" + industryCode + '\'' +
                ", intendedBusinessCode='" + intendedBusinessCode + '\'' +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", visitFlag='" + visitFlag + '\'' +
                '}';
    }
}
