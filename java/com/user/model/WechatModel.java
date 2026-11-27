package com.user.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class WechatModel implements Serializable {
    private String account;
    private String appId;
    private String channel;
    private Long cid;
    private String email;
    private String headimgurl;
    private Long id;
    private String insertTime;
    private int isVip;
    private String lastLoginTime;
    private String name;
    private Long pid;
    private int state;
    private String token;
    private int type;
    private int urgentCount;
    private int useUrgentCount = 0;
    private Long vipConfigId;
    private String vipEndTime;
    private String vipStartTime;

    public String getAccount() {
        return this.account;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getChannel() {
        return this.channel;
    }

    public Long getCid() {
        return this.cid;
    }

    public String getEmail() {
        return this.email;
    }

    public String getHeadimgurl() {
        return this.headimgurl;
    }

    public Long getId() {
        return this.id;
    }

    public String getInsertTime() {
        return this.insertTime;
    }

    public int getIsVip() {
        return this.isVip;
    }

    public String getLastLoginTime() {
        return this.lastLoginTime;
    }

    public String getName() {
        return this.name;
    }

    public Long getPid() {
        return this.pid;
    }

    public int getState() {
        return this.state;
    }

    public String getToken() {
        return this.token;
    }

    public int getType() {
        return this.type;
    }

    public int getUrgentCount() {
        if (this.isVip != 1 && this.urgentCount > 3) {
            this.urgentCount = 3;
        }
        return this.urgentCount;
    }

    public int getUseUrgentCount() {
        return this.useUrgentCount;
    }

    public Long getVipConfigId() {
        return this.vipConfigId;
    }

    public String getVipEndTime() {
        return this.vipEndTime;
    }

    public String getVipStartTime() {
        return this.vipStartTime;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public void setCid(Long l2) {
        this.cid = l2;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setHeadimgurl(String str) {
        this.headimgurl = str;
    }

    public void setId(Long l2) {
        this.id = l2;
    }

    public void setInsertTime(String str) {
        this.insertTime = str;
    }

    public void setIsVip(int i2) {
        this.isVip = i2;
    }

    public void setLastLoginTime(String str) {
        this.lastLoginTime = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPid(Long l2) {
        this.pid = l2;
    }

    public void setState(int i2) {
        this.state = i2;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setType(int i2) {
        this.type = i2;
    }

    public void setUrgentCount(int i2) {
        this.urgentCount = i2;
    }

    public void setUseUrgentCount(int i2) {
        this.useUrgentCount = i2;
    }

    public void setVipConfigId(Long l2) {
        this.vipConfigId = l2;
    }

    public void setVipEndTime(String str) {
        this.vipEndTime = str;
    }

    public void setVipStartTime(String str) {
        this.vipStartTime = str;
    }
}
