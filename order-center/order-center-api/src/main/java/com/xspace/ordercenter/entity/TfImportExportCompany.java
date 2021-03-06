package com.xspace.ordercenter.entity;

import java.io.Serializable;
import java.util.Date;

public class TfImportExportCompany implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tf_import_export_company.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tf_import_export_company.stat_date
     *
     * @mbg.generated
     */
    private String statDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tf_import_export_company.gmt_create
     *
     * @mbg.generated
     */
    private Date gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tf_import_export_company.city_code
     *
     * @mbg.generated
     */
    private String cityCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tf_import_export_company.activity_id
     *
     * @mbg.generated
     */
    private String activityId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tf_import_export_company.stock_id
     *
     * @mbg.generated
     */
    private String stockId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tf_import_export_company.expend_type
     *
     * @mbg.generated
     */
    private String expendType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tf_import_export_company.inventory_a_amount
     *
     * @mbg.generated
     */
    private Integer inventoryAAmount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tf_import_export_company.inventory_a_price
     *
     * @mbg.generated
     */
    private Integer inventoryAPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tf_import_export_company.inventory_a_total
     *
     * @mbg.generated
     */
    private Integer inventoryATotal;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tf_import_export_company.make_b_amount
     *
     * @mbg.generated
     */
    private Integer makeBAmount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tf_import_export_company.make_b_price
     *
     * @mbg.generated
     */
    private Integer makeBPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tf_import_export_company.make_b_total
     *
     * @mbg.generated
     */
    private Integer makeBTotal;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tf_import_export_company.send_c_amount
     *
     * @mbg.generated
     */
    private Integer sendCAmount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tf_import_export_company.send_c_price
     *
     * @mbg.generated
     */
    private Integer sendCPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tf_import_export_company.send_c_total
     *
     * @mbg.generated
     */
    private Integer sendCTotal;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tf_import_export_company.expire_d_amount
     *
     * @mbg.generated
     */
    private Integer expireDAmount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tf_import_export_company.expire_d_price
     *
     * @mbg.generated
     */
    private Integer expireDPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tf_import_export_company.expire_d_total
     *
     * @mbg.generated
     */
    private Integer expireDTotal;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tf_import_export_company.inventory_e_amount
     *
     * @mbg.generated
     */
    private Integer inventoryEAmount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tf_import_export_company.inventory_e_price
     *
     * @mbg.generated
     */
    private Integer inventoryEPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tf_import_export_company.inventory_e_total
     *
     * @mbg.generated
     */
    private Integer inventoryETotal;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tf_import_export_company
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tf_import_export_company.id
     *
     * @return the value of tf_import_export_company.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tf_import_export_company.id
     *
     * @param id the value for tf_import_export_company.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tf_import_export_company.stat_date
     *
     * @return the value of tf_import_export_company.stat_date
     *
     * @mbg.generated
     */
    public String getStatDate() {
        return statDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tf_import_export_company.stat_date
     *
     * @param statDate the value for tf_import_export_company.stat_date
     *
     * @mbg.generated
     */
    public void setStatDate(String statDate) {
        this.statDate = statDate == null ? null : statDate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tf_import_export_company.gmt_create
     *
     * @return the value of tf_import_export_company.gmt_create
     *
     * @mbg.generated
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tf_import_export_company.gmt_create
     *
     * @param gmtCreate the value for tf_import_export_company.gmt_create
     *
     * @mbg.generated
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tf_import_export_company.city_code
     *
     * @return the value of tf_import_export_company.city_code
     *
     * @mbg.generated
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tf_import_export_company.city_code
     *
     * @param cityCode the value for tf_import_export_company.city_code
     *
     * @mbg.generated
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tf_import_export_company.activity_id
     *
     * @return the value of tf_import_export_company.activity_id
     *
     * @mbg.generated
     */
    public String getActivityId() {
        return activityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tf_import_export_company.activity_id
     *
     * @param activityId the value for tf_import_export_company.activity_id
     *
     * @mbg.generated
     */
    public void setActivityId(String activityId) {
        this.activityId = activityId == null ? null : activityId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tf_import_export_company.stock_id
     *
     * @return the value of tf_import_export_company.stock_id
     *
     * @mbg.generated
     */
    public String getStockId() {
        return stockId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tf_import_export_company.stock_id
     *
     * @param stockId the value for tf_import_export_company.stock_id
     *
     * @mbg.generated
     */
    public void setStockId(String stockId) {
        this.stockId = stockId == null ? null : stockId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tf_import_export_company.expend_type
     *
     * @return the value of tf_import_export_company.expend_type
     *
     * @mbg.generated
     */
    public String getExpendType() {
        return expendType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tf_import_export_company.expend_type
     *
     * @param expendType the value for tf_import_export_company.expend_type
     *
     * @mbg.generated
     */
    public void setExpendType(String expendType) {
        this.expendType = expendType == null ? null : expendType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tf_import_export_company.inventory_a_amount
     *
     * @return the value of tf_import_export_company.inventory_a_amount
     *
     * @mbg.generated
     */
    public Integer getInventoryAAmount() {
        return inventoryAAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tf_import_export_company.inventory_a_amount
     *
     * @param inventoryAAmount the value for tf_import_export_company.inventory_a_amount
     *
     * @mbg.generated
     */
    public void setInventoryAAmount(Integer inventoryAAmount) {
        this.inventoryAAmount = inventoryAAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tf_import_export_company.inventory_a_price
     *
     * @return the value of tf_import_export_company.inventory_a_price
     *
     * @mbg.generated
     */
    public Integer getInventoryAPrice() {
        return inventoryAPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tf_import_export_company.inventory_a_price
     *
     * @param inventoryAPrice the value for tf_import_export_company.inventory_a_price
     *
     * @mbg.generated
     */
    public void setInventoryAPrice(Integer inventoryAPrice) {
        this.inventoryAPrice = inventoryAPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tf_import_export_company.inventory_a_total
     *
     * @return the value of tf_import_export_company.inventory_a_total
     *
     * @mbg.generated
     */
    public Integer getInventoryATotal() {
        return inventoryATotal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tf_import_export_company.inventory_a_total
     *
     * @param inventoryATotal the value for tf_import_export_company.inventory_a_total
     *
     * @mbg.generated
     */
    public void setInventoryATotal(Integer inventoryATotal) {
        this.inventoryATotal = inventoryATotal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tf_import_export_company.make_b_amount
     *
     * @return the value of tf_import_export_company.make_b_amount
     *
     * @mbg.generated
     */
    public Integer getMakeBAmount() {
        return makeBAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tf_import_export_company.make_b_amount
     *
     * @param makeBAmount the value for tf_import_export_company.make_b_amount
     *
     * @mbg.generated
     */
    public void setMakeBAmount(Integer makeBAmount) {
        this.makeBAmount = makeBAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tf_import_export_company.make_b_price
     *
     * @return the value of tf_import_export_company.make_b_price
     *
     * @mbg.generated
     */
    public Integer getMakeBPrice() {
        return makeBPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tf_import_export_company.make_b_price
     *
     * @param makeBPrice the value for tf_import_export_company.make_b_price
     *
     * @mbg.generated
     */
    public void setMakeBPrice(Integer makeBPrice) {
        this.makeBPrice = makeBPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tf_import_export_company.make_b_total
     *
     * @return the value of tf_import_export_company.make_b_total
     *
     * @mbg.generated
     */
    public Integer getMakeBTotal() {
        return makeBTotal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tf_import_export_company.make_b_total
     *
     * @param makeBTotal the value for tf_import_export_company.make_b_total
     *
     * @mbg.generated
     */
    public void setMakeBTotal(Integer makeBTotal) {
        this.makeBTotal = makeBTotal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tf_import_export_company.send_c_amount
     *
     * @return the value of tf_import_export_company.send_c_amount
     *
     * @mbg.generated
     */
    public Integer getSendCAmount() {
        return sendCAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tf_import_export_company.send_c_amount
     *
     * @param sendCAmount the value for tf_import_export_company.send_c_amount
     *
     * @mbg.generated
     */
    public void setSendCAmount(Integer sendCAmount) {
        this.sendCAmount = sendCAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tf_import_export_company.send_c_price
     *
     * @return the value of tf_import_export_company.send_c_price
     *
     * @mbg.generated
     */
    public Integer getSendCPrice() {
        return sendCPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tf_import_export_company.send_c_price
     *
     * @param sendCPrice the value for tf_import_export_company.send_c_price
     *
     * @mbg.generated
     */
    public void setSendCPrice(Integer sendCPrice) {
        this.sendCPrice = sendCPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tf_import_export_company.send_c_total
     *
     * @return the value of tf_import_export_company.send_c_total
     *
     * @mbg.generated
     */
    public Integer getSendCTotal() {
        return sendCTotal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tf_import_export_company.send_c_total
     *
     * @param sendCTotal the value for tf_import_export_company.send_c_total
     *
     * @mbg.generated
     */
    public void setSendCTotal(Integer sendCTotal) {
        this.sendCTotal = sendCTotal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tf_import_export_company.expire_d_amount
     *
     * @return the value of tf_import_export_company.expire_d_amount
     *
     * @mbg.generated
     */
    public Integer getExpireDAmount() {
        return expireDAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tf_import_export_company.expire_d_amount
     *
     * @param expireDAmount the value for tf_import_export_company.expire_d_amount
     *
     * @mbg.generated
     */
    public void setExpireDAmount(Integer expireDAmount) {
        this.expireDAmount = expireDAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tf_import_export_company.expire_d_price
     *
     * @return the value of tf_import_export_company.expire_d_price
     *
     * @mbg.generated
     */
    public Integer getExpireDPrice() {
        return expireDPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tf_import_export_company.expire_d_price
     *
     * @param expireDPrice the value for tf_import_export_company.expire_d_price
     *
     * @mbg.generated
     */
    public void setExpireDPrice(Integer expireDPrice) {
        this.expireDPrice = expireDPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tf_import_export_company.expire_d_total
     *
     * @return the value of tf_import_export_company.expire_d_total
     *
     * @mbg.generated
     */
    public Integer getExpireDTotal() {
        return expireDTotal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tf_import_export_company.expire_d_total
     *
     * @param expireDTotal the value for tf_import_export_company.expire_d_total
     *
     * @mbg.generated
     */
    public void setExpireDTotal(Integer expireDTotal) {
        this.expireDTotal = expireDTotal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tf_import_export_company.inventory_e_amount
     *
     * @return the value of tf_import_export_company.inventory_e_amount
     *
     * @mbg.generated
     */
    public Integer getInventoryEAmount() {
        return inventoryEAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tf_import_export_company.inventory_e_amount
     *
     * @param inventoryEAmount the value for tf_import_export_company.inventory_e_amount
     *
     * @mbg.generated
     */
    public void setInventoryEAmount(Integer inventoryEAmount) {
        this.inventoryEAmount = inventoryEAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tf_import_export_company.inventory_e_price
     *
     * @return the value of tf_import_export_company.inventory_e_price
     *
     * @mbg.generated
     */
    public Integer getInventoryEPrice() {
        return inventoryEPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tf_import_export_company.inventory_e_price
     *
     * @param inventoryEPrice the value for tf_import_export_company.inventory_e_price
     *
     * @mbg.generated
     */
    public void setInventoryEPrice(Integer inventoryEPrice) {
        this.inventoryEPrice = inventoryEPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tf_import_export_company.inventory_e_total
     *
     * @return the value of tf_import_export_company.inventory_e_total
     *
     * @mbg.generated
     */
    public Integer getInventoryETotal() {
        return inventoryETotal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tf_import_export_company.inventory_e_total
     *
     * @param inventoryETotal the value for tf_import_export_company.inventory_e_total
     *
     * @mbg.generated
     */
    public void setInventoryETotal(Integer inventoryETotal) {
        this.inventoryETotal = inventoryETotal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tf_import_export_company
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", statDate=").append(statDate);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", cityCode=").append(cityCode);
        sb.append(", activityId=").append(activityId);
        sb.append(", stockId=").append(stockId);
        sb.append(", expendType=").append(expendType);
        sb.append(", inventoryAAmount=").append(inventoryAAmount);
        sb.append(", inventoryAPrice=").append(inventoryAPrice);
        sb.append(", inventoryATotal=").append(inventoryATotal);
        sb.append(", makeBAmount=").append(makeBAmount);
        sb.append(", makeBPrice=").append(makeBPrice);
        sb.append(", makeBTotal=").append(makeBTotal);
        sb.append(", sendCAmount=").append(sendCAmount);
        sb.append(", sendCPrice=").append(sendCPrice);
        sb.append(", sendCTotal=").append(sendCTotal);
        sb.append(", expireDAmount=").append(expireDAmount);
        sb.append(", expireDPrice=").append(expireDPrice);
        sb.append(", expireDTotal=").append(expireDTotal);
        sb.append(", inventoryEAmount=").append(inventoryEAmount);
        sb.append(", inventoryEPrice=").append(inventoryEPrice);
        sb.append(", inventoryETotal=").append(inventoryETotal);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}