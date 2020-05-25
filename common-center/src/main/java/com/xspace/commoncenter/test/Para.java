package com.xspace.commoncenter.test;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author wmiao
 * @description
 * @date 2019/8/27
 */

public class Para implements Serializable{

    @NotBlank(message = "paraId 不能为空")
    private String paraId;
    @NotBlank(message = "paraValue 不能为空")
    private String paraValue;

    public String getParaId() {
        return paraId;
    }

    public void setParaId(String paraId) {
        this.paraId = paraId;
    }

    public String getParaValue() {
        return paraValue;
    }

    public void setParaValue(String paraValue) {
        this.paraValue = paraValue;
    }
}
