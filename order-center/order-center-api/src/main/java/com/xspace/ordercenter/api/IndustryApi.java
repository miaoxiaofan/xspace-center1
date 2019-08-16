package com.xspace.ordercenter.api;


import com.unicom.js.ibo.infocenter.rsp.BasePercentageRsp;
import com.unicom.js.ibo.infocenter.rsp.IndustryTypeRsp;

import java.util.List;

/**
 * @author wmiao
 * @description
 * @date 2019/7/30
 */

public interface IndustryApi {

    List<BasePercentageRsp> parkIndustryList(String searchCode) throws Exception;

    List<BasePercentageRsp> buildIndustryList(String parkCode, String buildCode) throws Exception;

    List<IndustryTypeRsp> findIndustryType() throws Exception;
}
