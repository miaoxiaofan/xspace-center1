package com.xspace.management.service;

import com.xspace.ordercenter.req.EmployeeDto;

import java.util.List;

/**
 * @author wmiao
 * @description
 * @date 2019/7/17
 */

public interface MemberService {

    List<EmployeeDto> searchEmployee(EmployeeDto employee);
}

