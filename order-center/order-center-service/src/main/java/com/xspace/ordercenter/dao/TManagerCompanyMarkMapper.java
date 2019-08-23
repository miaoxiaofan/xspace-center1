package com.xspace.ordercenter.dao;




import com.xspace.ordercenter.entity.TManagerCompanyMark;

import java.util.List;

public interface TManagerCompanyMarkMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_manager_company_mark
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_manager_company_mark
     *
     * @mbg.generated
     */
    int insert(TManagerCompanyMark record);

    int insertSelective(TManagerCompanyMark record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_manager_company_mark
     *
     * @mbg.generated
     */
    TManagerCompanyMark selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_manager_company_mark
     *
     * @mbg.generated
     */
    List<TManagerCompanyMark> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_manager_company_mark
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TManagerCompanyMark record);

    List<TManagerCompanyMark> findCompanyMark(TManagerCompanyMark mark);
}