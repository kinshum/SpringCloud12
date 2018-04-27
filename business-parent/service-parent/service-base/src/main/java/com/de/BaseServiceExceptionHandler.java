package com.de;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.ResourceAccessException;

import com.de.exception.DeBaseException;
import com.de.exception.DeBaseException.ErrorBaseEnum;
import com.de.exception.DeException;
import com.de.transport.InvokerResult;

@ControllerAdvice
@ResponseBody
public class BaseServiceExceptionHandler {
    private static final Logger logger =LoggerFactory.getLogger(BaseServiceExceptionHandler.class);
    @ExceptionHandler(Exception.class)
    public InvokerResult handleException(Exception e) {
        if (e instanceof DeException) {
        	DeException we = (DeException)e;
            return we.toInvokerResult();
        }else {
            e.printStackTrace();
            logger.warn("未处理异常:{}",e);
         // 检测是否服务还未完全启动的异常
            if (e instanceof IllegalStateException) {
                if (e.getMessage().contains("No instances available for ")) {
                    return new DeException(e.getMessage()).toInvokerResult();
                }
            }else if (e instanceof MissingServletRequestParameterException) {
                //缺少必要参数
                return new DeException(e.getMessage()).toInvokerResult();
            }else if (e instanceof HttpMediaTypeNotSupportedException) {
                //请求方式不对
                return new DeException("请求方式不支持").toInvokerResult();
            }else if (e instanceof ResourceAccessException) {
                //资源请求失败
                return new DeException("资源请求失败，请稍候").toInvokerResult();
            }
            return new DeBaseException(ErrorBaseEnum.ERR_EXCEPTION).toInvokerResult();
        }
    }
}
