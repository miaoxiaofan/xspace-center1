package com.xspace.commoncenter.exception;

import com.xspace.commoncenter.enums.BaseErrorEnum;
import com.xspace.commoncenter.utils.LocaleUtil;
import com.xspace.commoncenter.utils.ResourceMsgUtil;
import com.xspace.commoncenter.utils.ThreadId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**

 */
public class BusinessException extends GenericException {

    private static final long serialVersionUID = 1L;

    private static final Logger logger = LoggerFactory.getLogger(BusinessException.class);

    public BusinessException() {
    }

    public BusinessException(String errorCode) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = ResourceMsgUtil.getMessage(errorCode, null, LocaleUtil.getLocale());
        this.writeBusinessException();
    }

    public BusinessException(String errorCode, String[] keyInfos) {
        this.errorCode = errorCode;
        this.errorMessage = ResourceMsgUtil.getMessage(errorCode, keyInfos, LocaleUtil.getLocale());
        this.writeBusinessException();
    }

    public BusinessException(String errorCode, String[] keyInfos, Throwable e) {
        this.errorCode = errorCode;
        this.errorMessage = ResourceMsgUtil.getMessage(errorCode, keyInfos, LocaleUtil.getLocale());
        this.initCause(e);
        this.writeBusinessException();
    }

    public BusinessException(final String errorCode, final String message) {
        this.errorCode = errorCode;
        this.errorMessage = message;
        this.writeBusinessException();
    }

    public BusinessException(final String errorCode, final String message, final Throwable e) {
        this.errorCode = errorCode;
        this.errorMessage = message;
        this.initCause(e);
        this.writeBusinessException();
    }

    public BusinessException(BaseErrorEnum errorEnum) {
        this.errorCode = errorEnum.getCode();
        this.errorMessage = errorEnum.getMsg();
        this.writeBusinessException();
    }
    private void writeBusinessException() {
        logger.error("线程：" + ThreadId.getThreadId() + " ; 业务异常编码：" + this.getErrorCode() + " ；业务异常信息：" + this.getErrorMessage(), this);
    }
}
