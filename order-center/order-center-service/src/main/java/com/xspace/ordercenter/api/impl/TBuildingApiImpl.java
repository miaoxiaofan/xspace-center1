package com.xspace.ordercenter.api.impl;

import com.github.pagehelper.PageInfo;
import com.xspace.commoncenter.enums.BaseErrorEnum;
import com.xspace.commoncenter.exception.BusinessException;
import com.xspace.ordercenter.api.TBuildingApi;
import com.xspace.ordercenter.rsp.BuildingIndustryStatRsp;
import com.xspace.ordercenter.service.TBuildingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wmiao
 * @description
 * @date 2019/8/1
 */
@Service("tBuildingApiImpl")
public class TBuildingApiImpl implements TBuildingApi {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TBuildingService tBuildingService;

    @Override
    public PageInfo<BuildingIndustryStatRsp> buildingList(Integer pageNo, Integer pageSize, String parkCode) throws Exception {
        logger.info("开始查询园区下楼宇列表,  pageNo:{}，pageSize：{},parkCode:{}", pageNo, pageSize, parkCode);
        PageInfo<BuildingIndustryStatRsp> rspList;
        try {
            rspList = tBuildingService.buildingList(pageNo, pageSize, parkCode);
        } catch (Exception e) {
            logger.error("系统异常", e);
            throw new BusinessException(BaseErrorEnum.BASE_ERROR_9999);
        }
        return rspList;
    }
}
