package com.xspace.ordercenter.api.impl;

import com.unicom.js.ibo.common.enums.BaseErrorEnum;
import com.unicom.js.ibo.common.exception.BusinessException;
import com.unicom.js.ibo.usercenter.api.TGridManagerApi;
import com.unicom.js.ibo.usercenter.bean.TGridManager;
import com.unicom.js.ibo.usercenter.service.TGridManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author huxl
 * @description
 * @date 2019/7/30
 */
@Service("tGridManagerApiService")
public class TGridManagerApiService implements TGridManagerApi {

    private Logger logger = LoggerFactory.getLogger(TGridManagerApiService.class);

    @Autowired
    private TGridManagerService tGridManagerService;
    @Override
    public TGridManager findByMobile(String mobile) {
        logger.info("开始根据手机号查询网格经理用户信息：mobile:{}",mobile);
        TGridManager tGridManager=new TGridManager();
        try {
            tGridManager=  tGridManagerService.findByMobile(mobile);
        }catch (Exception e){
            logger.error("根据手机号查询网格经理用户信息系统异常"+e);
            throw new BusinessException(BaseErrorEnum.BASE_ERROR_9999);
        }
       return tGridManager;
    }

}
