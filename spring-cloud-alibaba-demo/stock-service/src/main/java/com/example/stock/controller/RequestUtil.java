package com.example.stock.controller;

import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName:RequestUtil
 * Package:com.example.stock.controller
 * Description:
 *
 * @Date:2022/7/12 8:58
 * @Author:qs@1.com
 */
public class RequestUtil {

    private static final String X_REAL_IP = "X-Real-IP";

    private static final String X_FORWARDED_FOR = "X-Forwarded-For";

    private static final String X_FORWARDED_FOR_SPLIT_SYMBOL = ",";

    public static final String CLIENT_APPNAME_HEADER = "Client-AppName";

    public static final String NACOS_USER_KEY = "nacosuser";

    /**
     * get real client ip
     *
     * <p>first use X-Forwarded-For header    https://zh.wikipedia.org/wiki/X-Forwarded-For next nginx X-Real-IP last
     * {@link HttpServletRequest#getRemoteAddr()}
     *
     * @param request {@link HttpServletRequest}
     * @return
     */
    public static String getRemoteIp(HttpServletRequest request) {
        String xForwardedFor = request.getHeader(X_FORWARDED_FOR);
        if (!StringUtils.isBlank(xForwardedFor)) {
            return xForwardedFor.split(X_FORWARDED_FOR_SPLIT_SYMBOL)[0].trim();
        }
        String nginxHeader = request.getHeader(X_REAL_IP);
        return StringUtils.isBlank(nginxHeader) ? request.getRemoteAddr() : nginxHeader;
    }

    /**
     * Gets the name of the client application in the header.
     *
     * @param request {@link HttpServletRequest}
     * @return may be return null
     */
    public static String getAppName(HttpServletRequest request) {
        return request.getHeader(CLIENT_APPNAME_HEADER);
    }



}
