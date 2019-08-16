package com.xspace.ordercenter.api;


import com.xspace.ordercenter.bean.TGridManager;

/**
 * @author huxl
 * @description
 * @date 2019/7/30
 */

public interface TGridManagerApi {

    /**
     * 根据手机号查询用户信息
     * @param mobile
     * @return
     */
    TGridManager findByMobile(String mobile);
}
