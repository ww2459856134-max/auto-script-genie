package com.chad.library.adapter.base;

import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.SectionEntity;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BaseSectionQuickAdapter<T extends SectionEntity, K extends BaseViewHolder> extends BaseQuickAdapter<T, K> {
    protected static final int SECTION_HEADER_VIEW = 1092;
    protected int mSectionHeadResId;

    public BaseSectionQuickAdapter(int i2, int i3, List<T> list) {
        super(i2, list);
        this.mSectionHeadResId = i3;
    }

    protected abstract void convertHead(K k2, T t);

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    protected int getDefItemViewType(int i2) {
        if (this.mData.get(i2).isHeader) {
            return SECTION_HEADER_VIEW;
        }
        return 0;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    protected boolean isFixedViewType(int i2) {
        return super.isFixedViewType(i2) || i2 == SECTION_HEADER_VIEW;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    protected K onCreateDefViewHolder(ViewGroup viewGroup, int i2) {
        return i2 == SECTION_HEADER_VIEW ? createBaseViewHolder(getItemView(this.mSectionHeadResId, viewGroup)) : (K) super.onCreateDefViewHolder(viewGroup, i2);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(K k2, int i2) {
        if (k2.getItemViewType() != SECTION_HEADER_VIEW) {
            super.onBindViewHolder((BaseSectionQuickAdapter<T, K>) k2, i2);
        } else {
            setFullSpan(k2);
            convertHead(k2, getItem(i2 - getHeaderLayoutCount()));
        }
    }
}
