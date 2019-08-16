package com.xspace.commoncenter;

/**
 * 常量类
 */
public class Constants {

	/** 登录用户KEY */
	public static final String USER_ID_KEY = "userId";

    /** 登录用户KEY */
    public static final String UNIQUE_ID = "uniqueId";
	
	/** 登录用户信息KEY */
	public static final String USER_INFO_KEY = "userInfo";

    /** 模拟点赞用户的唯一标识 */
    public static final String GET_DRAW_CHANCE_KEY = "drawChanceKey";
	
	/** bcp-api系统简称 */
	public static final String BCP_API_SYS_SHORT_NAME = "BCPAPI";
	
	/** 线下H5渠道码 **/
    public final static String CHANNEL_CODE_OUTLINE = "4WAP";
    
    /** api接口返回成功标志 **/
    public static final int RETURN_FLAG_SUCCESS = 200;
    
    /** api接口返回失败标志 **/
    public static final int RETURN_FLAG_FAIL = 400;
    
    /** api接口返回无权限标志 **/
    public static final int RETURN_FLAG_NOAUTH = 401;
	
}
