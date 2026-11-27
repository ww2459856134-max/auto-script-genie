package com.chad.library.adapter.base.listener;

import android.graphics.Canvas;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public interface OnItemSwipeListener {
    void clearView(RecyclerView.d0 d0Var, int i2);

    void onItemSwipeMoving(Canvas canvas, RecyclerView.d0 d0Var, float f, float f2, boolean z);

    void onItemSwipeStart(RecyclerView.d0 d0Var, int i2);

    void onItemSwiped(RecyclerView.d0 d0Var, int i2);
}
