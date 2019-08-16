package com.xspace.ordercenter.bean;

import java.io.Serializable;

public class TCompanyCountOfBuilding implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 园区编码
     */
    private Integer parkCode;

    /**
     * 园区名称
     */
    private String parkName;

    /**
     * 办公楼编码
     */
    private Integer buildCode;

    /**
     * 办公楼名称
     */
    private String buildName;

    /**
     * 行业分类编码
     */
    private Byte industryTypeCode;

    /**
     * 行业分类名称
     */
    private String industryTypeName;

    /**
     * 公司数量
     */
    private Integer companyNum;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParkCode() {
        return parkCode;
    }

    public void setParkCode(Integer parkCode) {
        this.parkCode = parkCode;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName == null ? null : parkName.trim();
    }

    public Integer getBuildCode() {
        return buildCode;
    }

    public void setBuildCode(Integer buildCode) {
        this.buildCode = buildCode;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName == null ? null : buildName.trim();
    }

    public Byte getIndustryTypeCode() {
        return industryTypeCode;
    }

    public void setIndustryTypeCode(Byte industryTypeCode) {
        this.industryTypeCode = industryTypeCode;
    }

    public String getIndustryTypeName() {
        return industryTypeName;
    }

    public void setIndustryTypeName(String industryTypeName) {
        this.industryTypeName = industryTypeName == null ? null : industryTypeName.trim();
    }

    public Integer getCompanyNum() {
        return companyNum;
    }

    public void setCompanyNum(Integer companyNum) {
        this.companyNum = companyNum;
    }


}