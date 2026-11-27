package com.user.model;

import com.google.gson.j0.c;

/* loaded from: classes.dex */
public class PayModel {
    private String appid;
    private String noncestr;

    @c("package")
    private String packageX;
    private String partnerid;
    private String prepayid;
    private String sign;
    private String timestamp;

    public String getAppid() {
        return this.appid;
    }

    public String getNoncestr() {
        return this.noncestr;
    }

    public String getPackageX() {
        return this.packageX;
    }

    public String getPartnerid() {
        return this.partnerid;
    }

    public String getPrepayid() {
        return this.prepayid;
    }

    public String getSign() {
        return this.sign;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public void setAppid(String str) {
        this.appid = str;
    }

    public void setNoncestr(String str) {
        this.noncestr = str;
    }

    public void setPackageX(String str) {
        this.packageX = str;
    }

    public void setPartnerid(String str) {
        this.partnerid = str;
    }

    public void setPrepayid(String str) {
        this.prepayid = str;
    }

    public void setSign(String str) {
        this.sign = str;
    }

    public void setTimestamp(String str) {
        this.timestamp = str;
    }
}
