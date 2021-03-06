package com.xspace.ordercenter.api.impl;

import com.github.pagehelper.PageInfo;

import com.xspace.commoncenter.enums.BaseErrorEnum;
import com.xspace.commoncenter.exception.BusinessException;
import com.xspace.ordercenter.api.TParkApi;
import com.xspace.ordercenter.req.SearchParkReq;
import com.xspace.ordercenter.rsp.SearchParkRsp;
import com.xspace.ordercenter.service.TParkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author huxl
 * @description
 * @date 2019/7/31
 */
@Service("tParkService")
public class TParkApiService implements TParkApi {

    private Logger logger = LoggerFactory.getLogger(TParkApiService.class);

    @Autowired
    private TParkService tParkService;

    @Override
    public PageInfo<SearchParkRsp> findParkList(Map<String, Object> queryParam, Integer pageNum, Integer pageSize){
        logger.info("开始分页查询园区总览列表：queryParam{}",queryParam);
        PageInfo<SearchParkRsp>   result=null;
        try {
            result=  tParkService.findParkList(queryParam,pageNum,pageSize);
        }catch (Exception e){
            logger.error("分页查询园区总览列表系统异常"+e);
            throw new BusinessException(BaseErrorEnum.BASE_ERROR_9999);
        }
        return result;
    }

    @Override
    public PageInfo<SearchParkRsp> searchPark(SearchParkReq req) {
        logger.info("------智能查找-查找园区 ,req:{}", req);

        PageInfo<SearchParkRsp> result;
        try {
            result = tParkService.searchPark(req);
        } catch (Exception e) {
            logger.error("系统异常", e);
            throw new BusinessException(BaseErrorEnum.BASE_ERROR_9999);
        }
        return result;
    }
}
