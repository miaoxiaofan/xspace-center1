package com.xspace.management.service.impl;

import com.xspace.management.service.TBusinessService;
import com.xspace.ordercenter.api.TBusinessApi;
import com.xspace.ordercenter.entity.TBusiness;
import org.springframework.beans.factory.annotation.Autowired;
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
    private TBusinessApi tBusinessApi;
    @Override
    public List<TBusiness> businessList()  throws Exception {
        return tBusinessApi.businessList();
    }
}
