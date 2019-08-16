package com.xspace.management.controller;


import com.unicom.js.ibo.common.ApiResultEntity;
import com.unicom.js.ibo.common.exception.BusinessException;
import com.unicom.js.ibo.iboapi.service.IndustryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * @author wmiao
 * @description
 * @date 2019/7/30
 */
@Controller
@RequestMapping("/api/industry")
public class IndustryController  extends BaseController{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private IndustryService  industryService;

    @RequestMapping(value = "/parkIndustryList.json")
    @ResponseBody
    public ApiResultEntity parkIndustryList(String parkCode)  {
        logger.info("园区行业分类列表查询,parkCode:{}",parkCode);
        ApiResultEntity resultEntity;
        HashMap<String,Object> map=new HashMap<>();
        if(StringUtils.isEmpty(parkCode)){
            logger.warn("园区编码为空");
            return ApiResultEntity.FAILURE("园区编码为空");
        }
        try{
             map.put("parkIndustryList",industryService.parkIndustryList(parkCode));
             resultEntity=getSuccessEntity(map);
         }catch (BusinessException e){
            logger.error("园区行业分类列表查询失败 ,异常编码："+e.getErrorCode()+"异常信息:"+e.getErrorMessage());
            resultEntity=ApiResultEntity.FAILURE(e.getMessage());
        }catch (Exception e){
             logger.error("园区行业分类列表查询失败,"+e);
            resultEntity=ApiResultEntity.FAILURE("系统异常");
         }
        return  resultEntity;
    }

    @RequestMapping(value = "/buildIndustryList.json")
    @ResponseBody
    public ApiResultEntity buildIndustryList(String parkCode,String buildCode)  {
        logger.info("楼宇行业分类列表查询,parkCode:{},buildCode:{}",parkCode,buildCode);
        ApiResultEntity resultEntity;
        HashMap<String,Object> map=new HashMap<>();
        if(StringUtils.isEmpty(parkCode)){
            logger.warn("园区编码为空");
            return ApiResultEntity.FAILURE("园区编码为空");
        }
        if(StringUtils.isEmpty(buildCode)){
            logger.warn("楼宇编码为空");
            return ApiResultEntity.FAILURE("楼宇编码为空");
        }
        try{
            map.put("buildIndustryList",industryService.buildIndustryList(parkCode,buildCode));
            resultEntity=getSuccessEntity(map);
        }catch (BusinessException e){
            logger.error("园区行业分类列表查询 失败,"+e);
            resultEntity=ApiResultEntity.FAILURE(e.getMessage());
        }catch (Exception e){
            logger.error("园区行业分类列表查询 失败,"+e);
            resultEntity=ApiResultEntity.FAILURE("系统异常");
        }
        return  resultEntity;
    }

    @RequestMapping(value = "/findIndustryType.json")
    @ResponseBody
    public ApiResultEntity findIndustryType()  {
        logger.info("行业分类数据查询,");

        ApiResultEntity resultEntity;
        HashMap<String,Object> map=new HashMap<>();
        try{
            map.put("industryTypeList",industryService.findIndustryType());
            resultEntity=getSuccessEntity(map);
        }catch (BusinessException e){
            logger.error("行业分类数据查询 失败,异常编码："+e.getErrorCode()+"异常信息:"+e.getErrorMessage());
            resultEntity=ApiResultEntity.FAILURE(e.getMessage());
        }
        catch (Exception e){
            logger.error("行业分类数据查询 失败,"+e);
            resultEntity=ApiResultEntity.FAILURE("系统异常");
        }
        return  resultEntity;
    }

}
