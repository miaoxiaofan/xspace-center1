package com.xspace.management.controller;


import com.github.pagehelper.PageInfo;
import com.xspace.commoncenter.ApiResultEntity;
import com.xspace.commoncenter.exception.BusinessException;
import com.xspace.commoncenter.utils.ApiSessionUtils;
import com.xspace.management.service.TGridManagerService;
import com.xspace.management.service.TParkService;
import com.xspace.ordercenter.bean.TGridManager;
import com.xspace.ordercenter.req.SearchParkReq;
import com.xspace.ordercenter.rsp.SearchParkRsp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huxl
 * @description
 * @date 2019/7/30
 */
@Controller
@RequestMapping("/api/park")
public class TParkController extends BaseController{

    @Autowired
    private TParkService tParkService;

    @Autowired
    private TGridManagerService tGridManagerService;

    @RequestMapping(value = "/parkList.json")
    @ResponseBody
    public ApiResultEntity parkList(HttpServletRequest request, Integer pageNo, Integer pageSize){

        if (pageNo == null || pageNo < 1) {
            pageNo = 1;
        }
        if (pageSize == null || pageSize < 1) {
            pageSize = 10;
        }
        TGridManager userInfo = ApiSessionUtils.getUserInfoFromSession(request);
//        TGridManager userInfo=new TGridManager();
//        userInfo.setMobile("123456");
        if (null == userInfo) {
            return ApiResultEntity.FAILURE(ApiResultEntity.NOAUTH,"您尚未登录！");
        }
        logger.info("---根据网格经理编码和网格编码查询园区从session获取用户登录信息,入参：sessionId:{}, 用户信息userInfo:{}",request.getSession().getId(),userInfo);
        String acctNo = userInfo.getMobile();
        userInfo = tGridManagerService.findByMobile(acctNo);
        logger.info("---根据网格经理编码和网格编码查询园区,----开始------入参：pageNo:{}, pageSize:{},managerCode:{},gridCode:{}",pageNo,pageSize,userInfo.getCode(),userInfo.getGridCode());
        HashMap<String, Object> datas = new HashMap<>();
        Map<String, Object> queryParam = new HashMap<String, Object>();  //查询条件
        queryParam.put("managerCode", userInfo.getCode());
        queryParam.put("gridCode", userInfo.getGridCode());
        PageInfo<SearchParkRsp> parkList = tParkService.findParkList(queryParam, pageNo, pageSize);
        if (null == parkList || 0 == parkList.getSize()) {
            datas.put("parkList", null);
            datas.put("totalCount", 0);
            logger.info("---根据网格经理编码和网格编码查询园区,入参：pageNo:{}, pageSize:{},managerCode:{},gridCode:{},查询返回共{}条记录---",
                    pageNo, pageSize ,userInfo.getCode(),userInfo.getGridCode(),0);
            return getSuccessEntity(datas);
        }
        datas.put("parkList",parkList.getList());
        datas.put("totalCount",parkList.getTotal());
        logger.info("---根据网格经理编码和网格编码查询园区,入参：pageNo:{}, pageSize:{},managerCode:{},gridCode:{},查询返回共{}条记录---",
                pageNo, pageSize ,userInfo.getCode(),userInfo.getGridCode(),parkList.getTotal());
        return getSuccessEntity(datas);
    }


    @RequestMapping(value = "/searchPark.json")
    @ResponseBody
    public ApiResultEntity searchPark(SearchParkReq req, HttpServletRequest request) {
        TGridManager gridManager = ApiSessionUtils.getUserInfoFromSession(request);
        if (null == gridManager) {
            logger.warn("您尚未登录！");
            return ApiResultEntity.FAILURE(ApiResultEntity.NOAUTH,"您尚未登录！");
        }
        req.setManagerCode(gridManager.getCode());
        logger.info("智能查找-查找园区,  pageNo:{},pageSize:{},parkName:{},managerCode:{}", req.getPageNo(),req.getPageSize(),req.getParkName(),gridManager.getCode());
        if (null ==req.getPageNo()) {
            logger.warn("分页起始页码为空");
            return ApiResultEntity.FAILURE("分页起始页码为空");
        }
        if (null == req.getPageSize()) {
            logger.warn("每页数目为空");
            return ApiResultEntity.FAILURE("每页数目为空");
        }

        ApiResultEntity resultEntity;
        HashMap<String, Object> map = new HashMap<>();
        try {

            PageInfo<SearchParkRsp> pageInfo = tParkService.searchPark(req);
            map.put("parkList", pageInfo.getList());
            map.put("totalCount", pageInfo.getTotal());
            resultEntity = getSuccessEntity(map);
        } catch (BusinessException e) {
            logger.error("智能查找-查找园区 失败,异常编码：" + e.getErrorCode() + "异常信息:" + e.getErrorMessage());
            resultEntity = ApiResultEntity.FAILURE(e.getMessage());
        } catch (Exception e) {
            logger.error("智能查找-查找园区 失败," + e);
            resultEntity = ApiResultEntity.FAILURE("系统异常");
        }
        return resultEntity;
    }



}
