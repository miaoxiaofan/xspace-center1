package com.xspace.management.service;

import com.github.pagehelper.PageInfo;
import com.unicom.js.ibo.usercenter.bean.TAreaInfo;

import java.util.List;

/**
 * @author wmiao
 * @description
 * @date 2019/7/29
 */


public interface TestService {

    List<TAreaInfo> findCityArea(TAreaInfo bean);
    PageInfo<TAreaInfo> findCityAreaByPage(TAreaInfo bean, Integer pageNum, Integer pageSize);
}
