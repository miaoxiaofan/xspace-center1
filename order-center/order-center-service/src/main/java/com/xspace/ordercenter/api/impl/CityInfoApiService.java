package com.xspace.ordercenter.api.impl;

import com.github.pagehelper.PageInfo;

import com.xspace.ordercenter.api.CityInfoApi;
import com.xspace.ordercenter.entity.Employee;
import com.xspace.ordercenter.entity.TAreaInfo;
import com.xspace.ordercenter.kafka.KafkaProducer;
import com.xspace.ordercenter.service.CityInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wmiao
 * @description
 * @date 2019/7/29
 */
@Service
public class CityInfoApiService implements CityInfoApi {

    private Logger logger = LoggerFactory.getLogger(CityInfoApiService.class);

    @Autowired
    private CityInfoService cityInfoService;

    @Autowired
    private KafkaProducer kafkaProducer;
    @Override
    public List<TAreaInfo> findCityArea(TAreaInfo bean) {
        logger.info("开始查询");
        List<TAreaInfo>  result=null;
        try {
            result=  cityInfoService.findCityArea(bean);
        }catch (Exception e){
            logger.error("系统"+e);
        }
       return result;
    }

    @Override
    public PageInfo<TAreaInfo> findCityAreaByPage(TAreaInfo bean, Integer pageNum, Integer pageSize) {
        logger.info("开始查询 分页查询");
        PageInfo<TAreaInfo>   result=null;
        try {
            result=  cityInfoService.findCityAreaByPage(bean,pageNum,pageSize);
        }catch (Exception e){
            logger.error("系统"+e);
        }
        return result;
    }

    @Override
    public void saveEmployee(Employee employee) {
        try {
            kafkaProducer.kafkaSend(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
