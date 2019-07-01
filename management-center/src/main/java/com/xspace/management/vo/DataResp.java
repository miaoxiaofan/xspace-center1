package com.xspace.management.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author wmiao
 * @description
 * @date 2019/3/27
 */

public class DataResp<T> implements Serializable {

    private List<T> list;

    public DataResp(List<T> list) {
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
