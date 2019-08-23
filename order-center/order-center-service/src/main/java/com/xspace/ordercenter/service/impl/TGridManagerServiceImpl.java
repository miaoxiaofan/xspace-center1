package com.xspace.ordercenter.service.impl;



import com.xspace.ordercenter.entity.TGridManager;
import com.xspace.ordercenter.dao.TGridManagerMapper;
import com.xspace.ordercenter.service.TGridManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huxl
 * @description
 * @date 2019/7/30
 */
@Service
public class TGridManagerServiceImpl implements TGridManagerService {

    @Autowired
    private TGridManagerMapper tGridManagerMapper;
    @Override
    public TGridManager findByMobile(String mobile) {
        return tGridManagerMapper.findByMobile(mobile);
    }

}
