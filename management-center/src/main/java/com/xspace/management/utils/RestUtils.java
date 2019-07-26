/*
 * 文 件 名:  RestUtils
 * 版    权:  AsiaInfo Technologies (Nanjing), Inc. Copyright 1993-2016,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  gejun
 * 修改时间:  2017年08月14日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.xspace.management.utils;


import com.alibaba.fastjson.JSONObject;

import io.netty.channel.ConnectTimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * RestUtils rest服务调用工具类
 *
 * @author gejun
 * @version [版本号, 2017年08月14日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Service("restUtils")
public class RestUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestUtils.class);

    /**
     * 连接超时时间
     */
    public static final int CONNECT_TIME_OUT = 10000;
    /**
     * 读取超时时间
     */
    public static final int READ_TIME_OUT = 10000;

    private RestTemplate template;

    public RestUtils(RestTemplateBuilder builder) {
        template = builder.setConnectTimeout(CONNECT_TIME_OUT).setReadTimeout(READ_TIME_OUT).build();
    }


    public Map<String, Object> postForFrom(String urlAddress, String servicePath, Map<String, Object> reqMap) {
        String url = urlAddress + servicePath;
        LOGGER.warn("请求路径：{}", url);
        // 拼装请求参数
        JSONObject json = new JSONObject(reqMap);
        ResponseEntity<Map> responseEntity = template.exchange(url, HttpMethod.POST, null, Map.class, json.toString());
        checkResponse(responseEntity);

        Map<String, Object> response = (Map<String, Object>) responseEntity.getBody();
        LOGGER.warn("返回结果getBody:", response.toString());

        return response;
    }

    /**
     * 检查respon
     *
     * @param responseEntity
     */
    private void checkResponse(ResponseEntity<?> responseEntity) {
        if (hasError(responseEntity.getStatusCode())) {
            LOGGER.info("rest调用出错: " + responseEntity.toString());
        }
    }

    /**
     * 调用是否出错
     *
     * @param statusCode
     * @return
     */
    private static boolean hasError(HttpStatus statusCode) {
        return ((statusCode.series() == HttpStatus.Series.CLIENT_ERROR)
                || (statusCode.series() == HttpStatus.Series.SERVER_ERROR));
    }




    /**
     * 发送短信
     * 
     * @param url          服务地址
     * @param sendSmsReqVo 请求参数
     * @return
     */
    @Retryable(value = {SocketTimeoutException.class, ConnectException.class},maxAttempts = 3,backoff = @Backoff(delay = 1000,multiplier = 2))
    public String sendSms(String url, String sendSmsReqVo) throws ConnectException,SocketTimeoutException  {
        LOGGER.info("rest调用 " );
        return template.postForObject(url, sendSmsReqVo, String.class);
    }



}
