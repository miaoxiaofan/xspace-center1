package com.xspace.ordercenter.bean;

import java.io.Serializable;

public class TGridManager implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 编码
     */
    private Integer code;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别 0：男 1：女
     */
    private Boolean sex;

    /**
     * 地区编码
     */
    private String areaCode;

    /**
     * 地区名称
     */
    private String areaName;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 网格编码
     */
    private String gridCode;

    /**
     * 网格名称
     */
    private String gridName;

    /**
     * logo地址
     */
    private String logoSrc;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getGridCode() {
        return gridCode;
    }

    public void setGridCode(String gridCode) {
        this.gridCode = gridCode == null ? null : gridCode.trim();
    }

    public String getGridName() {
        return gridName;
    }

    public void setGridName(String gridName) {
        this.gridName = gridName == null ? null : gridName.trim();
    }

    public String getLogoSrc() {
        return logoSrc;
    }

    public void setLogoSrc(String logoSrc) {
        this.logoSrc = logoSrc == null ? null : logoSrc.trim();
    }
}