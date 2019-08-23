package com.xspace.ordercenter.dao;



import com.xspace.ordercenter.entity.TCompanyCountOfBuilding;
import com.xspace.ordercenter.rsp.ParkIndustryPercentageRsp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TCompanyCountOfBuildingMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_company_count_of_building
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_company_count_of_building
     *
     * @mbg.generated
     */
    int insert(TCompanyCountOfBuilding record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_company_count_of_building
     *
     * @mbg.generated
     */
    TCompanyCountOfBuilding selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_company_count_of_building
     *
     * @mbg.generated
     */
    List<TCompanyCountOfBuilding> selectAll();
    List<TCompanyCountOfBuilding> selectCompanyCountOfBuildingByData();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_company_count_of_building
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TCompanyCountOfBuilding record);

    List<ParkIndustryPercentageRsp> parkIndustryList(String searchCode);

    List<ParkIndustryPercentageRsp> buildIndustryList(@Param("parkCode") String parkCode, @Param("buildCode") String buildCode);

    int deleteAll();

}