package com.xspace.commoncenter.test;

import io.swagger.annotations.ApiModelProperty;
import net.sf.jsqlparser.statement.update.Update;

import javax.validation.constraints.NotEmpty;
import javax.validation.groups.Default;

/**
 * @author wmiao
 * @description
 * @date 2019/8/28
 */



public class SimpleBean {
    @ApiModelProperty()
    private String  name;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
