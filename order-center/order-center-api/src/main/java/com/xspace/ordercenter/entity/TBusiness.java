package com.xspace.ordercenter.entity;

import java.io.Serializable;

public class TBusiness implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 业务编码
     */
    private Byte code;

    /**
     * 业务名称
     */
    private String name;

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
}