package com.xspace.ordercenter.service;

import com.github.pagehelper.PageInfo;
import com.unicom.js.ibo.infocenter.rsp.BuildingIndustryStatRsp;

public interface TBuildingService {

    PageInfo<BuildingIndustryStatRsp> buildingList(Integer pageNo, Integer pageSize, String parkCode);
}
