package com.xspace.ordercenter.api;

import com.github.pagehelper.PageInfo;
import com.unicom.js.ibo.infocenter.rsp.BuildingIndustryStatRsp;

public interface TBuildingApi {
    PageInfo<BuildingIndustryStatRsp> buildingList(Integer pageNo, Integer pageSize, String parkCode) throws Exception;
}
