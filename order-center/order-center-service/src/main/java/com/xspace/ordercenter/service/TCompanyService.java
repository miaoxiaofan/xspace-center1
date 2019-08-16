package com.xspace.ordercenter.service;

import com.github.pagehelper.PageInfo;
import com.xspace.ordercenter.bean.TManagerCompanyMark;
import com.xspace.ordercenter.req.BuildingCompanyInfoReq;
import com.xspace.ordercenter.req.SearchCompanyReq;
import com.xspace.ordercenter.rsp.CompanyInfoRsp;

import java.util.List;

/**
 * @author wmiao
 * @description
 * @date 2019/8/1
 */

public interface TCompanyService {
    PageInfo<CompanyInfoRsp> companyList(BuildingCompanyInfoReq req);

    void markCompany(String companyCode, String managerCode);
    List<TManagerCompanyMark> findCompanyMark(String companyCode, String managerCode);

    PageInfo<CompanyInfoRsp> searchCompany(SearchCompanyReq req);

    List<CompanyInfoRsp> findHotCompany(Integer managerCode, List<String> hotCompanyIds);
}
