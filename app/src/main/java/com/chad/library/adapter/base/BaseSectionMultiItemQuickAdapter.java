package com.chad.library.adapter.base;

import android.util.SparseIntArray;
import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.IExpandable;
import com.chad.library.adapter.base.entity.SectionMultiEntity;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BaseSectionMultiItemQuickAdapter<T extends SectionMultiEntity, K extends BaseViewHolder> extends BaseQuickAdapter<T, K> {
    private static final int DEFAULT_VIEW_TYPE = -255;
    protected static final int SECTION_HEADER_VIEW = 1092;
    public static final int TYPE_NOT_FOUND = -404;
    private SparseIntArray layouts;
    protected int mSectionHeadResId;

    public BaseSectionMultiItemQuickAdapter(int i2, List<T> list) {
        super(list);
        this.mSectionHeadResId = i2;
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

    protected abstract void convertHead(K k2, T t);

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    protected int getDefItemViewType(int i2) {
        T t = this.mData.get(i2);
        return t != null ? t.isHeader ? SECTION_HEADER_VIEW : t.getItemType() : DEFAULT_VIEW_TYPE;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    protected boolean isFixedViewType(int i2) {
        return super.isFixedViewType(i2) || i2 == SECTION_HEADER_VIEW;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    protected K onCreateDefViewHolder(ViewGroup viewGroup, int i2) {
        return i2 == SECTION_HEADER_VIEW ? createBaseViewHolder(getItemView(this.mSectionHeadResId, viewGroup)) : createBaseViewHolder(viewGroup, getLayoutId(i2));
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
        int parentPosition = getParentPosition(t);
        if (parentPosition >= 0) {
            ((IExpandable) this.mData.get(parentPosition)).getSubItems().remove(t);
        }
    }

    protected void setDefaultViewTypeLayout(int i2) {
        addItemType(DEFAULT_VIEW_TYPE, i2);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(K k2, int i2) {
        if (k2.getItemViewType() != SECTION_HEADER_VIEW) {
            super.onBindViewHolder((BaseSectionMultiItemQuickAdapter<T, K>) k2, i2);
        } else {
            setFullSpan(k2);
            convertHead(k2, getItem(i2 - getHeaderLayoutCount()));
        }
    }
}
