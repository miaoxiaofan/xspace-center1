package com.xspace.ordercenter.api.impl;


import com.xspace.commoncenter.enums.BaseErrorEnum;
import com.xspace.commoncenter.exception.BusinessException;
import com.xspace.ordercenter.api.IndustryApi;
import com.xspace.ordercenter.rsp.BasePercentageRsp;
import com.xspace.ordercenter.rsp.IndustryTypeRsp;
import com.xspace.ordercenter.service.IndustryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author wmiao
 * @description
 * @date 2019/7/30
 */

@Service
public class IndustryApiImpl implements IndustryApi {

    private  final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private IndustryService industryService;


    @Override
    public List<BasePercentageRsp> parkIndustryList(String searchCode) {

        LOGGER.info("园区行业分类列表查询  parkCode:{}",searchCode);
        List<BasePercentageRsp> result=new ArrayList<>();
        try {
            result = industryService.parkIndustryList(searchCode);
        } catch (Exception e) {
            LOGGER.error("系统异常",e);
            throw  new BusinessException(BaseErrorEnum.BASE_ERROR_9999);
        }
        return  result;
    }

    @Override
    public List<BasePercentageRsp> buildIndustryList(String parkCode,String buildCode) {
        LOGGER.info("楼宇行业分类列表查询 parkCode:{},buildCode:{}",parkCode,buildCode);
        List<BasePercentageRsp> result=new ArrayList<>();
        try {
            result=industryService.buildIndustryList(parkCode,buildCode);
        } catch (Exception e) {
            LOGGER.error("系统异常",e);
            throw  new BusinessException(BaseErrorEnum.BASE_ERROR_9999);
        }
        return  result;
    }


    @Override
    public List<IndustryTypeRsp> findIndustryType()  {

        LOGGER.info("开始行业分类数据查询  ");
        List<IndustryTypeRsp> result=new ArrayList<>();
        try {
            result=industryService.findIndustryType();
        }catch (Exception e){
            LOGGER.error("系统异常",e);
            throw  new BusinessException(BaseErrorEnum.BASE_ERROR_9999);
        }
        return  result;
    }
}
