package com.xspace.management.service;

import com.github.pagehelper.PageInfo;
import com.xspace.ordercenter.req.BuildingCompanyInfoReq;
import com.xspace.ordercenter.req.SearchCompanyReq;
import com.xspace.ordercenter.rsp.CompanyInfoRsp;

import java.util.List;
import java.util.Map;

public interface TCompanyService {
    PageInfo<CompanyInfoRsp> companyList(BuildingCompanyInfoReq req)  throws Exception;

    String markCompany(String companyCode, String managerCode) throws Exception;

    PageInfo<CompanyInfoRsp> searchCompany(SearchCompanyReq req)throws Exception;

    List<CompanyInfoRsp> findHotCompany(Map<String, Object> queryParam);
}
