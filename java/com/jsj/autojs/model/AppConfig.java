package com.jsj.autojs.model;

import android.os.Build;
import java.util.Objects;

/* loaded from: classes.dex */
public class AppConfig {
    private Integer alpha;
    private Integer color;
    private int duration;
    private boolean isSkipAd;
    private String packageName;
    private String skipAdText;
    private String theme;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppConfig)) {
            return false;
        }
        AppConfig appConfig = (AppConfig) obj;
        return Build.VERSION.SDK_INT >= 19 ? Objects.equals(this.packageName, appConfig.packageName) : appConfig.packageName.equals(this.packageName);
    }

    public Integer getAlpha() {
        return this.alpha;
    }

    public Integer getColor() {
        return this.color;
    }

    public int getDuration() {
        return this.duration;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getSkipAdText() {
        return this.skipAdText;
    }

    public String getTheme() {
        return this.theme;
    }

    public boolean isSkipAd() {
        return this.isSkipAd;
    }

    public void setAlpha(Integer num) {
        this.alpha = num;
    }

    public void setColor(Integer num) {
        this.color = num;
    }

    public void setDuration(int i2) {
        this.duration = i2;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setSkipAd(boolean z) {
        this.isSkipAd = z;
    }

    public void setSkipAdText(String str) {
        this.skipAdText = str;
    }

    public void setTheme(String str) {
        this.theme = str;
    }
}
