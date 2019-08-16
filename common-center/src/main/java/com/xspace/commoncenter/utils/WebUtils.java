package com.xspace.commoncenter.utils;


import com.github.pagehelper.util.StringUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Enumeration;

public class WebUtils {


    public static Boolean isWeChatRequest(HttpServletRequest request) {
        String agent = null;
        Boolean flag = Boolean.valueOf(false);

        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
            String name = (String) headers.nextElement();
            if ("User-Agent".equalsIgnoreCase(name)) {
                agent = request.getHeader(name).toLowerCase();
                flag = Boolean.valueOf(agent.contains("micromessenger"));
                break;
            }
        }
        return flag;
    }

    public static void removeCookie(HttpServletRequest request,
                                    HttpServletResponse response, String name) {
        removeCookie(request, response, name, "/", "");
    }

    public static void removeCookie(HttpServletRequest request,
                                    HttpServletResponse response, String name, String path,
                                    String domain) {
        try {
            name = URLEncoder.encode(name, "UTF-8");
            Cookie cookie = new Cookie(name, null);
            cookie.setMaxAge(0);
            if (!StringUtil.isEmpty(path)) {
                cookie.setPath(path);
            }
            if (!StringUtil.isEmpty(domain)) {
                cookie.setDomain(domain);
            }
            response.addCookie(cookie);
        } catch (UnsupportedEncodingException e) {
        }
    }


    public static Boolean needReturnJson(HttpServletRequest request) {
        Boolean flag = Boolean.valueOf(false);

        String requestType = request.getHeader("X-Requested-With");
        if ((requestType != null)
                && (requestType.equalsIgnoreCase("XMLHttpRequest"))) {
            flag = Boolean.valueOf(true);
        }

        return flag;
    }

    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if ((ip == null) || (ip.length() == 0)
                || ("unknown".equalsIgnoreCase(ip))) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if ((ip == null) || (ip.length() == 0)
                || ("unknown".equalsIgnoreCase(ip))) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if ((ip == null) || (ip.length() == 0)
                || ("unknown".equalsIgnoreCase(ip))) {
            ip = request.getRemoteAddr();
        }
        if ((ip == null) || (ip.length() == 0)
                || ("unknown".equalsIgnoreCase(ip))) {
            ip = request.getHeader("http_client_ip");
        }
        if ((ip == null) || (ip.length() == 0)
                || ("unknown".equalsIgnoreCase(ip))) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }

        if ((ip != null) && (ip.indexOf(",") != -1)) {
            ip = ip.substring(ip.lastIndexOf(",") + 1, ip.length()).trim();
        }
        return ip;
    }

    public static HttpSession getSession(HttpServletRequest request) {
        return request.getSession();
    }

    public static String urlRewrite(String url, String msg) throws UnsupportedEncodingException {
        String notFoundPage ="#/mid/result?tips=";
        msg = URLEncoder.encode(msg,"UTF-8");
        if (StringUtil.isEmpty(url)) {
            return url;
        }

        int start = url.indexOf("#");
        if (start == -1) {
            if (url.endsWith("/")) {
                return url + notFoundPage + msg;
            } else {
                return url + "/" + notFoundPage + msg;
            }
        } else {
            return url.substring(0, start) + notFoundPage + msg;
        }
    }

}
