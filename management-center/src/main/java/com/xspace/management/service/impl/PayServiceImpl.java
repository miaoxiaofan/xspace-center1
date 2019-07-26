package com.xspace.management.service.impl;

import com.xspace.management.service.PayService;
import com.xspace.management.utils.RestUtils;
import io.netty.channel.ConnectTimeoutException;
import io.netty.handler.timeout.TimeoutException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.time.LocalTime;


/**
 * @author wmiao
 * @description
 * @date 2019/7/17
 */

@Service
public class PayServiceImpl implements PayService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private final int totalNum = 10;


    @Autowired
    private RestUtils restUtils;

    @Override
    @Retryable(value = {SocketTimeoutException.class, ConnectTimeoutException.class},maxAttempts = 3,backoff = @Backoff(delay = 1000,multiplier = 2))
    public int minGoodsnum(int num) throws Exception{
        logger.info("minGoodsnum开始"+ LocalTime.now());
        if(num <= 0){
            logger.error("数量不对11");
            throw new SocketTimeoutException("超时");
        }else if(num==1){
            throw new NullPointerException("数量2不对");
        }
        logger.info("minGoodsnum执行结束");
        return totalNum - num;
    }

    @Retryable(value = {SocketTimeoutException.class, ConnectTimeoutException.class},maxAttempts = 3,backoff = @Backoff(delay = 1000,multiplier = 2))
    @Override
    public int memberTest() {

        CloseableHttpClient httpClient= HttpClients.createDefault();
        HttpGet  httpGet=new HttpGet("http:/192.168.0.123");
        RequestConfig  requestConfig=RequestConfig.custom()
                .setConnectTimeout(1000)
                .setSocketTimeout(2000)
                .setConnectionRequestTimeout(3000)
                .build();

        long  start=0L;

        try {
            start=System.currentTimeMillis();

            httpClient.execute(httpGet);
            logger.info("连接成功");
        } catch (ConnectTimeoutException e) {
            e.printStackTrace();
        }catch (IOException e) {
            logger.info("连接失败");
            e.printStackTrace();
        }
        logger.info("连接成功，耗时{}",System.currentTimeMillis()-start);
        return 0;
    }



    @Override
    public String memberTest1()  {
        try {
            return restUtils.sendSms("http://localhost:18188/memeber/aceptTimeOutTest","name=1123");
        } catch (ConnectException e) {
            e.printStackTrace();
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
        }
        return "1";
    }

    @Override
    public String memberTest2() {
        try {
            return restUtils.sendSms("http://192.168.0.155:18188/memeber/aceptTimeOutTest","name=1123");
        } catch (ConnectException e) {
            e.printStackTrace();
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
        }
        return "1";
    }












 /*  @Recover
    public int recover(Exception e){
        logger.warn("减库存失败！！！");
        //记日志到数据库
        return totalNum;
    }*/

}
