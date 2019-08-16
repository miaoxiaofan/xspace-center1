package com.xspace.management.service.impl;

import com.xspace.management.service.TGridManagerService;
import com.xspace.ordercenter.api.TGridManagerApi;
import com.xspace.ordercenter.bean.TGridManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author huxl
 * @description
 * @date 2019/7/30
 */
@Service
public class TGridManagerSerivceImpl implements TGridManagerService {


    @Autowired
    private TGridManagerApi tGridManagerApi;

    /**
     * 根据手机号查询用户信息
     * @param mobile
     * @return
     */
    @Override
    public TGridManager findByMobile(String mobile){
        return tGridManagerApi.findByMobile(mobile);
    }

}
