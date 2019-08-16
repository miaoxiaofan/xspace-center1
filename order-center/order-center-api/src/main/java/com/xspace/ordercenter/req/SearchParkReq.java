package com.xspace.ordercenter.req;

import java.io.Serializable;

/**
 * @author wmiao
 * @description
 * @date 2019/8/2
 */

public class SearchParkReq implements Serializable{

    private static final long serialVersionUID = 504496564842447263L;
    private Integer pageNo;
    private Integer pageSize;
    private String parkName;
    private Integer managerCode;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public Integer getManagerCode() {
        return managerCode;
    }

    public void setManagerCode(Integer managerCode) {
        this.managerCode = managerCode;
    }
}
