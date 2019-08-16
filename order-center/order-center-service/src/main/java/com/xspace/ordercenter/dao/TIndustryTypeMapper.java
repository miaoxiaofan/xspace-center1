package com.xspace.ordercenter.dao;

import com.unicom.js.ibo.infocenter.bean.TIndustryType;

import java.util.List;

public interface TIndustryTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_industry_type
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_industry_type
     *
     * @mbg.generated
     */
    int insert(TIndustryType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_industry_type
     *
     * @mbg.generated
     */
    TIndustryType selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_industry_type
     *
     * @mbg.generated
     */
    List<TIndustryType> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_industry_type
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TIndustryType record);

    List<TIndustryType> industryTypeList(TIndustryType req);

    List<TIndustryType> findIndustryType(String parentCode);
}