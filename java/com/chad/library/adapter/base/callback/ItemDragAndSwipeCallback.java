package com.chad.library.adapter.base.callback;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.k0;
import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.DraggableController;
import com.chad.library.adapter.base.listener.IDraggableListener;
import i.c.a.a;

/* loaded from: classes.dex */
public class ItemDragAndSwipeCallback extends k0.a {
    private BaseItemDraggableAdapter mBaseItemDraggableAdapter;
    private IDraggableListener mDraggableListener;
    private float mMoveThreshold = 0.1f;
    private float mSwipeThreshold = 0.7f;
    private int mDragMoveFlags = 15;
    private int mSwipeMoveFlags = 32;

    public ItemDragAndSwipeCallback(BaseItemDraggableAdapter baseItemDraggableAdapter) {
        this.mBaseItemDraggableAdapter = baseItemDraggableAdapter;
    }

    private boolean isViewCreateByAdapter(RecyclerView.d0 d0Var) {
        int itemViewType = d0Var.getItemViewType();
        return itemViewType == 273 || itemViewType == 546 || itemViewType == 819 || itemViewType == 1365;
    }

    @Override // androidx.recyclerview.widget.k0.a
    public void clearView(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
        super.clearView(recyclerView, d0Var);
        if (isViewCreateByAdapter(d0Var)) {
            return;
        }
        View view = d0Var.itemView;
        int i2 = a.a;
        if (view.getTag(i2) != null && ((Boolean) d0Var.itemView.getTag(i2)).booleanValue()) {
            BaseItemDraggableAdapter baseItemDraggableAdapter = this.mBaseItemDraggableAdapter;
            if (baseItemDraggableAdapter != null) {
                baseItemDraggableAdapter.onItemDragEnd(d0Var);
            } else {
                IDraggableListener iDraggableListener = this.mDraggableListener;
                if (iDraggableListener != null) {
                    iDraggableListener.onItemDragEnd(d0Var);
                }
            }
            d0Var.itemView.setTag(i2, Boolean.FALSE);
        }
        View view2 = d0Var.itemView;
        int i3 = a.b;
        if (view2.getTag(i3) == null || !((Boolean) d0Var.itemView.getTag(i3)).booleanValue()) {
            return;
        }
        BaseItemDraggableAdapter baseItemDraggableAdapter2 = this.mBaseItemDraggableAdapter;
        if (baseItemDraggableAdapter2 != null) {
            baseItemDraggableAdapter2.onItemSwipeClear(d0Var);
        } else {
            IDraggableListener iDraggableListener2 = this.mDraggableListener;
            if (iDraggableListener2 != null) {
                iDraggableListener2.onItemSwipeClear(d0Var);
            }
        }
        d0Var.itemView.setTag(i3, Boolean.FALSE);
    }

    @Override // androidx.recyclerview.widget.k0.a
    public float getMoveThreshold(RecyclerView.d0 d0Var) {
        return this.mMoveThreshold;
    }

