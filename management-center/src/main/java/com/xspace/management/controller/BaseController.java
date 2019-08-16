package com.xspace.management.controller;

import com.xspace.commoncenter.ApiResultEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class BaseController {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 获取成功返回实体
	 * 
	 * @param datas
	 * @return
	 */
	protected ApiResultEntity getSuccessEntity(HashMap<String, Object> datas) {
		if (logger.isDebugEnabled()) {
			logger.debug("请求成功处理返回数据:" + datas);
		}
		ApiResultEntity apiResultEntity = new ApiResultEntity();
		apiResultEntity.setCode(ApiResultEntity.SUCCESS);
		apiResultEntity.setDatas(datas);
		return apiResultEntity;
	}
	

	/**
     * 获取成功返回实体
     * 
     * @return
     */
    protected ApiResultEntity getSuccessEntity() {
        ApiResultEntity apiResultEntity = new ApiResultEntity();
        apiResultEntity.setCode(ApiResultEntity.SUCCESS);
        HashMap<String, Object> datas = new HashMap<>();
        datas.put("success", "操作成功");
        apiResultEntity.setDatas(datas);
        return apiResultEntity;
    }
    
    
    protected ApiResultEntity getErrorEntity(String error) {
        HashMap<String, Object> datas = new HashMap<>();
        ApiResultEntity apiResultEntity = new ApiResultEntity();
        apiResultEntity.setCode(ApiResultEntity.FAIL);
        datas.put("error", error);
        apiResultEntity.setDatas(datas);
        return apiResultEntity;
    }


}
