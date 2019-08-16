package com.xspace.ordercenter.service.impl;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.jcraft.jsch.JSchException;
import com.unicom.js.ibo.common.exception.BusinessException;
import com.unicom.js.ibo.infocenter.bean.TCompany;
import com.unicom.js.ibo.infocenter.bean.TCompanyCountOfBuilding;
import com.unicom.js.ibo.infocenter.bean.TManagerCompanyRecommend;
import com.unicom.js.ibo.infocenter.dao.TCompanyCountOfBuildingMapper;
import com.unicom.js.ibo.infocenter.dao.TCompanyMapper;
import com.unicom.js.ibo.infocenter.dao.TManagerCompanyRecommendMapper;
import com.unicom.js.ibo.infocenter.job.task.SftpClient;
import com.unicom.js.ibo.infocenter.service.SyncCompanyFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author huxl
 * @description
 * @date 2019/7/31
 */
@Service
@PropertySource("classpath:/properties/sftp.properties")    // 3.配置文件位置
public class SyncCompanyFileServiceImpl implements SyncCompanyFileService {

    @Autowired
    private TCompanyMapper tCompanyMapper;

    @Autowired
    private TManagerCompanyRecommendMapper tManagerCompanyRecommendMapper;

    @Autowired
    private TCompanyCountOfBuildingMapper tCompanyCountOfBuildingMapper;

    private Logger logger = LoggerFactory.getLogger(SyncCompanyFileServiceImpl.class);

    private final String emptyFlag = "\\N";

    //sftp配置
    @Autowired
    private SftpClient sftpClient;

    @Value("${sftp.bcp.company.data.ip}")
    private String sftpHostCompany;

    @Value("${sftp.bcp.company.data.port}")
    private int sftpPortCompany;

    @Value("${sftp.bcp.company.data.user.name}")
    private String sftpUserNameCompany;

    @Value("${sftp.bcp.company.data.user.password}")
    private String sftpPasswordCompany;

    @Value("${sftp.bcp.company.data.download.local.path}")
    private String downloadLocalPathCompany;

    @Value("${sftp.bcp.company.data.download.remote.path}")
    private String downloadRemotePathCompany;



    @Value("${sftp.bcp.companyRecommend.data.ip}")
    private String sftpHostCompanyRecommend;

    @Value("${sftp.bcp.companyRecommend.data.port}")
    private int sftpPortCompanyRecommend;

    @Value("${sftp.bcp.companyRecommend.data.user.name}")
    private String sftpUserNameCompanyRecommend;

    @Value("${sftp.bcp.companyRecommend.data.user.password}")
    private String sftpPasswordCompanyRecommend;

    @Value("${sftp.bcp.companyRecommend.data.download.local.path}")
    private String downloadLocalPathCompanyRecommend;

    @Value("${sftp.bcp.companyRecommend.data.download.remote.path}")
    private String downloadRemotePathCompanyRecommend;

    @Override
    public void fetchCompanyData(String date) {
        List<TCompany> companyList = getCompanyData(date);
        List<TManagerCompanyRecommend> companyRecommendList = getCompanyRecommendData(date);
        logger.info("同步企业数据文件数据长度->{}",companyList.size());
        logger.info("同步网格经理推荐企业数据文件数据长度->{}",companyRecommendList.size());
        if(!CollectionUtils.isEmpty(companyList)){
            tCompanyMapper.deleteAll();

            for(int i=0;i<companyList.size();i++){
                try{
                    tCompanyMapper.insert(companyList.get(i));//将从ftp获取数据保存至数据库
                }
                catch (Exception e){
                    logger.error("插入同步企业数据文件数据异常，第{}条,List={}",i,companyList.get(i).toString(),e);
                }
            }
            tCompanyCountOfBuildingMapper.deleteAll();
            List<TCompanyCountOfBuilding> companyCountOfBuildingList= tCompanyCountOfBuildingMapper.selectCompanyCountOfBuildingByData();
            for(int j=0;j<companyCountOfBuildingList.size();j++){
                try{
                    tCompanyCountOfBuildingMapper.insert(companyCountOfBuildingList.get(j));//将新计算的企业行业分类统计数据保存至数据库
                }
                catch (Exception e){
                    logger.error("插入新计算的企业行业分类统计数据异常，第{}条,List={}",j,companyCountOfBuildingList.get(j).toString(),e);
                }
            }

        }

        if(!CollectionUtils.isEmpty(companyRecommendList)){
            tManagerCompanyRecommendMapper.deleteAll();

            for(int i=0;i<companyRecommendList.size();i++){
                try{
                    tManagerCompanyRecommendMapper.insert(companyRecommendList.get(i));//将从ftp获取数据保存至数据库
                }
                catch (Exception e){
                    logger.error("插入同步网格经理推荐企业数据文件数据异常，第{}条,List={}",i,companyRecommendList.get(i).toString(),e);
                }
            }
        }
    }

