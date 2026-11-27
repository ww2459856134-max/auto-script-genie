package com.chad.library.adapter.base;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.k0;
import com.chad.library.adapter.base.listener.IDraggableListener;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;
import h.e.j.t;
import i.c.a.a;
import java.util.Collections;

/* loaded from: classes.dex */
public class DraggableController implements IDraggableListener {
    private static final int NO_TOGGLE_VIEW = 0;
    private BaseQuickAdapter mAdapter;
    private k0 mItemTouchHelper;
    private OnItemDragListener mOnItemDragListener;
    private OnItemSwipeListener mOnItemSwipeListener;
    private View.OnLongClickListener mOnToggleViewLongClickListener;
    private View.OnTouchListener mOnToggleViewTouchListener;
    private int mToggleViewId = 0;
    private boolean itemDragEnabled = false;
    private boolean itemSwipeEnabled = false;
    private boolean mDragOnLongPress = true;

    public DraggableController(BaseQuickAdapter baseQuickAdapter) {
        this.mAdapter = baseQuickAdapter;
    }

    private boolean inRange(int i2) {
        return i2 >= 0 && i2 < this.mAdapter.getData().size();
    }

    public void disableDragItem() {
        this.itemDragEnabled = false;
        this.mItemTouchHelper = null;
    }

    public void disableSwipeItem() {
        this.itemSwipeEnabled = false;
    }

    public void enableDragItem(k0 k0Var) {
        enableDragItem(k0Var, 0, true);
    }

    public void enableSwipeItem() {
        this.itemSwipeEnabled = true;
    }

    public int getViewHolderPosition(RecyclerView.d0 d0Var) {
        return d0Var.getAdapterPosition() - this.mAdapter.getHeaderLayoutCount();
    }

    @Override // com.chad.library.adapter.base.listener.IDraggableListener
    public boolean hasToggleView() {
        return this.mToggleViewId != 0;
    }

    public void initView(BaseViewHolder baseViewHolder) {
        View view;
        int itemViewType = baseViewHolder.getItemViewType();
        if (this.mItemTouchHelper == null || !this.itemDragEnabled || itemViewType == 546 || itemViewType == 273 || itemViewType == 1365 || itemViewType == 819 || !hasToggleView() || (view = baseViewHolder.getView(this.mToggleViewId)) == null) {
            return;
        }
        view.setTag(a.c, baseViewHolder);
        if (this.mDragOnLongPress) {
            view.setOnLongClickListener(this.mOnToggleViewLongClickListener);
        } else {
            view.setOnTouchListener(this.mOnToggleViewTouchListener);
        }
    }

    @Override // com.chad.library.adapter.base.listener.IDraggableListener
    public boolean isItemDraggable() {
        return this.itemDragEnabled;
    }

    @Override // com.chad.library.adapter.base.listener.IDraggableListener
    public boolean isItemSwipeEnable() {
        return this.itemSwipeEnabled;
    }

    @Override // com.chad.library.adapter.base.listener.IDraggableListener
    public void onItemDragEnd(RecyclerView.d0 d0Var) {
        OnItemDragListener onItemDragListener = this.mOnItemDragListener;
        if (onItemDragListener == null || !this.itemDragEnabled) {
            return;
        }
        onItemDragListener.onItemDragEnd(d0Var, getViewHolderPosition(d0Var));
    }

    @Override // com.chad.library.adapter.base.listener.IDraggableListener
    public void onItemDragMoving(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2) {
        int viewHolderPosition = getViewHolderPosition(d0Var);
        int viewHolderPosition2 = getViewHolderPosition(d0Var2);
        if (inRange(viewHolderPosition) && inRange(viewHolderPosition2)) {
            if (viewHolderPosition < viewHolderPosition2) {
                int i2 = viewHolderPosition;
                while (i2 < viewHolderPosition2) {
                    int i3 = i2 + 1;
                    Collections.swap(this.mAdapter.getData(), i2, i3);
                    i2 = i3;
                }
            } else {
                for (int i4 = viewHolderPosition; i4 > viewHolderPosition2; i4--) {
                    Collections.swap(this.mAdapter.getData(), i4, i4 - 1);
                }
            }
            this.mAdapter.notifyItemMoved(d0Var.getAdapterPosition(), d0Var2.getAdapterPosition());
        }
        OnItemDragListener onItemDragListener = this.mOnItemDragListener;
        if (onItemDragListener == null || !this.itemDragEnabled) {
            return;
        }
        onItemDragListener.onItemDragMoving(d0Var, viewHolderPosition, d0Var2, viewHolderPosition2);
    }

