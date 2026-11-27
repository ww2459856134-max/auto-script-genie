package com.chad.library.adapter.base.diff;

import androidx.recyclerview.widget.s0;
import com.chad.library.adapter.base.BaseQuickAdapter;

/* loaded from: classes.dex */
public final class BaseQuickAdapterListUpdateCallback implements s0 {
    private final BaseQuickAdapter mAdapter;

    public BaseQuickAdapterListUpdateCallback(BaseQuickAdapter baseQuickAdapter) {
        this.mAdapter = baseQuickAdapter;
    }

    @Override // androidx.recyclerview.widget.s0
    public void onChanged(int i2, int i3, Object obj) {
        BaseQuickAdapter baseQuickAdapter = this.mAdapter;
        baseQuickAdapter.notifyItemRangeChanged(i2 + baseQuickAdapter.getHeaderLayoutCount(), i3, obj);
    }

    @Override // androidx.recyclerview.widget.s0
    public void onInserted(int i2, int i3) {
        BaseQuickAdapter baseQuickAdapter = this.mAdapter;
        baseQuickAdapter.notifyItemRangeInserted(i2 + baseQuickAdapter.getHeaderLayoutCount(), i3);
    }

    @Override // androidx.recyclerview.widget.s0
    public void onMoved(int i2, int i3) {
        BaseQuickAdapter baseQuickAdapter = this.mAdapter;
        baseQuickAdapter.notifyItemMoved(i2 + baseQuickAdapter.getHeaderLayoutCount(), i3 + this.mAdapter.getHeaderLayoutCount());
    }

    @Override // androidx.recyclerview.widget.s0
    public void onRemoved(int i2, int i3) {
        BaseQuickAdapter baseQuickAdapter = this.mAdapter;
        baseQuickAdapter.notifyItemRangeRemoved(i2 + baseQuickAdapter.getHeaderLayoutCount(), i3);
    }
}
