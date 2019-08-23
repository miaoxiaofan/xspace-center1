package com.xspace.ordercenter.service.impl;



import com.xspace.ordercenter.entity.TIndustryType;
import com.xspace.ordercenter.dao.TCompanyCountOfBuildingMapper;
import com.xspace.ordercenter.dao.TIndustryTypeMapper;
import com.xspace.ordercenter.rsp.BaseIndustryTypeRsp;
import com.xspace.ordercenter.rsp.BasePercentageRsp;
import com.xspace.ordercenter.rsp.IndustryTypeRsp;
import com.xspace.ordercenter.rsp.ParkIndustryPercentageRsp;
import com.xspace.ordercenter.service.IndustryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author wmiao
 * @description
 * @date 2019/7/30
 */
@Service
public class IndustryServiceImpl implements IndustryService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TCompanyCountOfBuildingMapper tCompanyCountOfBuildingMapper;


    @Autowired
    private TIndustryTypeMapper tIndustryTypeMapper;
    //其他行业分类一级分类编码
    private static final String OTHER_TYPE = "11";

    @Cacheable(value = "Ibo_parkIndustryList", key = "#searchCode", unless = "#result eq null ")
    @Override
    public List<BasePercentageRsp> parkIndustryList(String searchCode) {


        List<ParkIndustryPercentageRsp> list = tCompanyCountOfBuildingMapper.parkIndustryList(searchCode);
        list=checkInfo(list);
        //属性改名

        List<BasePercentageRsp> result=new ArrayList<BasePercentageRsp>();
        if (null == list || list.size() == 0) {
            return null;
        }

        for(ParkIndustryPercentageRsp item:list){
            result.add(new BasePercentageRsp(item.getIndustryName(),item.getCompanyRate()));
        }
        return result;
    }

    @Cacheable(value = "Ibo_buildIndustryList", unless = "#result eq null ")
    @Override
    public List<BasePercentageRsp> buildIndustryList(String parkCode, String buildCode) {

        List<ParkIndustryPercentageRsp> list = tCompanyCountOfBuildingMapper.buildIndustryList(parkCode, buildCode);
        list=checkInfo(list);
        //属性改名

        List<BasePercentageRsp> result=new ArrayList<BasePercentageRsp>();
        if (null == list || list.size() == 0) {
            return null;
        }

        for(ParkIndustryPercentageRsp item:list){
            result.add(new BasePercentageRsp(item.getIndustryName(),item.getCompanyRate()));
        }
        return result;
    }


    private List<ParkIndustryPercentageRsp> checkInfo(List<ParkIndustryPercentageRsp> list) {
        if (null == list || list.size() == 0) {
            return list;
        }
        int size = list.size();

        //总数
        int allCount = 0;

        BigDecimal range=new BigDecimal(100);
        int otherTypeIndex = -1;
        //计算总数，并判断前6名，是否有“其他行业分类”

        for (int i = 0; i < size; i++) {
            allCount += list.get(i).getCompanyNum();
            if ((i < 6) && OTHER_TYPE.equals(list.get(i).getIndustryCode())) {
                otherTypeIndex = i;
            }
        }

        ParkIndustryPercentageRsp otherTypeInfo;

        //返回前6数据，其余合并为 “其他行业”
        if (size <= 6) {
            for (int i = 0; i < size; i++) {
                if (i == size - 1) {
                    list.get(i).setCompanyRate(range.toString() + "%");
                    break;
                }
                BigDecimal bigDecimal = new BigDecimal(100.0 * list.get(i).getCompanyNum() / allCount).setScale(1, BigDecimal.ROUND_DOWN);
                list.get(i).setCompanyRate(bigDecimal.toString() + "%");
                range = range.subtract(bigDecimal);
            }
        } else {
            //取出其他分类数据
            if (otherTypeIndex > -1) {
                otherTypeInfo = list.remove(otherTypeIndex);
            }
            int allCountP = allCount;
            for (int i = 0; i < 6; i++) {
                BigDecimal bigDecimal = new BigDecimal(100.0 * list.get(i).getCompanyNum() / allCount).setScale(1, BigDecimal.ROUND_DOWN);
                list.get(i).setCompanyRate(bigDecimal.toString() + "%");
                range = range.subtract(bigDecimal);
                allCountP = allCountP - list.get(i).getCompanyNum();
            }
            if (list.size() >= 7) {
                list.get(6).setCompanyRate(range.toString() + "%");
                list.get(6).setCompanyNum(allCountP);
                list.get(6).setIndustryCode(OTHER_TYPE);
                list.get(6).setIndustryName("其他行业");
            } else {
                ParkIndustryPercentageRsp other = new ParkIndustryPercentageRsp();
                other.setCompanyRate(range.toString() + "%");
                other.setCompanyNum(allCountP);
                other.setIndustryCode(OTHER_TYPE);
                other.setIndustryName("其他行业");
                list.add(other);
            }
            list = list.subList(0, 7);
        }
        return list;
    }


    @Cacheable(value = "Ibo_IndustryType", key = "1", unless = "#result eq null ")
    @Override
    public List<IndustryTypeRsp> findIndustryType() {
        LOGGER.info("数据库查询行业分类数据");
        List<IndustryTypeRsp> result=new ArrayList<>();
        List<TIndustryType> list  =tIndustryTypeMapper.selectAll();
        Map<String,List<BaseIndustryTypeRsp>> map=new HashMap<>();
        if(CollectionUtils.isEmpty(list)){
            return result;
        }
        for(TIndustryType item:list){
            //遍历一级分类
            if(item.getLevel()==1){
                result.add(new IndustryTypeRsp(item.getCode().toString(),item.getName()));
                List<BaseIndustryTypeRsp>  children= new LinkedList<>();
                map.put(item.getCode().toString(),children);
            }else {
                //二级分类 放入map
                map.get(item.getParentCode().toString()).add(new BaseIndustryTypeRsp(item.getName(),item.getCode().toString()));
            }
        }
        if(CollectionUtils.isEmpty(result)){
            return result;
        }

        for(IndustryTypeRsp item:result){
            List<BaseIndustryTypeRsp> children=map.get(item.getCode());
            item.setChildren(children);
            //“其他”子类编码list  不需要 新增：全部其他
            if((!CollectionUtils.isEmpty(children))&&(!OTHER_TYPE.equals(item.getCode()))){
                String name="全部"+item.getName();
                StringBuffer code=new StringBuffer();
                for(BaseIndustryTypeRsp child:children){
                    code.append(",").append(child.getCode());
                }
                String codeStr=code.toString();
                codeStr=codeStr.replaceFirst(",","");
                children.add(0,new BaseIndustryTypeRsp(name,codeStr));
            }
            item.setChildren(children);

        }
        return result;
    }
}
