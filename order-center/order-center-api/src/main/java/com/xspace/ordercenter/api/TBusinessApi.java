package com.xspace.ordercenter.api;


import com.xspace.ordercenter.bean.TBusiness;

import java.util.List;

public interface TBusinessApi {
    List<TBusiness> businessList()throws Exception;
}