    /**
     * 从ftp读取数据中心同步的企业数据文件
     * 文件名称是当月日期
     * @param date
     * @return
     */
    private List<TCompany> getCompanyData(String date) {
        List<TCompany> list = new ArrayList<TCompany>();
        String fileName = "ibo_company_" + date + ".txt";
        //从SFtp服务器下载支付回执文件
        //初始化上传SFTP配置
        sftpClient.init(sftpHostCompany, sftpPortCompany, sftpUserNameCompany, sftpPasswordCompany);
        sftpClient.connect();
        sftpClient.download(downloadRemotePathCompany, downloadLocalPathCompany, fileName);
        File localFile = new File(downloadLocalPathCompany + File.separator + fileName);

        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br=null;
        int rowNum = 0;
        try {
            String code = getCode(downloadLocalPathCompany + File.separator + fileName);
            fis = new FileInputStream(localFile);
            isr = new InputStreamReader(fis, code);
            br = new BufferedReader(isr);
            String row = "";
            Date createDate = null;//公司创建日期
            //发展人编号||充值号码||充值金额（元）||充值时间||订单编号||openid
            for (int i = 1; (row = br.readLine()) != null; ++i) {
                try{
                    rowNum = i;
                    String[] cols = row.split("\\|");
                    if(cols.length > 0){
                        for(int j = 0; j < cols.length; j++){
                            if(emptyFlag.equals(cols[j])){
                                cols[j] = "";
                            }
                        }

                        Integer parkCode=new Integer(cols[0]);//园区编码
                        Integer companyCode=new Integer(cols[4]);//公司编码
                        Integer buildingCode=new Integer(cols[2]);//办公楼编码
                        SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM");
                        if(StringUtils.isNotEmpty(cols[7])){
                            createDate = sDateFormat.parse(cols[7]);
                        }
                        Integer registeredCapital=new Integer(cols[8]);//注册资金
                        BigDecimal longitude=new BigDecimal(cols[11]);
                        BigDecimal latitude=new BigDecimal(cols[12]);
                        Integer intendedBusinessCode=new Integer(cols[14]);//意向业务编码
                        Integer industryTypeCode=new Integer(cols[15]);//行业分类编码
                        TCompany company = new TCompany(companyCode,parkCode,cols[1],buildingCode,cols[3],cols[5],cols[6],
                                createDate,registeredCapital,cols[9],cols[10],longitude,latitude,cols[13],intendedBusinessCode,industryTypeCode);
                        list.add(company);
                    }
                }
                catch (Exception e){
                    logger.error("第" + rowNum + "行发生错误：", e);
                }
            }
        } catch (FileNotFoundException e1) {
            throw new BusinessException("SFTP001","文件不存在",e1);
        } catch (UnsupportedEncodingException e1) {
            logger.error("sftp读取岁末充值数据错误", e1);
            throw new BusinessException("SFTP002","编码错误",e1);
        } catch (IOException e1) {
            throw new BusinessException("SFTP003","io流错误",e1);
        }catch (Exception e){
            throw new BusinessException("SFTP004","第" + rowNum + "行发生错误：" + e.getMessage(),e);
        }finally {
            try {
                sftpClient.disConnect();
            } catch (JSchException e) {
                logger.error("sftp关闭错误",e);
            }
            try {
                if (br != null) {
                    br.close();
                }
            }catch (IOException e){
                logger.error("br流关闭失败，原因是",e);
            }
            if(isr != null){
                try {
                    isr.close();
                } catch (IOException e1) {
                    logger.error("isr流关闭失败，原因是",e1);
                }
            }
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e1) {
                    logger.error("fis流关闭失败，原因是",e1);
                }
            }
        }
        return list;
    }
    /**
     * 从ftp读取数据中心同步的网格经理推荐企业数据文件
     * 文件名称是当月日期
     * @param date
     * @return
     */
    private List<TManagerCompanyRecommend> getCompanyRecommendData(String date) {
        List<TManagerCompanyRecommend> list = new ArrayList<TManagerCompanyRecommend>();
        String fileName = "ibo_company_recommend_" + date + ".txt";
        //从SFtp服务器下载支付回执文件
        //初始化上传SFTP配置
        sftpClient.init(sftpHostCompanyRecommend, sftpPortCompanyRecommend, sftpUserNameCompanyRecommend, sftpPasswordCompanyRecommend);
        sftpClient.connect();
        sftpClient.download(downloadRemotePathCompanyRecommend, downloadLocalPathCompanyRecommend, fileName);
        File localFile = new File(downloadLocalPathCompanyRecommend + File.separator + fileName);

        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br=null;
        int rowNum = 0;
        try {
            String code = getCode(downloadLocalPathCompanyRecommend + File.separator + fileName);
            fis = new FileInputStream(localFile);
            isr = new InputStreamReader(fis, code);
            br = new BufferedReader(isr);
            String row = "";
            Date createDate = null;//公司创建日期
            //发展人编号||充值号码||充值金额（元）||充值时间||订单编号||openid
            for (int i = 1; (row = br.readLine()) != null; ++i) {
                try{
                    rowNum = i;
                    String[] cols = row.split("\\|");
                    if(cols.length > 0){
                        for(int j = 0; j < cols.length; j++){
                            if(emptyFlag.equals(cols[j])){
                                cols[j] = "";
                            }
                        }

                        Integer managerCode=new Integer(cols[0]);//网格经理编码
                        Integer companyCode=new Integer(cols[1]);//公司编码
                        Integer ourRatings=new Integer(cols[2]);//推荐指数
                        TManagerCompanyRecommend companyRecommend = new TManagerCompanyRecommend(managerCode,companyCode,ourRatings);
                        list.add(companyRecommend);
                    }
                }
                catch (Exception e){
                    logger.error("第" + rowNum + "行发生错误：", e);
                }
            }
        } catch (FileNotFoundException e1) {
            throw new BusinessException("SFTP001","文件不存在",e1);
        } catch (UnsupportedEncodingException e1) {
            logger.error("sftp读取岁末充值数据错误", e1);
            throw new BusinessException("SFTP002","编码错误",e1);
        } catch (IOException e1) {
            throw new BusinessException("SFTP003","io流错误",e1);
        }catch (Exception e){
            throw new BusinessException("SFTP004","第" + rowNum + "行发生错误：" + e.getMessage(),e);
        }finally {
            try {
                sftpClient.disConnect();
            } catch (JSchException e) {
                logger.error("sftp关闭错误",e);
            }
            try {
                if (br != null) {
                    br.close();
                }
            }catch (IOException e){
                logger.error("br流关闭失败，原因是",e);
            }
            if(isr != null){
                try {
                    isr.close();
                } catch (IOException e1) {
                    logger.error("isr流关闭失败，原因是",e1);
                }
            }
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e1) {
                    logger.error("fis流关闭失败，原因是",e1);
                }
            }
        }
        return list;
    }

    public static String getCode(String path) throws Exception {
        InputStream inputStream = new FileInputStream(path);
        byte[] head = new byte[3];
        inputStream.read(head);
        String code = "gb2312";  //或GBK
        if (head[0] == -1 && head[1] == -2 ) {
            code = "UTF-16";
        }
        else if (head[0] == -2 && head[1] == -1 ) {
            code = "Unicode";
        }
        else if(head[0]==-17 && head[1]==-69 && head[2] ==-65) {
            code = "UTF-8";
        }
        inputStream.close();
        System.out.println(code);
        return code;
    }
}
