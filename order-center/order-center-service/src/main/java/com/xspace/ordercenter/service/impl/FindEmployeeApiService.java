package com.xspace.ordercenter.service.impl;

import com.xspace.ordercenter.api.FindEmployeeApi;

import com.xspace.ordercenter.req.EmployeeDto;
import com.xspace.ordercenter.service.FindEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wmiao
 * @description
 * @date 2019/7/1
 */
@Service("findEmployeeApi")
public class FindEmployeeApiService implements FindEmployeeApi {

    @Autowired
    private FindEmployeeService findEmployeeService;
    @Override
    public List<EmployeeDto> findEmployeeList() {
        return findEmployeeService.findEmployeeList();
    }

    @Override
    public List<EmployeeDto> findEmployeeBy(EmployeeDto employee) {
        return findEmployeeService.findEmployeeBy(employee);
    }
}
