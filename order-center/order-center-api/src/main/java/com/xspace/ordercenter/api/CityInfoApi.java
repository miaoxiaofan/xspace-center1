package com.xspace.ordercenter.api;

import com.github.pagehelper.PageInfo;
import com.xspace.ordercenter.bean.TAreaInfo;

import java.util.List;

/**
 * @author wmiao
 * @description
 * @date 2019/7/29
 */

public interface CityInfoApi {

    /**
     * test
     * @param bean
     * @return
     */
    List<TAreaInfo>  findCityArea(TAreaInfo bean);
    PageInfo<TAreaInfo> findCityAreaByPage(TAreaInfo bean, Integer pageNum, Integer pageSize);
}
