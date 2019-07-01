package com.xspace.ordercenter.api;

import com.xspace.ordercenter.entity.Employee;

import java.util.List;

/**
 * @author wmiao
 * @description
 * @date 2019/7/1
 */

public interface FindEmployeeApi {
    List<Employee> findEmployeeList();
    List<Employee> findEmployeeBy(Employee employee);
}
