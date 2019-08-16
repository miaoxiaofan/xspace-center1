package com.xspace.management.service.impl;

import com.unicom.js.ibo.iboapi.service.IndustryService;
import com.unicom.js.ibo.infocenter.api.IndustryApi;
import com.unicom.js.ibo.infocenter.rsp.BasePercentageRsp;
import com.unicom.js.ibo.infocenter.rsp.IndustryTypeRsp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wmiao
 * @description
 * @date 2019/7/30
 */

@Service
public class IndustryServiceImpl implements IndustryService {


    @Autowired
    private IndustryApi industryApi;

    @Override
    public List<BasePercentageRsp> parkIndustryList(String searchCode) throws Exception {

        return industryApi.parkIndustryList(searchCode);
    }

    @Override
    public List<BasePercentageRsp> buildIndustryList(String parkCode,String buildCode)throws Exception {
        return industryApi.buildIndustryList(parkCode, buildCode);
    }

    @Override
    public List<IndustryTypeRsp> findIndustryType() throws Exception {
        return industryApi.findIndustryType();
    }
}
