package com.xspace.ordercenter.service;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author huxl
 * @description
 * @date 2019/8/5
 */

public interface TManagerCompanyRecommendService {
    public ArrayList<String> findHotCompanyIds(Map<String, Object> queryParam);
}
