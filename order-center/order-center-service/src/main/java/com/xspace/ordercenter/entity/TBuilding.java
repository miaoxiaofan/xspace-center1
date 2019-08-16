package com.xspace.ordercenter.entity;

import java.io.Serializable;

public class TBuilding implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_building.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_building.building_code
     *
     * @mbg.generated
     */
    private String buildingCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_building.building_name
     *
     * @mbg.generated
     */
    private String buildingName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_building.park_code
     *
     * @mbg.generated
     */
    private Integer parkCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_building.park_name
     *
     * @mbg.generated
     */
    private String parkName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_building
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_building.id
     *
     * @return the value of t_building.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_building.id
     *
     * @param id the value for t_building.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_building.building_code
     *
     * @return the value of t_building.building_code
     *
     * @mbg.generated
     */
    public String getBuildingCode() {
        return buildingCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_building.building_code
     *
     * @param buildingCode the value for t_building.building_code
     *
     * @mbg.generated
     */
    public void setBuildingCode(String buildingCode) {
        this.buildingCode = buildingCode == null ? null : buildingCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_building.building_name
     *
     * @return the value of t_building.building_name
     *
     * @mbg.generated
     */
    public String getBuildingName() {
        return buildingName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_building.building_name
     *
     * @param buildingName the value for t_building.building_name
     *
     * @mbg.generated
     */
    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName == null ? null : buildingName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_building.park_code
     *
     * @return the value of t_building.park_code
     *
     * @mbg.generated
     */
    public Integer getParkCode() {
        return parkCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_building.park_code
     *
     * @param parkCode the value for t_building.park_code
     *
     * @mbg.generated
     */
    public void setParkCode(Integer parkCode) {
        this.parkCode = parkCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_building.park_name
     *
     * @return the value of t_building.park_name
     *
     * @mbg.generated
     */
    public String getParkName() {
        return parkName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_building.park_name
     *
     * @param parkName the value for t_building.park_name
     *
     * @mbg.generated
     */
    public void setParkName(String parkName) {
        this.parkName = parkName == null ? null : parkName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_building
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
        sb.append(", buildingCode=").append(buildingCode);
        sb.append(", buildingName=").append(buildingName);
        sb.append(", parkCode=").append(parkCode);
        sb.append(", parkName=").append(parkName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}