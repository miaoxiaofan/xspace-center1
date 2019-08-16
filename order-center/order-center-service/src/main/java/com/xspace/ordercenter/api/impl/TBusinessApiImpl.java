package com.xspace.ordercenter.api.impl;

import com.unicom.js.ibo.common.enums.BaseErrorEnum;
import com.unicom.js.ibo.common.exception.BusinessException;
import com.unicom.js.ibo.infocenter.api.TBusinessApi;
import com.unicom.js.ibo.infocenter.bean.TBusiness;
import com.unicom.js.ibo.infocenter.service.TBusinessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wmiao
 * @description
 * @date 2019/8/1
 */
@Service("tBusinessApiImpl")
public class TBusinessApiImpl implements TBusinessApi {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private TBusinessService tBusinessService;

    @Override
    public List<TBusiness> businessList() throws Exception {
        logger.info("------开始查询意向业务数据");

        List<TBusiness> result=new ArrayList<>();
        try {
            result=tBusinessService.businessList();
        }catch (Exception e){
            logger.error("系统异常",e);
            throw  new BusinessException(BaseErrorEnum.BASE_ERROR_9999);
        }
        return  result;
    }
}
