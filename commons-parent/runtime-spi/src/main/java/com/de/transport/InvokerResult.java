package com.de.transport;

import java.io.Serializable;

/**
 * 调用结果
 * 
 *
 */
public final class InvokerResult implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 状态 0 代表成功 其他代表失败
	 */
	private int status = 0;
	
	private Object result = null;
	
	private String message = "";
	

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
	
}
