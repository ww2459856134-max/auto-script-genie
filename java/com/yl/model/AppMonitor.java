package com.yl.model;

import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class AppMonitor {
    public long alreadyLockUseDateTime;
    public long beforeTimeCanUse;
    public long canEditTimeEnd;
    public long canEditTimeStart;
    public String cell;
    public String className;
    public long dayMonitorTime;
    public List<DisableTime> disableList;
    public int hours;
    public long id;
    public boolean isOpen;
    public long lastRecordUseTime;
    public String name;
    public String packageName;
    public long relativeTaskId;
    public List<Integer> repeat;
    public String text;
    public long todayUseDuration;
    public long useTime;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AppMonitor) && this.id == ((AppMonitor) obj).id;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.id));
    }
}
