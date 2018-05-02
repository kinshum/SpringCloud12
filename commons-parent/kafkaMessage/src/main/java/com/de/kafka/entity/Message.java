package com.de.kafka.entity;

import java.io.Serializable;

/**
 *
 * @author jensen
 * @description   消息实体类 (测试)
 * @date 2018/5/3 0:14
 */
public class Message implements Serializable{
    private String orderCode;
    private Float fee;
    private Long sendTime;


    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Float getFee() {
        return fee;
    }

    public void setFee(Float fee) {
        this.fee = fee;
    }

    public Long getSendTime() {
        return sendTime;
    }

    public void setSendTime(Long sendTime) {
        this.sendTime = sendTime;
    }
}
