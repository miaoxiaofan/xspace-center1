package com.xspace.management.controller;

import com.github.pagehelper.PageInfo;
import com.unicom.js.ibo.usercenter.bean.TAreaInfo;
import com.xspace.management.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author wmiao
 * @description
 * @date 2019/7/29
 */
@Controller
@RequestMapping("/test")
public class TestController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());



    @Autowired
    private TestService testService;

    @RequestMapping(value = "/findCityInfo")
    @ResponseBody
    public List<TAreaInfo> findCityInfo(TAreaInfo bean)  {
        return  testService.findCityArea( bean);
    }

    @RequestMapping(value = "/findCityInfoPage")
    @ResponseBody
    public PageInfo<TAreaInfo> findCityInfoPage(TAreaInfo bean, Integer pageNum, Integer pageSize)  {
        return  testService.findCityAreaByPage( bean,pageNum,pageSize);
    }
}
