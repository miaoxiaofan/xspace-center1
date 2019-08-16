package com.xspace.ordercenter.api;

import com.github.pagehelper.PageInfo;
import com.unicom.js.ibo.common.exception.BusinessException;
import com.unicom.js.ibo.infocenter.req.BuildingCompanyInfoReq;
import com.unicom.js.ibo.infocenter.req.SearchCompanyReq;
import com.unicom.js.ibo.infocenter.rsp.CompanyInfoRsp;

import java.util.List;
import java.util.Map;

public interface TCompanyApi {
    PageInfo<CompanyInfoRsp> companyList(BuildingCompanyInfoReq req) throws Exception;

    PageInfo<CompanyInfoRsp> searchCompany(SearchCompanyReq req) throws Exception;
    String markCompany(String companyCode, String managerCode) throws BusinessException;

    /**
     * 查询智能热推企业
     * @param queryParam
     * @param queryParam
     * @return
     */
    List<CompanyInfoRsp> findHotCompany(Map<String, Object> queryParam);
}
