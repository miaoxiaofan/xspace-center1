package com.xspace.management.controller;

import com.xspace.management.vo.BaseResp;
import com.xspace.management.vo.PersonReqDto;
import com.xspace.management.vo.SimpleDto;
import com.xspace.ordercenter.api.FindEmployeeApi;

import com.xspace.ordercenter.req.EmployeeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

/**
 * @author wmiao
 * @description
 * @date 2019/5/30
 */
@Controller
@RequestMapping("/memeber")
public class MemberController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

   @Autowired
   private FindEmployeeApi findEmployeeApi;

    /**
     * 进入商户联盟查询页面
     */
    @RequestMapping(value = "/searchPage")
    @ResponseBody
    public SimpleDto searchPage(SimpleDto simpleDto) {

        logger.info("进入 进入商户联盟查询页面");


        return simpleDto;
    }


    @RequestMapping(value = "/searchPage1")

    public String searchPage1(Model model, SimpleDto simpleDto) {
        logger.info("SimpleDto：{}", simpleDto);
        logger.info("进入 进入商户联盟查询页面");
        simpleDto.setMsgCode(generateSmsCode());
        model.addAttribute("simpleDto", simpleDto);

        return "memeber/searchPage";
    }


    @RequestMapping(value = "/valide")
    @ResponseBody
    public BaseResp valide(PersonReqDto personReqDto) {
        logger.info("PersonReqDto：{}", personReqDto);
        logger.info("身份验证");
        BaseResp baseResp = new BaseResp();
        if (StringUtils.isEmpty(personReqDto.getName())) {
            logger.warn("姓名为空");
            baseResp.fail("姓名为空");
            return baseResp;
        }
        if (StringUtils.isEmpty(personReqDto.getPassword())) {
            logger.warn("密码为空");
            baseResp.fail("密码为空");
            return baseResp;
        }
        if (!personReqDto.getName().equals(personReqDto.getPassword())) {
            logger.warn("密码错误");
            baseResp.fail("密码错误");
            return baseResp;
        }

        logger.info("校验成功");

        return baseResp;

    }


    /**
     * 生成验证码
     */
    private String generateSmsCode() {
        String str = "0123456789";
        int length = 6;
        StringBuilder stringBuilder = new StringBuilder();
        Random rd = new Random();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(str.charAt(rd.nextInt(str.length())));
        }
        return stringBuilder.toString();
    }
    /**
     * 进入商户联盟查询页面
     */
    @RequestMapping(value = "/searchEmployee")
    @ResponseBody
    public List<EmployeeDto> searchEmployee(EmployeeDto employee) {

        logger.info("查询客户信息");

        List<EmployeeDto> result=findEmployeeApi.findEmployeeBy(employee);
        return result;
    }




}
