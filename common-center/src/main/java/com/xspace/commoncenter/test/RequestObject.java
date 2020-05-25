package com.xspace.commoncenter.test;

import java.io.Serializable;

/**
 *
 * @author april
 *
 */
@SuppressWarnings("serial")
public class RequestObject implements Serializable{

	/**
	 * 请求唯一标识
	 */
    private String requestId;

	/**
	 * 请求流水号
	 **/
	private String transId;


    /**
     * 响应消息应该发送到哪个队列中
     */
    private String replyQueueName;

	/**
	 * 能力标签
	 */
	private String method;

	/**
	 * 应用Key
	 */
	private String appKey;

	/**
	 * 请求报文
	 */
	private String reqMsg;

	/**
	 * 是否打印日志标识
	 */
	private boolean writeLogFlag;



	/**
	 *
	 * 全路径 traceId
	 */
	private String traceId;

	public String getTraceId() {
		return traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}



	private String serialNumber;

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getReplyQueueName() {
        return replyQueueName;
    }

    public void setReplyQueueName(String replyQueueName) {
        this.replyQueueName = replyQueueName;
    }

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getReqMsg() {
		return reqMsg;
	}

	public void setReqMsg(String reqMsg) {
		this.reqMsg = reqMsg;
	}

	public boolean isWriteLogFlag() {
		return writeLogFlag;
	}

	public void setWriteLogFlag(boolean writeLogFlag) {
		this.writeLogFlag = writeLogFlag;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getTransId() {
		return transId;
	}

	public void setTransId(String transId) {
		this.transId = transId;
	}

	@Override
	public String toString() {
		return "RequestObject{" +
				"requestId='" + requestId + '\'' +
				", transId='" + transId + '\'' +
				", replyQueueName='" + replyQueueName + '\'' +
				", method='" + method + '\'' +
				", appKey='" + appKey + '\'' +
				", reqMsg='" + reqMsg + '\'' +
				", writeLogFlag=" + writeLogFlag +
				", traceId='" + traceId + '\'' +
				", serialNumber='" + serialNumber + '\'' +
				'}';
	}
}
