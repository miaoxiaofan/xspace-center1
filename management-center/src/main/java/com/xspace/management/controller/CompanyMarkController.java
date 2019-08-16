package com.xspace.management.controller;

import com.xspace.commoncenter.ApiResultEntity;
import com.xspace.commoncenter.exception.BusinessException;
import com.xspace.commoncenter.utils.ApiSessionUtils;
import com.xspace.management.service.TCompanyService;
import com.xspace.ordercenter.bean.TGridManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @author wmiao
 * @description企业拜访打卡
 * @date 2019/8/2
 */
@Controller
@RequestMapping("/api/companyMark")
public class CompanyMarkController  extends BaseController{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TCompanyService tCompanyService;


    @RequestMapping(value = "/markCompany.json")
    @ResponseBody
    public ApiResultEntity markCompany(String companyCode, HttpServletRequest request)  {

        TGridManager gridManager =  ApiSessionUtils.getUserInfoFromSession(request);
        if(null==gridManager){
            logger.warn("您尚未登录！");
            return ApiResultEntity.FAILURE(ApiResultEntity.NOAUTH,"您尚未登录！");
        }

        logger.info("企业拜访打卡 ,companyCode:{},managerCode:{}",companyCode,gridManager.getCode());
        ApiResultEntity resultEntity;
        HashMap<String,Object> map=new HashMap<>();
        if(StringUtils.isEmpty(companyCode)){
            logger.warn("企业编码为空");
            return ApiResultEntity.FAILURE("企业编码为空");
        }

        try{
            String managerCode=gridManager.getCode().toString();
            map.put("data",tCompanyService.markCompany(companyCode,managerCode));
            resultEntity=getSuccessEntity(map);
        }catch (BusinessException e){
            logger.error("企业拜访打卡失败 ,异常编码："+e.getErrorCode()+",异常信息:"+e.getErrorMessage());
            resultEntity=ApiResultEntity.FAILURE(e.getMessage());
        }catch (Exception e){
            logger.error("企业拜访打卡失败,"+e);
            resultEntity=ApiResultEntity.FAILURE("系统异常");
        }
        return  resultEntity;
    }
}
