package com.xspace.ordercenter.service.impl;


import com.xspace.ordercenter.service.DeleteRedisKeyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author wmiao
 * @description
 * @date 2019/8/12
 */
@Service
public class DeleteRedisKeyServiceImpl implements DeleteRedisKeyService {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private RedisTemplate  redisTemplate;

    private String [] prexs={"Ibo_parkIndustryList","Ibo_buildIndustryList"};
    @Override
    public void deleteOutOfDateLKey() {
         Long   currentTime=System.currentTimeMillis();

        LOGGER.info("开始清除 redis 过期key ");
        for(String prex:prexs){
            Set<String> keys = redisTemplate.keys(prex+":*");
            if(null==keys||keys.size()==0){
                LOGGER.info("redis 命名空间为{} 的key的size 为空",prex);
                continue;
            }
            redisTemplate.delete(keys);
            LOGGER.info("清除redis 命名空间为{} 的key,  key的size:{}",prex,keys.size());
            redisTemplate.delete(keys);
        }
        LOGGER.info("清除key结束，耗时:{}ms",System.currentTimeMillis()-currentTime);
    }
}
