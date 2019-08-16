package com.xspace.management.controller;

import com.github.pagehelper.PageInfo;
import com.xspace.commoncenter.ApiResultEntity;
import com.xspace.commoncenter.exception.BusinessException;
import com.xspace.management.service.TBuildingService;
import com.xspace.ordercenter.rsp.BuildingIndustryStatRsp;
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
@RequestMapping("/api/building")
public class TBuildingController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TBuildingService tBuildingService;

    @RequestMapping(value = "/buildingList.json")
    @ResponseBody
    public ApiResultEntity buildingList(Integer pageNo, Integer pageSize, String parkCode) {
        logger.info("查询园区下楼宇列表,  pageNo:{}，pageSize：{},parkCode:{}", pageNo, pageSize, parkCode);
        if (null ==pageNo) {
            logger.warn("分页起始页码为空");
            return ApiResultEntity.FAILURE("分页起始页码为空");
        }
        if (null == pageSize) {
            logger.warn("每页数目为空");
            return ApiResultEntity.FAILURE("每页数目为空");
        }
        ApiResultEntity resultEntity;
        HashMap<String, Object> map = new HashMap<>();
        try {
            PageInfo<BuildingIndustryStatRsp> PageInfo=tBuildingService.buildingList(pageNo, pageSize, parkCode);
            map.put("buildingList",PageInfo.getList());
            map.put("totalCount", PageInfo.getTotal());
            resultEntity = getSuccessEntity(map);
        } catch (BusinessException e) {
            logger.error("查询园区下楼宇列表 失败,异常编码：" + e.getErrorCode() + "异常信息:" + e.getErrorMessage());
            resultEntity = ApiResultEntity.FAILURE(e.getMessage());
        } catch (Exception e) {
            logger.error("查询园区下楼宇列表 失败," + e);
            resultEntity = ApiResultEntity.FAILURE("系统异常");
        }
        return resultEntity;
    }
}