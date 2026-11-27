package com.adapter;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;

/* loaded from: classes.dex */
public class ValueListAdapter extends BaseItemDraggableAdapter<String, BaseViewHolder> {
    public ValueListAdapter(List<String> list) {
        super(j.b.f.e1, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, String str) {
        baseViewHolder.setText(j.b.e.H5, str);
        baseViewHolder.addOnClickListener(j.b.e.O0);
    }
}
