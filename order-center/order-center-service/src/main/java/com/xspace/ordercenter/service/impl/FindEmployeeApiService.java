package com.xspace.ordercenter.service.impl;

import com.xspace.ordercenter.api.FindEmployeeApi;
import com.xspace.ordercenter.entity.Employee;
import com.xspace.ordercenter.service.FindEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author wmiao
 * @description
 * @date 2019/7/1
 */

public class FindEmployeeApiService implements FindEmployeeApi {

    @Autowired
    private FindEmployeeService findEmployeeService;
    @Override
    public List<Employee> findEmployeeList() {
        return findEmployeeService.findEmployeeList();
    }

    @Override
    public List<Employee> findEmployeeBy(Employee employee) {
        return findEmployeeService.findEmployeeBy(employee);
    }
}
