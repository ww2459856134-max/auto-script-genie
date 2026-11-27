package com.jsj.autojs.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class Coupon implements Serializable {
    private String code;
    private String endTime;
    private Long id;
    private String insertTime;
    private String label;
    private Long money;
    private String startTime;
    private Integer state;
    private Long uid;
    private String user;
    private String vipConfigId;

    public String getCode() {
        return this.code;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public Long getId() {
        return this.id;
    }

    public String getInsertTime() {
        return this.insertTime;
    }

    public String getLabel() {
        return this.label;
    }

    public Long getMoney() {
        return this.money;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public Integer getState() {
        return this.state;
    }

    public Long getUid() {
        return this.uid;
    }

    public String getUser() {
        return this.user;
    }

    public String getVipConfigId() {
        return this.vipConfigId;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setId(Long l2) {
        this.id = l2;
    }

    public void setInsertTime(String str) {
        this.insertTime = str;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setMoney(Long l2) {
        this.money = l2;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }

    public void setState(Integer num) {
        this.state = num;
    }

    public void setUid(Long l2) {
        this.uid = l2;
    }

    public void setUser(String str) {
        this.user = str;
    }

    public void setVipConfigId(String str) {
        this.vipConfigId = str;
    }
}
