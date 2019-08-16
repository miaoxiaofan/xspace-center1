package com.xspace.ordercenter.service;

import com.github.pagehelper.PageInfo;
import com.xspace.ordercenter.rsp.BuildingIndustryStatRsp;

public interface TBuildingService {

    PageInfo<BuildingIndustryStatRsp> buildingList(Integer pageNo, Integer pageSize, String parkCode);
}
