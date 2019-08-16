package com.xspace.commoncenter.utils;




import com.xspace.commoncenter.Constants;
import com.xspace.ordercenter.bean.TGridManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ApiSessionUtils {
	
	public static TGridManager getUserInfoFromSession(HttpServletRequest request){
		TGridManager gridManager = null;
		HttpSession session = request.getSession(false);
		if (session != null) {
			gridManager = (TGridManager) session.getAttribute(Constants.USER_INFO_KEY);
		}
		return gridManager;
	}
}
