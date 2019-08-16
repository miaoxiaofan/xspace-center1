package com.xspace.ordercenter.rsp;

import java.io.Serializable;
import java.util.List;

/**
 * @author wmiao
 * @description
 * @date 2019/8/1
 */

public class BuildingIndustryStatRsp implements Serializable{
    private static final long serialVersionUID = 7957357257811943141L;
    /**
     * 办公楼编码
     */
    private String buildCode;
    /**
     * 办公楼名称
     */
    private String  buildingName;
    /**
     * 办公楼行业分类列表
     */
    private List<ParkIndustryPercentageRsp> industryList;


    public String getBuildCode() {
        return buildCode;
    }

    public void setBuildCode(String buildCode) {
        this.buildCode = buildCode;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public List<ParkIndustryPercentageRsp> getIndustryList() {
        return industryList;
    }

    public void setIndustryList(List<ParkIndustryPercentageRsp> industryList) {
        this.industryList = industryList;
    }
}
