package com.xspace.ordercenter.api;

import com.unicom.js.ibo.infocenter.bean.TBusiness;

import java.util.List;

public interface TBusinessApi {
    List<TBusiness> businessList()throws Exception;
}
