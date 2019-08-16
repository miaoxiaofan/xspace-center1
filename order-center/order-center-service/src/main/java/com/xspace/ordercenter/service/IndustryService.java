package com.xspace.ordercenter.service;

import com.xspace.ordercenter.rsp.BasePercentageRsp;
import com.xspace.ordercenter.rsp.IndustryTypeRsp;

import java.util.List;

/**
 * @author wmiao
 * @description
 * @date 2019/7/30
 */

public interface IndustryService {
    List<BasePercentageRsp> parkIndustryList(String searchCode);

    List<BasePercentageRsp> buildIndustryList(String parkCode, String buildCode);

    List<IndustryTypeRsp> findIndustryType();
}
