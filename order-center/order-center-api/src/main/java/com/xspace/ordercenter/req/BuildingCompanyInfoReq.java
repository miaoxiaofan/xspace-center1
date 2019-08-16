package com.xspace.ordercenter.req;

import java.io.Serializable;

/**
 * @author wmiao
 * @description 查询楼宇下企业列表
 * @date 2019/8/2
 */

public class BuildingCompanyInfoReq implements Serializable {
    private static final long serialVersionUID = 2190042039085034144L;
    /**
     * 楼宇编码
     */
    private String buildingCode;
    /**
     * 	行业编码,多个以逗号隔开（1,2,3）
     */
    private String industryCode;
    /**
     * 分页起始页码
     */
    private Integer pageNo;
    /**
     * 每页数目
     */
    private Integer pageSize;
    /**
     * 网格经理编码
     */
    private String managerCode;

    public String getManagerCode() {
        return managerCode;
    }

    public void setManagerCode(String managerCode) {
        this.managerCode = managerCode;
    }

    public String getBuildingCode() {
        return buildingCode;
    }

    public void setBuildingCode(String buildingCode) {
        this.buildingCode = buildingCode;
    }

    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
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

    @Override
    public String toString() {
        return "BuildingCompanyInfoReq{" +
                "buildingCode='" + buildingCode + '\'' +
                ", industryCode='" + industryCode + '\'' +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                '}';
    }
}
