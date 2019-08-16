package com.xspace.management.service.impl;

import com.github.pagehelper.PageInfo;

import com.xspace.management.service.TestService;
import com.xspace.ordercenter.api.CityInfoApi;
import com.xspace.ordercenter.bean.TAreaInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wmiao
 * @description
 * @date 2019/7/29
 */
@Service
public class TestSerivceImpl implements TestService {


    @Autowired
    private CityInfoApi cityInfoApi;
    @Override
    public List<TAreaInfo> findCityArea(TAreaInfo bean) {
        return cityInfoApi.findCityArea(bean);
    }

    @Override
    public PageInfo<TAreaInfo> findCityAreaByPage(TAreaInfo bean, Integer pageNum, Integer pageSize) {
        return cityInfoApi.findCityAreaByPage(bean,pageNum,pageSize);
    }
}
