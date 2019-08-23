package com.xspace.ordercenter.service.impl;


import com.xspace.ordercenter.entity.TBusiness;
import com.xspace.ordercenter.dao.TBusinessMapper;
import com.xspace.ordercenter.service.TBusinessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wmiao
 * @description
 * @date 2019/8/1
 */
@Service
public class TBusinessServiceImpl implements TBusinessService {
    @Autowired
    private TBusinessMapper tBusinessMapper;

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Cacheable(value = "Ibo_BusinessType", key = "1", unless = "#result eq null ")
    @Override
    public List<TBusiness> businessList() {
        LOGGER.info("数据库查询意向业务分类数据");
        return tBusinessMapper.selectAll();
    }
}
