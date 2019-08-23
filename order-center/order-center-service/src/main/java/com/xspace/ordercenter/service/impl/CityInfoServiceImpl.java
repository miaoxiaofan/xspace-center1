package com.xspace.ordercenter.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.xspace.ordercenter.entity.TAreaInfo;
import com.xspace.ordercenter.dao.TAreaInfoMapper;
import com.xspace.ordercenter.service.CityInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wmiao
 * @description
 * @date 2019/7/29
 */
@Service
public class CityInfoServiceImpl implements CityInfoService {

    @Autowired
    private TAreaInfoMapper tAreaInfoMapper;
    @Override
    public List<TAreaInfo> findCityArea(TAreaInfo bean) {
        return tAreaInfoMapper.findByCityCode(bean);
    }

    @Override
    public PageInfo<TAreaInfo> findCityAreaByPage(TAreaInfo bean, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        List<TAreaInfo> result=tAreaInfoMapper.findByCityCode(bean);
        PageInfo<TAreaInfo> page = new PageInfo<>(result);
        return  page;
    }
}
