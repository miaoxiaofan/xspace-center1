package com.xspace.ordercenter.bean;

import java.io.Serializable;

public class TIndustryType implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 行业编码
     */
    private Byte code;

    /**
     * 行业名称
     */
    private String name;

    /**
     * 父类编码
     */
    private Byte parentCode;

    /**
     * 分级，从1开始
     */
    private Integer level;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getCode() {
        return code;
    }

    public void setCode(Byte code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getParentCode() {
        return parentCode;
    }

    public void setParentCode(Byte parentCode) {
        this.parentCode = parentCode;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}