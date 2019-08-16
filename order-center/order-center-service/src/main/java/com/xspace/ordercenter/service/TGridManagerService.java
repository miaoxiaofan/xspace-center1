package com.xspace.ordercenter.service;


import com.unicom.js.ibo.usercenter.bean.TGridManager;

/**
 * @author huxl
 * @description
 * @date 2019/7/30
 */

public interface TGridManagerService {
    TGridManager findByMobile(String mobile);
}
