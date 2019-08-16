package com.xspace.management.service.impl;

import com.github.pagehelper.PageInfo;
import com.unicom.js.ibo.iboapi.service.TBuildingService;
import com.unicom.js.ibo.infocenter.api.TBuildingApi;
import com.unicom.js.ibo.infocenter.rsp.BuildingIndustryStatRsp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wmiao
 * @description
 * @date 2019/8/1
 */
@Service
public class TBuildingServiceImpl implements TBuildingService {

    @Autowired
    private TBuildingApi tBuildingApi;
    @Override
    public PageInfo<BuildingIndustryStatRsp> buildingList(Integer pageNo, Integer pageSize, String parkCode) throws Exception {
        return tBuildingApi.buildingList(pageNo,pageSize,parkCode);
    }
}
