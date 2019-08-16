package com.xspace.ordercenter.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xspace.ordercenter.bean.TManagerCompanyMark;
import com.xspace.ordercenter.dao.TCompanyMapper;
import com.xspace.ordercenter.dao.TManagerCompanyMarkMapper;
import com.xspace.ordercenter.req.BuildingCompanyInfoReq;
import com.xspace.ordercenter.req.SearchCompanyReq;
import com.xspace.ordercenter.rsp.CompanyInfoRsp;
import com.xspace.ordercenter.service.TCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @author wmiao
 * @description
 * @date 2019/8/1
 */
@Service
public class TCompanyServiceImpl implements TCompanyService {

    @Autowired
    private TCompanyMapper tCompanyMapper;
    @Autowired
    private TManagerCompanyMarkMapper tManagerCompanyMarkMapper;

    @Override
    public PageInfo<CompanyInfoRsp> companyList(BuildingCompanyInfoReq req) {
        PageHelper.startPage(req.getPageNo(), req.getPageSize());
       /* String industryCode = req.getIndustryCode();
        List<String> industryCodes = null;

        if (!StringUtils.isEmpty(industryCode)) {
            industryCodes = Arrays.asList(industryCode.split(","));
        }*/

        List<CompanyInfoRsp> companyList=tCompanyMapper.companyList(req);
        PageInfo<CompanyInfoRsp> page = new PageInfo<>(companyList);
        return page;
    }

    @Override
    public void markCompany(String companyCode, String managerCode) {
        TManagerCompanyMark mark = new TManagerCompanyMark();
        mark.setCompanyCode(Integer.valueOf(companyCode));
        mark.setManagerCode(Integer.valueOf(managerCode));
        tManagerCompanyMarkMapper.insertSelective(mark);
    }

    @Override
    public List<TManagerCompanyMark> findCompanyMark(String companyCode, String managerCode) {
        TManagerCompanyMark mark = new TManagerCompanyMark();
        mark.setCompanyCode(Integer.valueOf(companyCode));
        mark.setManagerCode(Integer.valueOf(managerCode));
        return tManagerCompanyMarkMapper.findCompanyMark(mark);
    }

    @Override
    public PageInfo<CompanyInfoRsp> searchCompany(SearchCompanyReq req) {
        PageHelper.startPage(req.getPageNo(), req.getPageSize());

        String industryCode = req.getIndustryCode();
        List<String> industryCodes = null;

        if (!StringUtils.isEmpty(industryCode)) {
            industryCodes = Arrays.asList(industryCode.split(","));
        }
        List<CompanyInfoRsp> companyList = tCompanyMapper.searchCompany(req, industryCodes);
        PageInfo<CompanyInfoRsp> page = new PageInfo<>(companyList);
        return page;
    }
    @Override
    public List<CompanyInfoRsp> findHotCompany(Integer managerCode,List<String> hotCompanyIds){
        List<CompanyInfoRsp> hotCompanyList = tCompanyMapper.findHotCompany(managerCode,hotCompanyIds);
        return hotCompanyList;
    }
}
