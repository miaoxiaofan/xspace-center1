package com.xspace.ordercenter.service;

import com.github.pagehelper.PageInfo;
import com.xspace.ordercenter.entity.TAreaInfo;

import java.util.List;

/**
 * @author wmiao
 * @description
 * @date 2019/7/29
 */

public interface CityInfoService {
    List<TAreaInfo> findCityArea(TAreaInfo bean);
    PageInfo<TAreaInfo> findCityAreaByPage(TAreaInfo bean, Integer pageNum, Integer pageSize);
}
