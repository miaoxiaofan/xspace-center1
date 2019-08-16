package com.xspace.ordercenter.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicom.js.ibo.infocenter.dao.TParkMapper;
import com.unicom.js.ibo.infocenter.req.SearchParkReq;
import com.unicom.js.ibo.infocenter.rsp.SearchParkRsp;
import com.unicom.js.ibo.infocenter.service.TParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author huxl
 * @description
 * @date 2019/7/31
 */
@Service
public class TParkServiceImpl implements TParkService {

    @Autowired
    private TParkMapper tParkMapper;

    @Override
    public PageInfo<SearchParkRsp> findParkList(Map<String, Object> queryParam, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        List<SearchParkRsp> result=tParkMapper.findParkList(queryParam);
        PageInfo<SearchParkRsp> page = new PageInfo<>(result);
        return  page;
    }

    @Override
    public PageInfo<SearchParkRsp> searchPark(SearchParkReq req) {
        PageHelper.startPage(req.getPageNo(), req.getPageSize());

        List<SearchParkRsp> result=tParkMapper.searchPark(req);
        PageInfo<SearchParkRsp> page = new PageInfo<>(result);
        return  page;
    }
}
