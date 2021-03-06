package com.xspace.management.service;

import com.xspace.ordercenter.rsp.BasePercentageRsp;
import com.xspace.ordercenter.rsp.IndustryTypeRsp;

import java.util.List;

/**
 * @author wmiao
 * @description
 * @date 2019/7/30
 */

public interface IndustryService {
    List<BasePercentageRsp> parkIndustryList(String searchCode) throws Exception;
    List<BasePercentageRsp> buildIndustryList(String parkCode, String buildCode)throws Exception;
    List<IndustryTypeRsp> findIndustryType() throws Exception;
}
