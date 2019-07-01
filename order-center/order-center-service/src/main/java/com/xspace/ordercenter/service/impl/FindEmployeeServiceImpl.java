package com.xspace.ordercenter.service.impl;

import com.xspace.ordercenter.dao.EmployeeMapper;
import com.xspace.ordercenter.entity.Employee;
import com.xspace.ordercenter.service.FindEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wmiao
 * @description
 * @date 2019/7/1
 */
@Service
public class FindEmployeeServiceImpl implements FindEmployeeService {



     @Autowired
     private EmployeeMapper employeeMapper;
     @Override
     public List<Employee> findEmployeeList() {
          return  employeeMapper.selectAll();
     }

     @Override
     public List<Employee> findEmployeeBy(Employee employee) {
          return null;
     }
}
