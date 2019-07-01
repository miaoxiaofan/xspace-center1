package com.xspace.ordercenter.service;

import com.xspace.ordercenter.api.FindEmployeeApi;
import com.xspace.ordercenter.entity.Employee;

import java.util.List;

/**
 * @author wmiao
 * @description
 * @date 2019/7/1
 */

public interface FindEmployeeService  {

     List<Employee> findEmployeeList()  ;

     List<Employee> findEmployeeBy(Employee employee);

}
