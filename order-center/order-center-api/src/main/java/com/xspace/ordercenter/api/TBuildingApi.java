package com.xspace.ordercenter.api;

import com.github.pagehelper.PageInfo;

import com.xspace.ordercenter.rsp.BuildingIndustryStatRsp;

public interface TBuildingApi {
    PageInfo<BuildingIndustryStatRsp> buildingList(Integer pageNo, Integer pageSize, String parkCode) throws Exception;
}
