package com.xspace.ordercenter.service.impl;

import com.xspace.ordercenter.dao.TManagerCompanyRecommendMapper;
import com.xspace.ordercenter.service.TManagerCompanyRecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author huxl
 * @description
 * @date 2019/8/5
 */
@Service
public class TManagerCompanyRecommendServiceImpl implements TManagerCompanyRecommendService {

    @Autowired
    private TManagerCompanyRecommendMapper tManagerCompanyRecommendMapper;

    @Override
    public ArrayList<String> findHotCompanyIds(Map<String, Object> queryParam) {
        ArrayList<String> hotCompanyIds = tManagerCompanyRecommendMapper.findHotCompanyIds(queryParam);
        return hotCompanyIds;
    }

}
