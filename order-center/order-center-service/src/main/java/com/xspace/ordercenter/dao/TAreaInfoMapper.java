package com.xspace.ordercenter.dao;






import com.xspace.ordercenter.entity.TAreaInfo;

import java.util.List;

public interface TAreaInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_area_info
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_area_info
     *
     * @mbg.generated
     */
    int insert(TAreaInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_area_info
     *
     * @mbg.generated
     */
    TAreaInfo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_area_info
     *
     * @mbg.generated
     */
    List<TAreaInfo> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_area_info
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TAreaInfo record);


    List<TAreaInfo> findByCityCode(TAreaInfo record);
}