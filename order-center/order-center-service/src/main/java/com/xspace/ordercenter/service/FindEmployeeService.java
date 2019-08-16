package com.xspace.ordercenter.service;


import com.xspace.ordercenter.req.EmployeeDto;

import java.util.List;

/**
 * @author wmiao
 * @description
 * @date 2019/7/1
 */

public interface FindEmployeeService  {

     List<EmployeeDto> findEmployeeList()  ;

     List<EmployeeDto> findEmployeeBy(EmployeeDto employee);

}
