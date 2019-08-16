package com.xspace.management.service;

import com.unicom.js.ibo.usercenter.bean.TGridManager;


/**
 * 根据手机号查询用户信息
 * @author huxl
 * @description
 * @date 2019/7/30
 */

public interface TGridManagerService {
    TGridManager findByMobile(String mobile);
}
