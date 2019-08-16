package com.xspace.management.controller;


import com.unicom.js.ibo.common.ApiResultEntity;
import com.unicom.js.ibo.common.utils.ApiSessionUtils;
import com.unicom.js.ibo.iboapi.service.TGridManagerService;
import com.unicom.js.ibo.usercenter.bean.TGridManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @author huxl
 * @description
 * @date 2019/7/30
 */
@Controller
@RequestMapping("/api/manager")
public class TGridManagerController extends BaseController{

    @Autowired
    private TGridManagerService tGridManagerService;

    @RequestMapping(value = "/info.json")
    @ResponseBody
    public ApiResultEntity findUserInfo(HttpServletRequest request){
        TGridManager userInfo = ApiSessionUtils.getUserInfoFromSession(request);
//        TGridManager userInfo=new TGridManager();
//        userInfo.setMobile("123456");
        if (null == userInfo) {
            return ApiResultEntity.FAILURE(ApiResultEntity.NOAUTH,"您尚未登录！");
        }
        logger.info("用户账号信息:userInfo:{}", userInfo);
        String acctNo = userInfo.getMobile();
        userInfo = tGridManagerService.findByMobile(acctNo);
        HashMap<String, Object> datas = new HashMap<>();
        datas.put("areaName", userInfo.getAreaName());
        datas.put("gridCode", userInfo.getGridCode());
        datas.put("gridName", userInfo.getGridName());
        datas.put("logoSrc", userInfo.getLogoSrc());
        datas.put("name", userInfo.getName());
        return getSuccessEntity(datas);
    }
}
