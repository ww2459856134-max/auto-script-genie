package com.yl.model;

import java.util.ArrayList;
import java.util.Objects;

/* loaded from: classes.dex */
public class AutoNotify {
    public boolean clickNotify;
    public ArrayList<String> keyword;
    public boolean lastTaskRunGoOn = true;
    public String pn;
    public long taskId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AutoNotify) && this.taskId == ((AutoNotify) obj).taskId;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.taskId));
    }
}
