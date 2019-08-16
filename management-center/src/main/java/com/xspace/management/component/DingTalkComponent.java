package com.xspace.management.component;

import com.alibaba.fastjson.JSONObject;
import com.unicom.js.ibo.common.Env;
import com.unicom.js.ibo.common.auth.AuthHelper;
import com.unicom.js.ibo.common.auth.UserHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DingTalkComponent {
    private static Logger logger = LoggerFactory.getLogger(DingTalkComponent.class);

    /**
     * 根据钉钉给的code获取userid
     *
     * @param code
     */
    @SuppressWarnings("deprecation")
    public String getCorpUserIdByCode(String code) throws Exception {
        logger.info("根据code获取钉钉企业应用CorpUserIdByCode, 参数code:{}",code);
        String accessToken = AuthHelper.getAccessToken(Env.APP_KEY,Env.APP_SECRET);
        logger.info("根据APP_KEY和APP_SECRET获取accessToken:{}", accessToken);
        System.out.println("access token:"+accessToken);
        JSONObject user = UserHelper.getUser(accessToken, UserHelper.getUserInfo(accessToken, code).getString("userid"));
        String userId = user.getString("mobile");
        logger.info("根据code获取钉钉userId:{}", userId);
        return userId;
    }

}
