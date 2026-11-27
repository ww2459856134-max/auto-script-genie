package com.chad.library.adapter.base;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.k0;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;
import h.e.j.t;
import i.c.a.a;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BaseItemDraggableAdapter<T, K extends BaseViewHolder> extends BaseQuickAdapter<T, K> {
    private static final String ERROR_NOT_SAME_ITEMTOUCHHELPER = "Item drag and item swipe should pass the same ItemTouchHelper";
    private static final int NO_TOGGLE_VIEW = 0;
    protected boolean itemDragEnabled;
    protected boolean itemSwipeEnabled;
    protected boolean mDragOnLongPress;
    protected k0 mItemTouchHelper;
    protected OnItemDragListener mOnItemDragListener;
    protected OnItemSwipeListener mOnItemSwipeListener;
    protected View.OnLongClickListener mOnToggleViewLongClickListener;
    protected View.OnTouchListener mOnToggleViewTouchListener;
    protected int mToggleViewId;

    public BaseItemDraggableAdapter(List<T> list) {
        super(list);
        this.mToggleViewId = 0;
        this.itemDragEnabled = false;
        this.itemSwipeEnabled = false;
        this.mDragOnLongPress = true;
    }

    private boolean inRange(int i2) {
        return i2 >= 0 && i2 < this.mData.size();
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
        return d0Var.getAdapterPosition() - getHeaderLayoutCount();
    }

    public boolean hasToggleView() {
        return this.mToggleViewId != 0;
    }

    public boolean isItemDraggable() {
        return this.itemDragEnabled;
    }

    public boolean isItemSwipeEnable() {
        return this.itemSwipeEnabled;
    }

    public void onItemDragEnd(RecyclerView.d0 d0Var) {
        OnItemDragListener onItemDragListener = this.mOnItemDragListener;
        if (onItemDragListener == null || !this.itemDragEnabled) {
            return;
        }
        onItemDragListener.onItemDragEnd(d0Var, getViewHolderPosition(d0Var));
    }

    public void onItemDragMoving(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2) {
        int viewHolderPosition = getViewHolderPosition(d0Var);
        int viewHolderPosition2 = getViewHolderPosition(d0Var2);
        if (inRange(viewHolderPosition) && inRange(viewHolderPosition2)) {
            if (viewHolderPosition < viewHolderPosition2) {
                int i2 = viewHolderPosition;
                while (i2 < viewHolderPosition2) {
                    int i3 = i2 + 1;
                    Collections.swap(this.mData, i2, i3);
                    i2 = i3;
                }
            } else {
                for (int i4 = viewHolderPosition; i4 > viewHolderPosition2; i4--) {
                    Collections.swap(this.mData, i4, i4 - 1);
                }
            }
            notifyItemMoved(d0Var.getAdapterPosition(), d0Var2.getAdapterPosition());
        }
        OnItemDragListener onItemDragListener = this.mOnItemDragListener;
        if (onItemDragListener == null || !this.itemDragEnabled) {
            return;
        }
        onItemDragListener.onItemDragMoving(d0Var, viewHolderPosition, d0Var2, viewHolderPosition2);
    }

    public void onItemDragStart(RecyclerView.d0 d0Var) {
        OnItemDragListener onItemDragListener = this.mOnItemDragListener;
        if (onItemDragListener == null || !this.itemDragEnabled) {
            return;
        }
        onItemDragListener.onItemDragStart(d0Var, getViewHolderPosition(d0Var));
    }

    public void onItemSwipeClear(RecyclerView.d0 d0Var) {
        OnItemSwipeListener onItemSwipeListener = this.mOnItemSwipeListener;
        if (onItemSwipeListener == null || !this.itemSwipeEnabled) {
            return;
        }
        onItemSwipeListener.clearView(d0Var, getViewHolderPosition(d0Var));
    }

    public void onItemSwipeStart(RecyclerView.d0 d0Var) {
        OnItemSwipeListener onItemSwipeListener = this.mOnItemSwipeListener;
        if (onItemSwipeListener == null || !this.itemSwipeEnabled) {
            return;
        }
        onItemSwipeListener.onItemSwipeStart(d0Var, getViewHolderPosition(d0Var));
    }

    public void onItemSwiped(RecyclerView.d0 d0Var) {
        int viewHolderPosition = getViewHolderPosition(d0Var);
        if (inRange(viewHolderPosition)) {
            this.mData.remove(viewHolderPosition);
            notifyItemRemoved(d0Var.getAdapterPosition());
            OnItemSwipeListener onItemSwipeListener = this.mOnItemSwipeListener;
            if (onItemSwipeListener == null || !this.itemSwipeEnabled) {
                return;
            }
            onItemSwipeListener.onItemSwiped(d0Var, viewHolderPosition);
        }
    }

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
            this.mOnToggleViewLongClickListener = new View.OnLongClickListener() { // from class: com.chad.library.adapter.base.BaseItemDraggableAdapter.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    BaseItemDraggableAdapter baseItemDraggableAdapter = BaseItemDraggableAdapter.this;
                    k0 k0Var = baseItemDraggableAdapter.mItemTouchHelper;
                    if (k0Var == null || !baseItemDraggableAdapter.itemDragEnabled) {
                        return true;
                    }
                    k0Var.E((RecyclerView.d0) view.getTag(a.c));
                    return true;
                }
            };
        } else {
            this.mOnToggleViewTouchListener = new View.OnTouchListener() { // from class: com.chad.library.adapter.base.BaseItemDraggableAdapter.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (t.a(motionEvent) != 0) {
                        return false;
                    }
                    BaseItemDraggableAdapter baseItemDraggableAdapter = BaseItemDraggableAdapter.this;
                    if (baseItemDraggableAdapter.mDragOnLongPress) {
                        return false;
                    }
                    k0 k0Var = baseItemDraggableAdapter.mItemTouchHelper;
                    if (k0Var == null || !baseItemDraggableAdapter.itemDragEnabled) {
                        return true;
                    }
                    k0Var.E((RecyclerView.d0) view.getTag(a.c));
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

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(K k2, int i2) {
        View view;
        super.onBindViewHolder((BaseItemDraggableAdapter<T, K>) k2, i2);
        int itemViewType = k2.getItemViewType();
        if (this.mItemTouchHelper == null || !this.itemDragEnabled || itemViewType == 546 || itemViewType == 273 || itemViewType == 1365 || itemViewType == 819 || !hasToggleView() || (view = k2.getView(this.mToggleViewId)) == null) {
            return;
        }
        view.setTag(a.c, k2);
        if (this.mDragOnLongPress) {
            view.setOnLongClickListener(this.mOnToggleViewLongClickListener);
        } else {
            view.setOnTouchListener(this.mOnToggleViewTouchListener);
        }
    }

    public void enableDragItem(k0 k0Var, int i2, boolean z) {
        this.itemDragEnabled = true;
        this.mItemTouchHelper = k0Var;
        setToggleViewId(i2);
        setToggleDragOnLongPress(z);
    }

    public BaseItemDraggableAdapter(int i2, List<T> list) {
        super(i2, list);
        this.mToggleViewId = 0;
        this.itemDragEnabled = false;
        this.itemSwipeEnabled = false;
        this.mDragOnLongPress = true;
    }
}
