package com.xspace.ordercenter.bean;

import java.io.Serializable;

public class TBuilding implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 办公楼编码
     */
    private String buildingCode;

    /**
     * 办公楼名称
     */
    private String buildingName;

    /**
     * 园区编码
     */
    private Integer parkCode;

    /**
     * 园区名称
     */
    private String parkName;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBuildingCode() {
        return buildingCode;
    }

    public void setBuildingCode(String buildingCode) {
        this.buildingCode = buildingCode == null ? null : buildingCode.trim();
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName == null ? null : buildingName.trim();
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
}