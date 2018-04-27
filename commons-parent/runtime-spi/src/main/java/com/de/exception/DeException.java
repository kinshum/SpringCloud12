package com.de.exception;

import java.util.HashMap;
import java.util.Map;

import com.de.transport.InvokerResult;


public class DeException  extends Exception {
    /**
     * 错误码定义，（微服务代码:2位）+(模块代码:2位)+(错误码:3位)
      * 微服务代码定义
     * 10-公共错误和鉴权错误
     * 15-基础数据
     * 16-用户
     * 17-boss
     * 18-内容管理系统
     * 19-交易系统
     * 20-行程管理系统
     * 21-客服系统
     * 22-推荐系统
     * 23-企业版
     * 24-支付对接系统
     * 25-平台对接系统
     * 26-OTA对接系统
     * 30-活动对接系统
     * 31-举报系统
     * 32-推荐系统（推荐系统01、画像03、推荐引擎05、内容抽取07、冷启动服务09、内容解析服务11、分页查询服务13）
     * 33-运营系统
     * 60-pre-app
     * 70-pre-web
     * 80-pre-h5
     * 90-pre-ogc
     */
    public final static int COMMON_SERVICE=1000000;
    public final static int BASE_SERVICE=1500000;
    public final static int USERCENTER_SERVICE=1600000;
    public final static int BOSS_SERVICE=1700000;
    public final static int CONTENT_SERVICE=1800000;
	public final static int REC_SERVICE=1900000;
    public final static int COUPLE_SERVICE=2500000;
    public final static int LOG_SERVICE=2600000;
    public final static int REPORT_SERVICE=3100000;
    public final static int PRE_APP=6000000;
    public final static int PRE_WEB=7000000;
    public final static int PRE_H5=8000000;
    public final static int PRE_OGC=9000000;
	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 8970523354415436014L;
	private String message;
	private int code;
	
	public DeException(String message) {
		this(message,100);
	}
	public DeException(String message, int code) {
		super();
		this.message = message;
		this.code = code<100?100:code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	public InvokerResult toInvokerResult(){
        InvokerResult invokerResult=new InvokerResult();
        invokerResult.setStatus(this.code);
        Map<String, Object> result=new HashMap<>();
        result.put("message", this.message);
		invokerResult.setResult(result);
        invokerResult.setMessage(this.message);
        return invokerResult;
    }
}
