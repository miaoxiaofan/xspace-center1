package com.xspace.ordercenter.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicom.js.ibo.infocenter.dao.TBuildingMapper;
import com.unicom.js.ibo.infocenter.dao.TCompanyCountOfBuildingMapper;
import com.unicom.js.ibo.infocenter.rsp.BuildingIndustryStatRsp;
import com.unicom.js.ibo.infocenter.service.TBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wmiao
 * @description
 * @date 2019/8/1
 */
@Service
public class TBuildingServiceImpl implements TBuildingService {
    @Autowired
    private TBuildingMapper tBuildingMapper;

    @Autowired
    private TCompanyCountOfBuildingMapper tCompanyCountOfBuildingMapper;

    @Override
    public PageInfo<BuildingIndustryStatRsp> buildingList(Integer pageNo, Integer pageSize, String parkCode) {
        PageHelper.startPage(pageNo, pageSize);

        List<BuildingIndustryStatRsp> list = tBuildingMapper.buildingList(parkCode);
        if (null == list) {
            return null;
        }
        //遍历获取每个楼宇的行业分布情况
        for (BuildingIndustryStatRsp item : list) {
            item.setIndustryList(tCompanyCountOfBuildingMapper.buildIndustryList(parkCode, item.getBuildCode()));
        }
        PageInfo<BuildingIndustryStatRsp> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
}
