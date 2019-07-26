package com.xspace.management.service.impl;

import com.xspace.management.service.MemberService;
import com.xspace.ordercenter.api.FindEmployeeApi;
import com.xspace.ordercenter.req.EmployeeDto;
import io.netty.channel.ConnectTimeoutException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.net.SocketTimeoutException;
import java.util.List;

/**
 * @author wmiao
 * @description
 * @date 2019/7/17
 */

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private FindEmployeeApi findEmployeeApi;
    @Override
    @Retryable(value = {SocketTimeoutException.class, ConnectTimeoutException.class},maxAttempts = 3,backoff = @Backoff(delay = 1000,multiplier = 2))
    public List<EmployeeDto> searchEmployee(EmployeeDto employee) {
        List<EmployeeDto> result=findEmployeeApi.findEmployeeBy(employee);

        return result;
    }
}

