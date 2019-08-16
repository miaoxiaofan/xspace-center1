package com.xspace.management.service;

import com.github.pagehelper.PageInfo;
import com.unicom.js.ibo.infocenter.req.BuildingCompanyInfoReq;
import com.unicom.js.ibo.infocenter.req.SearchCompanyReq;
import com.unicom.js.ibo.infocenter.rsp.CompanyInfoRsp;

import java.util.List;
import java.util.Map;

public interface TCompanyService {
    PageInfo<CompanyInfoRsp> companyList(BuildingCompanyInfoReq req)  throws Exception;

    String markCompany(String companyCode, String managerCode) throws Exception;

    PageInfo<CompanyInfoRsp> searchCompany(SearchCompanyReq req)throws Exception;

    List<CompanyInfoRsp> findHotCompany(Map<String, Object> queryParam);
}
