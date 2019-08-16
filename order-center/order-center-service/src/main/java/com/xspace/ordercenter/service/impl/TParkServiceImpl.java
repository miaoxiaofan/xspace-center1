package com.xspace.ordercenter.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xspace.ordercenter.dao.TParkMapper;
import com.xspace.ordercenter.req.SearchParkReq;
import com.xspace.ordercenter.rsp.SearchParkRsp;
import com.xspace.ordercenter.service.TParkService;
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
