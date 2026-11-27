package com.chad.library.adapter.base;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.util.MultiTypeDelegate;
import com.chad.library.adapter.base.util.ProviderDelegate;
import java.util.List;

/* loaded from: classes.dex */
public abstract class MultipleItemRvAdapter<T, V extends BaseViewHolder> extends BaseQuickAdapter<T, V> {
    private SparseArray<BaseItemProvider> mItemProviders;
    private MultiTypeDelegate<T> mMultiTypeDelegate;
    protected ProviderDelegate mProviderDelegate;

    public MultipleItemRvAdapter(List<T> list) {
        super(list);
    }

    private void bindClick(final V v) {
        BaseQuickAdapter.OnItemClickListener onItemClickListener = getOnItemClickListener();
        BaseQuickAdapter.OnItemLongClickListener onItemLongClickListener = getOnItemLongClickListener();
        if (onItemClickListener == null || onItemLongClickListener == null) {
            if (onItemClickListener == null) {
                v.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.chad.library.adapter.base.MultipleItemRvAdapter.2
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        int adapterPosition = v.getAdapterPosition();
                        if (adapterPosition == -1) {
                            return;
                        }
                        int headerLayoutCount = adapterPosition - MultipleItemRvAdapter.this.getHeaderLayoutCount();
                        ((BaseItemProvider) MultipleItemRvAdapter.this.mItemProviders.get(v.getItemViewType())).onClick(v, MultipleItemRvAdapter.this.mData.get(headerLayoutCount), headerLayoutCount);
                    }
                });
            }
            if (onItemLongClickListener == null) {
                v.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.chad.library.adapter.base.MultipleItemRvAdapter.3
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view) {
                        int adapterPosition = v.getAdapterPosition();
                        if (adapterPosition == -1) {
                            return false;
                        }
                        int headerLayoutCount = adapterPosition - MultipleItemRvAdapter.this.getHeaderLayoutCount();
                        return ((BaseItemProvider) MultipleItemRvAdapter.this.mItemProviders.get(v.getItemViewType())).onLongClick(v, MultipleItemRvAdapter.this.mData.get(headerLayoutCount), headerLayoutCount);
                    }
                });
            }
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    protected void bindViewClickListener(V v) {
        if (v == null) {
            return;
        }
        bindClick(v);
        super.bindViewClickListener(v);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    protected void convert(V v, T t) {
        BaseItemProvider baseItemProvider = this.mItemProviders.get(v.getItemViewType());
        baseItemProvider.mContext = v.itemView.getContext();
        baseItemProvider.convert(v, t, v.getLayoutPosition() - getHeaderLayoutCount());
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    protected void convertPayloads(V v, T t, List<Object> list) {
        this.mItemProviders.get(v.getItemViewType()).convertPayloads(v, t, v.getLayoutPosition() - getHeaderLayoutCount(), list);
    }

    public void finishInitialize() {
        this.mProviderDelegate = new ProviderDelegate();
        setMultiTypeDelegate(new MultiTypeDelegate<T>() { // from class: com.chad.library.adapter.base.MultipleItemRvAdapter.1
            @Override // com.chad.library.adapter.base.util.MultiTypeDelegate
            protected int getItemType(T t) {
                return MultipleItemRvAdapter.this.getViewType(t);
            }
        });
        registerItemProvider();
        this.mItemProviders = this.mProviderDelegate.getItemProviders();
        for (int i2 = 0; i2 < this.mItemProviders.size(); i2++) {
            int iKeyAt = this.mItemProviders.keyAt(i2);
            BaseItemProvider baseItemProvider = this.mItemProviders.get(iKeyAt);
            baseItemProvider.mData = this.mData;
            getMultiTypeDelegate().registerItemType(iKeyAt, baseItemProvider.layout());
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    protected int getDefItemViewType(int i2) {
        if (getMultiTypeDelegate() != null) {
            return getMultiTypeDelegate().getDefItemViewType(this.mData, i2);
        }
        throw new IllegalStateException("please use setMultiTypeDelegate first!");
    }

    public MultiTypeDelegate<T> getMultiTypeDelegate() {
        return this.mMultiTypeDelegate;
    }

    protected abstract int getViewType(T t);

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    protected V onCreateDefViewHolder(ViewGroup viewGroup, int i2) {
        if (getMultiTypeDelegate() != null) {
            return createBaseViewHolder(viewGroup, getMultiTypeDelegate().getLayoutId(i2));
        }
        throw new IllegalStateException("please use setMultiTypeDelegate first!");
    }

    public abstract void registerItemProvider();

    public void setMultiTypeDelegate(MultiTypeDelegate<T> multiTypeDelegate) {
        this.mMultiTypeDelegate = multiTypeDelegate;
    }
}
