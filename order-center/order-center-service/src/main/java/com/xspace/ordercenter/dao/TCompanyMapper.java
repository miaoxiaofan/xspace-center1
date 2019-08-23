package com.xspace.ordercenter.dao;


import com.xspace.ordercenter.entity.TCompany;
import com.xspace.ordercenter.req.BuildingCompanyInfoReq;
import com.xspace.ordercenter.req.SearchCompanyReq;
import com.xspace.ordercenter.rsp.CompanyInfoRsp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TCompanyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_company
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);
    int deleteAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_company
     *
     * @mbg.generated
     */
    int insert(TCompany record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_company
     *
     * @mbg.generated
     */
    TCompany selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_company
     *
     * @mbg.generated
     */
    List<TCompany> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_company
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TCompany record);

    List<CompanyInfoRsp> companyList(@Param("req") BuildingCompanyInfoReq req);

    List<CompanyInfoRsp> searchCompany(@Param("req") SearchCompanyReq req, @Param("industryCodes") List<String> industryCodes);

    List<CompanyInfoRsp> findHotCompany(@Param("managerCode") Integer managerCode, @Param("hotCompanyIds") List<String> hotCompanyIds);
}