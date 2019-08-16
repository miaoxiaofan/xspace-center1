package com.xspace.management.controller;


import com.xspace.commoncenter.ApiResultEntity;
import com.xspace.commoncenter.exception.BusinessException;
import com.xspace.management.service.TBusinessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * @author wmiao
 * @description
 * @date 2019/8/1
 */
@Controller
@RequestMapping("/api/business")
public class TBusinessController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TBusinessService tBusinessService;
    @RequestMapping(value = "/businessList.json")
    @ResponseBody
    public ApiResultEntity parkIndustryList()  {
        logger.info("意向业务数据查询");
        ApiResultEntity resultEntity;
        HashMap<String,Object> map=new HashMap<>();

        try{
            map.put("businessList",tBusinessService.businessList());
            resultEntity=getSuccessEntity(map);
        }catch (BusinessException e){
            logger.error("意向业务数据查询失败,"+e);
            resultEntity=ApiResultEntity.FAILURE(e.getMessage());
        }catch (Exception e){
            logger.error("意向业务数据查询失败,"+e);
            resultEntity=ApiResultEntity.FAILURE("系统异常");
        }
        return  resultEntity;
    }
}
