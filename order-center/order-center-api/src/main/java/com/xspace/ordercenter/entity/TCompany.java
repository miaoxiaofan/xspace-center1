package com.xspace.ordercenter.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TCompany implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 公司编码
     */
    private Integer code;

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
    private Integer buildingCode;

    /**
     * 办公楼名称
     */
    private String buildingName;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 法人
     */
    private String corporation;

    /**
     * 创立日期
     */
    private Date createDate;

    /**
     * 注册资金
     */
    private Integer registeredCapital;

    /**
     * 地址
     */
    private String address;

    /**
     * 联系电话
     */
    private String phoneNumber;

    /**
     * 经度
     */
    private BigDecimal longitude;

    /**
     * 纬度
     */
    private BigDecimal latitude;

    /**
     * 经营范围
     */
    private String businessScope;

    /**
     * 意向业务编码
     */
    private int intendedBusinessCode;

    /**
     * 行业分类编码
     */
    private int industryTypeCode;

    /**
     * 意向业务
     */
    private String intendedBusiness;

    public String getIntendedBusiness() {
        return intendedBusiness;
    }

    public void setIntendedBusiness(String intendedBusiness) {
        this.intendedBusiness = intendedBusiness;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
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

    public Integer getBuildingCode() {
        return buildingCode;
    }

    public void setBuildingCode(Integer buildingCode) {
        this.buildingCode = buildingCode;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName == null ? null : buildingName.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCorporation() {
        return corporation;
    }

    public void setCorporation(String corporation) {
        this.corporation = corporation == null ? null : corporation.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(Integer registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope == null ? null : businessScope.trim();
    }

    public int getIntendedBusinessCode() {
        return intendedBusinessCode;
    }

    public void setIntendedBusinessCode(int intendedBusinessCode) {
        this.intendedBusinessCode = intendedBusinessCode;
    }

    public int getIndustryTypeCode() {
        return industryTypeCode;
    }

    public void setIndustryTypeCode(int industryTypeCode) {
        this.industryTypeCode = industryTypeCode;
    }

    public TCompany() {
    }

    public TCompany(Integer code, Integer parkCode, String parkName, Integer buildingCode, String buildingName, String companyName, String corporation, Date createDate, Integer registeredCapital, String address, String phoneNumber, BigDecimal longitude, BigDecimal latitude, String businessScope, int intendedBusinessCode, int industryTypeCode) {
        this.code = code;
        this.parkCode = parkCode;
        this.parkName = parkName;
        this.buildingCode = buildingCode;
        this.buildingName = buildingName;
        this.companyName = companyName;
        this.corporation = corporation;
        this.createDate = createDate;
        this.registeredCapital = registeredCapital;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.longitude = longitude;
        this.latitude = latitude;
        this.businessScope = businessScope;
        this.intendedBusinessCode = intendedBusinessCode;
        this.industryTypeCode = industryTypeCode;
    }
}