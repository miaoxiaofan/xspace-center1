package com.xspace.ordercenter.service.impl;

import com.xspace.ordercenter.dao.EmployeeMapper;
import com.xspace.ordercenter.entity.Employee;
import com.xspace.ordercenter.req.EmployeeDto;
import com.xspace.ordercenter.service.FindEmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

     private Logger logger = LoggerFactory.getLogger(this.getClass());

     @Autowired
     private EmployeeMapper employeeMapper;

     @Override
     public List<EmployeeDto> findEmployeeList() {
          logger.info("查询");
          return  employeeMapper.selectA();
     }

     @Override
     public List<EmployeeDto> findEmployeeBy(EmployeeDto employee) {
          logger.info("查询11");
          try {
               Thread.sleep(10000);
          } catch (InterruptedException e) {
               e.printStackTrace();
          }
          return  employeeMapper.selectA();
     }
}
