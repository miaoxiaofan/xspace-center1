package com.xspace.ordercenter.rsp;

import java.io.Serializable;

/**
 * @author wmiao
 * @description
 * @date 2019/8/2
 */

public class SearchParkRsp implements Serializable {
    private static final long serialVersionUID = -778063603647902394L;

    private String address;
    private Integer buildingNum;
    private String logoSrc;
    private String parkCode;
    private String parkName;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getBuildingNum() {
        return buildingNum;
    }

    public void setBuildingNum(Integer buildingNum) {
        this.buildingNum = buildingNum;
    }

    public String getLogoSrc() {
        return logoSrc;
    }

    public void setLogoSrc(String logoSrc) {
        this.logoSrc = logoSrc;
    }

    public String getParkCode() {
        return parkCode;
    }

    public void setParkCode(String parkCode) {
        this.parkCode = parkCode;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }
}
