package com.xspace.ordercenter.api;

import com.github.pagehelper.PageInfo;
import com.unicom.js.ibo.infocenter.req.SearchParkReq;
import com.unicom.js.ibo.infocenter.rsp.SearchParkRsp;

import java.util.Map;

/**
 * @author huxl
 * @description
 * @date 2019/7/31
 */

public interface TParkApi {

    /**
     * test
     * @param queryParam
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<SearchParkRsp> findParkList(Map<String, Object> queryParam, Integer pageNum, Integer pageSize);

    PageInfo<SearchParkRsp> searchPark(SearchParkReq req);
}
