package com.xspace.commoncenter.utils;

import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

/**
 * @author yafei
 * @since 2016/11/16
 */
public class ResourceMsgUtil {

    private static ReloadableResourceBundleMessageSource messageSource;

    static {
        messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:message/commonMessage");
    }

    public ResourceMsgUtil() {
    }

    public static String getMessage(String code, Object[] keys, Locale locale) {
        if(locale == null) {
            locale = Locale.getDefault();
        }
        String message;
        try {
            message = messageSource.getMessage(code, keys, locale);
        } catch (NoSuchMessageException e) {
            message = code;
        }
        return message;
    }

    public static String getMessage(String code, Object[] keys) {
        return getMessage(code, keys, Locale.getDefault());
    }

    public static void setMessageSource(ReloadableResourceBundleMessageSource messageSource) {
        ResourceMsgUtil.messageSource = messageSource;
    }

    public static ReloadableResourceBundleMessageSource getMessageSource() {
        return messageSource;
    }
}
