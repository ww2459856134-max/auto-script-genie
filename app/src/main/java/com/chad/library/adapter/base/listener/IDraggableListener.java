package com.chad.library.adapter.base.listener;

import android.graphics.Canvas;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public interface IDraggableListener {
    boolean hasToggleView();

    boolean isItemDraggable();

    boolean isItemSwipeEnable();

    void onItemDragEnd(RecyclerView.d0 d0Var);

    void onItemDragMoving(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2);

    void onItemDragStart(RecyclerView.d0 d0Var);

    void onItemSwipeClear(RecyclerView.d0 d0Var);

    void onItemSwipeStart(RecyclerView.d0 d0Var);

    void onItemSwiped(RecyclerView.d0 d0Var);

    void onItemSwiping(Canvas canvas, RecyclerView.d0 d0Var, float f, float f2, boolean z);
}
