package com.yl.model;

import java.util.Objects;

/* loaded from: classes.dex */
public class FloatButtonConfig {
    public String appPn;
    public int color;
    public boolean hideInRun;
    public long id;
    public boolean lockPosition;
    public boolean magnet;
    public String pageCls;
    public int radius;
    public long taskId;
    public String text;
    public int textColor;
    public int x;
    public int y;
    public float alpha = 0.6f;
    public boolean isOpen = true;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FloatButtonConfig) && this.taskId == ((FloatButtonConfig) obj).taskId;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.taskId));
    }
}
