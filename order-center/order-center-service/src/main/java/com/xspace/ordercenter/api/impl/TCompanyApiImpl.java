package com.xspace.ordercenter.api.impl;

import com.github.pagehelper.PageInfo;

import com.xspace.commoncenter.enums.BaseErrorEnum;
import com.xspace.commoncenter.exception.BusinessException;
import com.xspace.ordercenter.api.TCompanyApi;
import com.xspace.ordercenter.entity.TManagerCompanyMark;
import com.xspace.ordercenter.req.BuildingCompanyInfoReq;
import com.xspace.ordercenter.req.SearchCompanyReq;
import com.xspace.ordercenter.rsp.CompanyInfoRsp;
import com.xspace.ordercenter.service.TCompanyService;
import com.xspace.ordercenter.service.TManagerCompanyRecommendService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author wmiao
 * @description
 * @date 2019/8/1
 */
@Service("tCompanyApiImpl")
public class TCompanyApiImpl implements TCompanyApi {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TCompanyService tCompanyService;

    @Autowired
    private TManagerCompanyRecommendService tManagerCompanyRecommendService;

    @Override
    public PageInfo<CompanyInfoRsp> companyList(BuildingCompanyInfoReq req) throws Exception {
        logger.info("------查询楼宇下企业列表,req:{}", req);


        PageInfo<CompanyInfoRsp> result;
        try {
            result = tCompanyService.companyList(req);
        } catch (Exception e) {
            logger.error("系统异常", e);
            throw new BusinessException(BaseErrorEnum.BASE_ERROR_9999);
        }
        return result;
    }

    @Override
    public PageInfo<CompanyInfoRsp> searchCompany(SearchCompanyReq req) throws Exception {
        logger.info("------智能查找-查找企业 ,req:{}", req);


        PageInfo<CompanyInfoRsp> result;
        try {
            result = tCompanyService.searchCompany(req);
        } catch (Exception e) {
            logger.error("系统异常", e);
            throw new BusinessException(BaseErrorEnum.BASE_ERROR_9999);
        }
        return result;
    }

    @Override
    public String markCompany(String companyCode, String managerCode) throws BusinessException {
        logger.info("------企业拜访打卡,companyCode:{}，managerCode：{}", companyCode,managerCode);

        String resut = "";

        List<TManagerCompanyMark> result = tCompanyService.findCompanyMark(companyCode, managerCode);
        if (null != result && result.size() > 0) {
            throw new BusinessException(BaseErrorEnum.BASE_ERROR_0003);
        }
        try {
            tCompanyService.markCompany(companyCode, managerCode);
            resut = "打卡成功";
        } catch (Exception e) {
            logger.error("系统异常", e);
            throw new BusinessException(BaseErrorEnum.BASE_ERROR_9999);
        }

        return resut;
    }

    @Override
    public List<CompanyInfoRsp> findHotCompany(Map<String, Object> queryParam){
        logger.info("开始查询智能热推企业：queryParam:{}",queryParam);
        List<CompanyInfoRsp>   hotCompanyList=new ArrayList<>();
        List<String> hotCompanyIds = new ArrayList<String>();
        Integer managerCode= (Integer) queryParam.get("managerCode");
        try {
        hotCompanyIds = tManagerCompanyRecommendService.findHotCompanyIds(queryParam);

        if (hotCompanyIds.isEmpty()) {
            return hotCompanyList;
        }

        hotCompanyList=  tCompanyService.findHotCompany(managerCode,hotCompanyIds);

        }catch (Exception e){
            logger.error("查询智能热推企业系统异常"+e);
            throw new BusinessException(BaseErrorEnum.BASE_ERROR_9999);
        }
        return hotCompanyList;
    }
}
