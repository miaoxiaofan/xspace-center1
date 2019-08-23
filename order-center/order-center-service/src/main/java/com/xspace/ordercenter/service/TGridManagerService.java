package com.xspace.ordercenter.service;


import com.xspace.ordercenter.entity.TGridManager;

/**
 * @author huxl
 * @description
 * @date 2019/7/30
 */

public interface TGridManagerService {
    TGridManager findByMobile(String mobile);
}
