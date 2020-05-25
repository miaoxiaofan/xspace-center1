package com.xspace.commoncenter.test;

import java.io.Serializable;
import java.util.List;

/**
 * @author wmiao
 * @description
 *
 * @date 2019/8/26
 */

public class CardDataQryReqMsg implements Serializable{


    private String city;
    private String numId;
    private String cardType;
    private String channelType;
    private String cardUseType;
    private String reDoTag;
    private String iccid;
    private String oldIccid;
    private String procId;
    private String activeId;
    private String province;
    private String district;
    private String opeSysType;
    private String busiType;
    private String userType;
    private String operatorId;
    private String channelId;

    private List<Para> para;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNumId() {
        return numId;
    }

    public void setNumId(String numId) {
        this.numId = numId;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getCardUseType() {
        return cardUseType;
    }

    public void setCardUseType(String cardUseType) {
        this.cardUseType = cardUseType;
    }

    public String getReDoTag() {
        return reDoTag;
    }

    public void setReDoTag(String reDoTag) {
        this.reDoTag = reDoTag;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getOldIccid() {
        return oldIccid;
    }

    public void setOldIccid(String oldIccid) {
        this.oldIccid = oldIccid;
    }

    public String getProcId() {
        return procId;
    }

    public void setProcId(String procId) {
        this.procId = procId;
    }

    public String getActiveId() {
        return activeId;
    }

    public void setActiveId(String activeId) {
        this.activeId = activeId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getOpeSysType() {
        return opeSysType;
    }

    public void setOpeSysType(String opeSysType) {
        this.opeSysType = opeSysType;
    }

    public String getBusiType() {
        return busiType;
    }

    public void setBusiType(String busiType) {
        this.busiType = busiType;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public List<Para> getPara() {
        return para;
    }

    public void setPara(List<Para> para) {
        this.para = para;
    }
}
