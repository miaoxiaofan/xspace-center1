package com.xspace.management.controller;

import com.xspace.commoncenter.Constants;
import com.xspace.commoncenter.auth.AuthHelper;
import com.xspace.commoncenter.utils.WebUtils;
import com.xspace.management.component.DingTalkComponent;
import com.xspace.management.service.TGridManagerService;
import com.xspace.ordercenter.bean.TGridManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

@Controller
@RequestMapping(value = "/api/dingTalk")
public class DingTalkUserController extends BaseController {

    private static final Logger logger = LoggerFactory
            .getLogger(DingTalkUserController.class);

    @Resource
    private DingTalkComponent dingTalkComponent;

    @Autowired
    private TGridManagerService tGridManagerService;


    /**
     * 钉钉智慧商机企业应用认证回调
     *
     * @throws IOException
     */
    @RequestMapping("/dtAuthCallback.json")
    public ModelAndView zlWechatAuthCallback(String redirectUrl, String failedUrl, String code, String state,
                                             HttpServletRequest request, HttpServletResponse response,
                                             ModelAndView mav) throws IOException {

        logger.info("钉钉智慧商机企业应用认证回调 redirectUrl:{},failedUrl:{},code:{},state:{}", redirectUrl,failedUrl, code, state);

        String mobile = null;
        try {
            mobile = dingTalkComponent.getCorpUserIdByCode(code);
//            mobile = "123456";
        } catch (Exception e) {
            logger.warn("钉钉智慧商机企业应用根据code获取userId异常，原因：", e);
        }
        logger.info("DingTalkUserController的userId:{}", mobile);
        if (mobile == null || mobile.equals("")) {
        	if (StringUtils.isEmpty(failedUrl)) {
        		mav.setViewName("redirect:" + WebUtils.urlRewrite(redirectUrl, "您还不是网格经理!"));
        	} else {
        		mav.setViewName("redirect:" + URLDecoder.decode(failedUrl, "UTF-8"));
        	}
        } else {
            TGridManager gridManager = tGridManagerService.findByMobile(mobile);
            logger.info("DingTalkUserController的gridManager:{}", gridManager);
            if (gridManager != null) {
                WebUtils.getSession(request).setAttribute(Constants.USER_INFO_KEY,
                        gridManager);

                WebUtils.getSession(request).setAttribute(Constants.USER_ID_KEY,
                        mobile);
                mav.setViewName("redirect:" + URLDecoder.decode(redirectUrl, "UTF-8"));

                try { //记录登录态信息
                    if(null == WebUtils.getSession(request)) {
                        logger.info("----该seesion为null");
                    }else {
                        logger.info("---记录登录态信息，sessionId:{},userId:{}", WebUtils.getSession(request).getId(),mobile);
                    }
                } catch (Exception e) {
                    logger.error("---记录登录态信息异常--",e);
                }
            } else {
                if (StringUtils.isEmpty(failedUrl)) {
                	mav.setViewName("redirect:" + WebUtils.urlRewrite(redirectUrl, "您还不是网格经理!"));
            	} else {
            		mav.setViewName("redirect:" + URLDecoder.decode(failedUrl, "UTF-8"));
            	}
            }

        }
        logger.info("钉钉智慧商机企业应用认证回调返回结果：{}", mav);

        return mav;
    }


    //隐藏菜单
    @ResponseBody
    @RequestMapping(value = "/jsSign", method = RequestMethod.GET)
    public String getJsApiTicket(HttpServletRequest request) {
        logger.info("开始获取js 签名: 参数 appId :{}, url:{}");
        return  AuthHelper.getConfig(request);
    }

}