    @Override // androidx.recyclerview.widget.k0.a
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
        return isViewCreateByAdapter(d0Var) ? k0.a.d(0, 0) : k0.a.d(this.mDragMoveFlags, this.mSwipeMoveFlags);
    }

    @Override // androidx.recyclerview.widget.k0.a
    public float getSwipeThreshold(RecyclerView.d0 d0Var) {
        return this.mSwipeThreshold;
    }

    @Override // androidx.recyclerview.widget.k0.a
    public boolean isItemViewSwipeEnabled() {
        BaseItemDraggableAdapter baseItemDraggableAdapter = this.mBaseItemDraggableAdapter;
        if (baseItemDraggableAdapter != null) {
            return baseItemDraggableAdapter.isItemSwipeEnable();
        }
        IDraggableListener iDraggableListener = this.mDraggableListener;
        if (iDraggableListener != null) {
            return iDraggableListener.isItemSwipeEnable();
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.k0.a
    public boolean isLongPressDragEnabled() {
        BaseItemDraggableAdapter baseItemDraggableAdapter = this.mBaseItemDraggableAdapter;
        if (baseItemDraggableAdapter != null) {
            return baseItemDraggableAdapter.isItemDraggable() && !this.mBaseItemDraggableAdapter.hasToggleView();
        }
        IDraggableListener iDraggableListener = this.mDraggableListener;
        if (iDraggableListener != null) {
            return iDraggableListener.isItemDraggable() && !this.mDraggableListener.hasToggleView();
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.k0.a
    public void onChildDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.d0 d0Var, float f, float f2, int i2, boolean z) {
        super.onChildDrawOver(canvas, recyclerView, d0Var, f, f2, i2, z);
        if (i2 != 1 || isViewCreateByAdapter(d0Var)) {
            return;
        }
        View view = d0Var.itemView;
        canvas.save();
        if (f > 0.0f) {
            canvas.clipRect(view.getLeft(), view.getTop(), view.getLeft() + f, view.getBottom());
            canvas.translate(view.getLeft(), view.getTop());
        } else {
            canvas.clipRect(view.getRight() + f, view.getTop(), view.getRight(), view.getBottom());
            canvas.translate(view.getRight() + f, view.getTop());
        }
        BaseItemDraggableAdapter baseItemDraggableAdapter = this.mBaseItemDraggableAdapter;
        if (baseItemDraggableAdapter != null) {
            baseItemDraggableAdapter.onItemSwiping(canvas, d0Var, f, f2, z);
        } else {
            IDraggableListener iDraggableListener = this.mDraggableListener;
            if (iDraggableListener != null) {
                iDraggableListener.onItemSwiping(canvas, d0Var, f, f2, z);
            }
        }
        canvas.restore();
    }

    @Override // androidx.recyclerview.widget.k0.a
    public boolean onMove(RecyclerView recyclerView, RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2) {
        return d0Var.getItemViewType() == d0Var2.getItemViewType();
    }

    @Override // androidx.recyclerview.widget.k0.a
    public void onMoved(RecyclerView recyclerView, RecyclerView.d0 d0Var, int i2, RecyclerView.d0 d0Var2, int i3, int i4, int i5) {
        super.onMoved(recyclerView, d0Var, i2, d0Var2, i3, i4, i5);
        BaseItemDraggableAdapter baseItemDraggableAdapter = this.mBaseItemDraggableAdapter;
        if (baseItemDraggableAdapter != null) {
            baseItemDraggableAdapter.onItemDragMoving(d0Var, d0Var2);
            return;
        }
        IDraggableListener iDraggableListener = this.mDraggableListener;
        if (iDraggableListener != null) {
            iDraggableListener.onItemDragMoving(d0Var, d0Var2);
        }
    }

    @Override // androidx.recyclerview.widget.k0.a
    public void onSelectedChanged(RecyclerView.d0 d0Var, int i2) {
        if (i2 == 2 && !isViewCreateByAdapter(d0Var)) {
            BaseItemDraggableAdapter baseItemDraggableAdapter = this.mBaseItemDraggableAdapter;
            if (baseItemDraggableAdapter != null) {
                baseItemDraggableAdapter.onItemDragStart(d0Var);
            } else {
                IDraggableListener iDraggableListener = this.mDraggableListener;
                if (iDraggableListener != null) {
                    iDraggableListener.onItemDragStart(d0Var);
                }
            }
            d0Var.itemView.setTag(a.a, Boolean.TRUE);
        } else if (i2 == 1 && !isViewCreateByAdapter(d0Var)) {
            BaseItemDraggableAdapter baseItemDraggableAdapter2 = this.mBaseItemDraggableAdapter;
            if (baseItemDraggableAdapter2 != null) {
                baseItemDraggableAdapter2.onItemSwipeStart(d0Var);
            } else {
                IDraggableListener iDraggableListener2 = this.mDraggableListener;
                if (iDraggableListener2 != null) {
                    iDraggableListener2.onItemSwipeStart(d0Var);
                }
            }
            d0Var.itemView.setTag(a.b, Boolean.TRUE);
        }
        super.onSelectedChanged(d0Var, i2);
    }

    @Override // androidx.recyclerview.widget.k0.a
    public void onSwiped(RecyclerView.d0 d0Var, int i2) {
        if (isViewCreateByAdapter(d0Var)) {
            return;
        }
        BaseItemDraggableAdapter baseItemDraggableAdapter = this.mBaseItemDraggableAdapter;
        if (baseItemDraggableAdapter != null) {
            baseItemDraggableAdapter.onItemSwiped(d0Var);
            return;
        }
        IDraggableListener iDraggableListener = this.mDraggableListener;
        if (iDraggableListener != null) {
            iDraggableListener.onItemSwiped(d0Var);
        }
    }

    public void setDragMoveFlags(int i2) {
        this.mDragMoveFlags = i2;
    }

    public void setMoveThreshold(float f) {
        this.mMoveThreshold = f;
    }

    public void setSwipeMoveFlags(int i2) {
        this.mSwipeMoveFlags = i2;
    }

    public void setSwipeThreshold(float f) {
        this.mSwipeThreshold = f;
    }

    public ItemDragAndSwipeCallback(DraggableController draggableController) {
        this.mDraggableListener = draggableController;
    }
}
