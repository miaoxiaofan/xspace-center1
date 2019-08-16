package com.xspace.management.service.impl;

import com.github.pagehelper.PageInfo;
import com.xspace.management.service.TCompanyService;
import com.xspace.ordercenter.api.TCompanyApi;
import com.xspace.ordercenter.req.BuildingCompanyInfoReq;
import com.xspace.ordercenter.req.SearchCompanyReq;
import com.xspace.ordercenter.rsp.CompanyInfoRsp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author wmiao
 * @description
 * @date 2019/8/1
 */
@Service
public class TCompanyServiceImpl implements TCompanyService {
    @Autowired
    private TCompanyApi tCompanyApi;
    @Override
    public PageInfo<CompanyInfoRsp> companyList(BuildingCompanyInfoReq req)  throws Exception  {
        return tCompanyApi.companyList(req);
    }

    @Override
    public String markCompany(String companyCode,String managerCode) {
        return tCompanyApi.markCompany(companyCode, managerCode);
    }

    @Override
    public PageInfo<CompanyInfoRsp> searchCompany(SearchCompanyReq req) throws Exception{
        return tCompanyApi.searchCompany(req);
    }

    @Override
    public List<CompanyInfoRsp> findHotCompany(Map<String, Object> queryParam){
        return tCompanyApi.findHotCompany(queryParam);
    }
}
