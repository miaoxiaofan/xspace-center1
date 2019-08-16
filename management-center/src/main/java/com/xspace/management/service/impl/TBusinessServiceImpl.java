package com.xspace.management.service.impl;

import com.unicom.js.ibo.iboapi.service.TBusinessService;
import com.unicom.js.ibo.infocenter.api.TBusinessApi;
import com.unicom.js.ibo.infocenter.bean.TBusiness;
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
