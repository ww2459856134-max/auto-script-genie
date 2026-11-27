package com.chad.library.adapter.base;

import android.util.SparseIntArray;
import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.IExpandable;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BaseMultiItemQuickAdapter<T extends MultiItemEntity, K extends BaseViewHolder> extends BaseQuickAdapter<T, K> {
    private static final int DEFAULT_VIEW_TYPE = -255;
    public static final int TYPE_NOT_FOUND = -404;
    private SparseIntArray layouts;

    public BaseMultiItemQuickAdapter(List<T> list) {
        super(list);
    }

    private int getLayoutId(int i2) {
        return this.layouts.get(i2, -404);
    }

    protected void addItemType(int i2, int i3) {
        if (this.layouts == null) {
            this.layouts = new SparseIntArray();
        }
        this.layouts.put(i2, i3);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    protected int getDefItemViewType(int i2) {
        T t = this.mData.get(i2);
        return t != null ? t.getItemType() : DEFAULT_VIEW_TYPE;
    }

    public int getParentPositionInAll(int i2) {
        List<T> data = getData();
        T item = getItem(i2);
        if (!isExpandable((MultiItemEntity) item)) {
            for (int i3 = i2 - 1; i3 >= 0; i3--) {
                if (isExpandable((MultiItemEntity) data.get(i3))) {
                    return i3;
                }
            }
            return -1;
        }
        IExpandable iExpandable = (IExpandable) item;
        for (int i4 = i2 - 1; i4 >= 0; i4--) {
            T t = data.get(i4);
            if (isExpandable((MultiItemEntity) t) && iExpandable.getLevel() > ((IExpandable) t).getLevel()) {
                return i4;
            }
        }
        return -1;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    protected K onCreateDefViewHolder(ViewGroup viewGroup, int i2) {
        return createBaseViewHolder(viewGroup, getLayoutId(i2));
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void remove(int i2) {
        List<T> list = this.mData;
        if (list == null || i2 < 0 || i2 >= list.size()) {
            return;
        }
        T t = this.mData.get(i2);
        if (t instanceof IExpandable) {
            removeAllChild((IExpandable) t, i2);
        }
        removeDataFromParent(t);
        super.remove(i2);
    }

    protected void removeAllChild(IExpandable iExpandable, int i2) {
        List subItems;
        if (!iExpandable.isExpanded() || (subItems = iExpandable.getSubItems()) == null || subItems.size() == 0) {
            return;
        }
        int size = subItems.size();
        for (int i3 = 0; i3 < size; i3++) {
            remove(i2 + 1);
        }
    }

    protected void removeDataFromParent(T t) {
        IExpandable iExpandable;
        int parentPosition = getParentPosition(t);
        if (parentPosition < 0 || (iExpandable = (IExpandable) this.mData.get(parentPosition)) == t) {
            return;
        }
        iExpandable.getSubItems().remove(t);
    }

    protected void setDefaultViewTypeLayout(int i2) {
        addItemType(DEFAULT_VIEW_TYPE, i2);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public boolean isExpandable(MultiItemEntity multiItemEntity) {
        return multiItemEntity != null && (multiItemEntity instanceof IExpandable);
    }
}
