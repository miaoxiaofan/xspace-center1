package com.xspace.ordercenter.dao;


import com.xspace.ordercenter.entity.TfImportExportCompany;

import java.util.List;

public interface TfImportExportCompanyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tf_import_export_company
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tf_import_export_company
     *
     * @mbg.generated
     */
    int insert(TfImportExportCompany record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tf_import_export_company
     *
     * @mbg.generated
     */
    TfImportExportCompany selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tf_import_export_company
     *
     * @mbg.generated
     */
    List<TfImportExportCompany> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tf_import_export_company
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TfImportExportCompany record);
}