    @Override // com.chad.library.adapter.base.listener.IDraggableListener
    public void onItemDragStart(RecyclerView.d0 d0Var) {
        OnItemDragListener onItemDragListener = this.mOnItemDragListener;
        if (onItemDragListener == null || !this.itemDragEnabled) {
            return;
        }
        onItemDragListener.onItemDragStart(d0Var, getViewHolderPosition(d0Var));
    }

    @Override // com.chad.library.adapter.base.listener.IDraggableListener
    public void onItemSwipeClear(RecyclerView.d0 d0Var) {
        OnItemSwipeListener onItemSwipeListener = this.mOnItemSwipeListener;
        if (onItemSwipeListener == null || !this.itemSwipeEnabled) {
            return;
        }
        onItemSwipeListener.clearView(d0Var, getViewHolderPosition(d0Var));
    }

    @Override // com.chad.library.adapter.base.listener.IDraggableListener
    public void onItemSwipeStart(RecyclerView.d0 d0Var) {
        OnItemSwipeListener onItemSwipeListener = this.mOnItemSwipeListener;
        if (onItemSwipeListener == null || !this.itemSwipeEnabled) {
            return;
        }
        onItemSwipeListener.onItemSwipeStart(d0Var, getViewHolderPosition(d0Var));
    }

    @Override // com.chad.library.adapter.base.listener.IDraggableListener
    public void onItemSwiped(RecyclerView.d0 d0Var) {
        OnItemSwipeListener onItemSwipeListener = this.mOnItemSwipeListener;
        if (onItemSwipeListener != null && this.itemSwipeEnabled) {
            onItemSwipeListener.onItemSwiped(d0Var, getViewHolderPosition(d0Var));
        }
        int viewHolderPosition = getViewHolderPosition(d0Var);
        if (inRange(viewHolderPosition)) {
            this.mAdapter.getData().remove(viewHolderPosition);
            this.mAdapter.notifyItemRemoved(d0Var.getAdapterPosition());
        }
    }

    @Override // com.chad.library.adapter.base.listener.IDraggableListener
    public void onItemSwiping(Canvas canvas, RecyclerView.d0 d0Var, float f, float f2, boolean z) {
        OnItemSwipeListener onItemSwipeListener = this.mOnItemSwipeListener;
        if (onItemSwipeListener == null || !this.itemSwipeEnabled) {
            return;
        }
        onItemSwipeListener.onItemSwipeMoving(canvas, d0Var, f, f2, z);
    }

    public void setOnItemDragListener(OnItemDragListener onItemDragListener) {
        this.mOnItemDragListener = onItemDragListener;
    }

    public void setOnItemSwipeListener(OnItemSwipeListener onItemSwipeListener) {
        this.mOnItemSwipeListener = onItemSwipeListener;
    }

    public void setToggleDragOnLongPress(boolean z) {
        this.mDragOnLongPress = z;
        if (z) {
            this.mOnToggleViewTouchListener = null;
            this.mOnToggleViewLongClickListener = new View.OnLongClickListener() { // from class: com.chad.library.adapter.base.DraggableController.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (DraggableController.this.mItemTouchHelper == null || !DraggableController.this.itemDragEnabled) {
                        return true;
                    }
                    DraggableController.this.mItemTouchHelper.E((RecyclerView.d0) view.getTag(a.c));
                    return true;
                }
            };
        } else {
            this.mOnToggleViewTouchListener = new View.OnTouchListener() { // from class: com.chad.library.adapter.base.DraggableController.2
                @Override // android.view.View.OnTouchListener
                @SuppressLint({"ClickableViewAccessibility"})
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (t.a(motionEvent) != 0 || DraggableController.this.mDragOnLongPress) {
                        return false;
                    }
                    if (DraggableController.this.mItemTouchHelper == null || !DraggableController.this.itemDragEnabled) {
                        return true;
                    }
                    DraggableController.this.mItemTouchHelper.E((RecyclerView.d0) view.getTag(a.c));
                    return true;
                }
            };
            this.mOnToggleViewLongClickListener = null;
        }
    }

    public void setToggleViewId(int i2) {
        this.mToggleViewId = i2;
    }

    public void enableDragItem(k0 k0Var, int i2) {
        enableDragItem(k0Var, i2, true);
    }

    public void enableDragItem(k0 k0Var, int i2, boolean z) {
        this.itemDragEnabled = true;
        this.mItemTouchHelper = k0Var;
        setToggleViewId(i2);
        setToggleDragOnLongPress(z);
    }
}
