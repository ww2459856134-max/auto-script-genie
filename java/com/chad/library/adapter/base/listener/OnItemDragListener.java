package com.chad.library.adapter.base.listener;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public interface OnItemDragListener {
    void onItemDragEnd(RecyclerView.d0 d0Var, int i2);

    void onItemDragMoving(RecyclerView.d0 d0Var, int i2, RecyclerView.d0 d0Var2, int i3);

    void onItemDragStart(RecyclerView.d0 d0Var, int i2);
}
