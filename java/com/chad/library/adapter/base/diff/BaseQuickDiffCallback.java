package com.chad.library.adapter.base.diff;

import androidx.recyclerview.widget.r;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BaseQuickDiffCallback<T> extends r.a {
    private List<T> newList;
    private List<T> oldList;

    public BaseQuickDiffCallback(List<T> list) {
        this.newList = list == null ? new ArrayList<>() : list;
    }

    @Override // androidx.recyclerview.widget.r.a
    public boolean areContentsTheSame(int i2, int i3) {
        return areContentsTheSame(this.oldList.get(i2), this.newList.get(i3));
    }

    protected abstract boolean areContentsTheSame(T t, T t2);

    @Override // androidx.recyclerview.widget.r.a
    public boolean areItemsTheSame(int i2, int i3) {
        return areItemsTheSame(this.oldList.get(i2), this.newList.get(i3));
    }

    protected abstract boolean areItemsTheSame(T t, T t2);

    @Override // androidx.recyclerview.widget.r.a
    public Object getChangePayload(int i2, int i3) {
        return getChangePayload(this.oldList.get(i2), this.newList.get(i3));
    }

    protected Object getChangePayload(T t, T t2) {
        return null;
    }

    public List<T> getNewList() {
        return this.newList;
    }

    @Override // androidx.recyclerview.widget.r.a
    public int getNewListSize() {
        return this.newList.size();
    }

    public List<T> getOldList() {
        return this.oldList;
    }

    @Override // androidx.recyclerview.widget.r.a
    public int getOldListSize() {
        return this.oldList.size();
    }

    public void setOldList(List<T> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.oldList = list;
    }
}
