package com.xspace.management.service.impl;

import com.github.pagehelper.PageInfo;
import com.unicom.js.ibo.iboapi.service.TParkService;
import com.unicom.js.ibo.infocenter.api.TParkApi;
import com.unicom.js.ibo.infocenter.req.SearchParkReq;
import com.unicom.js.ibo.infocenter.rsp.SearchParkRsp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author huxl
 * @description
 * @date 2019/7/31
 */
@Service
public class TParkSerivceImpl implements TParkService {


    @Autowired
    private TParkApi tParkApi;
    @Override
    public PageInfo<SearchParkRsp> findParkList(Map<String, Object> queryParam, Integer pageNum, Integer pageSize) {
        return tParkApi.findParkList(queryParam,pageNum,pageSize);
    }

    @Override
    public PageInfo<SearchParkRsp> searchPark(SearchParkReq req) {
        return tParkApi.searchPark(req);
    }
}
