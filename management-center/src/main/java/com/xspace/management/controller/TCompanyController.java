package com.xspace.management.controller;


import com.github.pagehelper.PageInfo;
import com.xspace.commoncenter.ApiResultEntity;
import com.xspace.commoncenter.exception.BusinessException;
import com.xspace.commoncenter.utils.ApiSessionUtils;
import com.xspace.management.service.TCompanyService;
import com.xspace.management.service.TGridManagerService;
import com.xspace.ordercenter.entity.TGridManager;
import com.xspace.ordercenter.req.BuildingCompanyInfoReq;
import com.xspace.ordercenter.req.SearchCompanyReq;
import com.xspace.ordercenter.rsp.CompanyInfoRsp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wmiao
 * @description
 * @date 2019/8/1
 */
@Controller
@RequestMapping("/api/company")
public class TCompanyController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TGridManagerService tGridManagerService;
    @Autowired
    private TCompanyService tCompanyService;

    @RequestMapping(value = "/companyList.json")
    @ResponseBody
    public ApiResultEntity companyList(BuildingCompanyInfoReq req, HttpServletRequest request) {
        TGridManager gridManager = ApiSessionUtils.getUserInfoFromSession(request);
        if (null == gridManager) {
            gridManager=new TGridManager();
            gridManager.setCode(1);
            /*logger.warn("您尚未登录！");
            return ApiResultEntity.FAILURE(ApiResultEntity.NOAUTH,"您尚未登录！");*/
        }
        req.setManagerCode(String.valueOf(gridManager.getCode()));
        logger.info("查询楼宇下企业列表,  BuildingCompanyInfoReq:{}", req);

        if (StringUtils.isEmpty(req.getBuildingCode())) {
            logger.warn("楼宇编码为空");
            return ApiResultEntity.FAILURE("楼宇编码为空");
        }
        if (null == req.getPageNo()) {
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

            PageInfo<CompanyInfoRsp> pageInfo=tCompanyService.companyList(req);
            map.put("companyList", pageInfo.getList());
            map.put("totalCount", pageInfo.getTotal());
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

    @RequestMapping(value = "/searchCompany.json")
    @ResponseBody
    public ApiResultEntity searchCompany(SearchCompanyReq req, HttpServletRequest request) {
        TGridManager gridManager = ApiSessionUtils.getUserInfoFromSession(request);
        if (null == gridManager) {
            gridManager=new TGridManager();
            gridManager.setCode(1);
            /*logger.warn("您尚未登录！");
            return ApiResultEntity.FAILURE(ApiResultEntity.NOAUTH,"您尚未登录！");*/
        }
        req.setManagerCode(String.valueOf(gridManager.getCode()));
        logger.info("智能查找-查找企业,  SearchCompanyReq:{}", req);

        if (null == req.getPageNo()) {
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

            PageInfo<CompanyInfoRsp> pageInfo = tCompanyService.searchCompany(req);
            map.put("companyList", pageInfo.getList());
            map.put("totalCount", pageInfo.getTotal());
            resultEntity = getSuccessEntity(map);
        } catch (BusinessException e) {
            logger.error("智能查找-查找企业 失败,异常编码：" + e.getErrorCode() + "异常信息:" + e.getErrorMessage());
            resultEntity = ApiResultEntity.FAILURE(e.getMessage());
        } catch (Exception e) {
            logger.error("智能查找-查找企业 失败," + e);
            resultEntity = ApiResultEntity.FAILURE("系统异常");
        }
        return resultEntity;
    }

    /**
     * 查询智能热推公司
     * @param request
     * @return
     */
    @RequestMapping(value = "/findHotCompany.json")
    @ResponseBody
    public ApiResultEntity findHotCompany(HttpServletRequest request){

        TGridManager userInfo = ApiSessionUtils.getUserInfoFromSession(request);
//        TGridManager userInfo=new TGridManager();
//        userInfo.setMobile("123456");
        if (null == userInfo) {
            return ApiResultEntity.FAILURE(ApiResultEntity.NOAUTH,"您尚未登录！");
        }
        String acctNo = userInfo.getMobile();
        userInfo = tGridManagerService.findByMobile(acctNo);
        logger.info("---查询智能热推公司,----开始------入参：managerCode:{},gridCode:{}",userInfo.getCode(),userInfo.getGridCode());
        HashMap<String, Object> datas = new HashMap<>();
        Map<String, Object> queryParam = new HashMap<String, Object>();  //查询条件
        queryParam.put("managerCode", userInfo.getCode());
        List<CompanyInfoRsp> hotCompanyList = tCompanyService.findHotCompany(queryParam);
        if (null == hotCompanyList || 0 == hotCompanyList.size()) {
            datas.put("hotCompanyList", null);
            logger.info("---查询智能热推公司,入参：managerCode:{},gridCode:{},查询返回共{}条记录---",userInfo.getCode(),userInfo.getGridCode(), 0);
            return getSuccessEntity(datas);
        }
        datas.put("hotCompanyList",hotCompanyList);
        logger.info("---查询智能热推公司,入参：managerCode:{},gridCode:{},查询返回共{}条记录---",userInfo.getCode(),userInfo.getGridCode(), hotCompanyList.size());
        return getSuccessEntity(datas);
    }
}
