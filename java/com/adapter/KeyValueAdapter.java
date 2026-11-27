package com.adapter;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;

/* loaded from: classes.dex */
public class KeyValueAdapter extends BaseItemDraggableAdapter<String, BaseViewHolder> {
    public KeyValueAdapter(List<String> list) {
        super(j.b.f.M0, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, String str) {
        String[] strArrSplit = str.split("=");
        if (strArrSplit.length < 2) {
            return;
        }
        baseViewHolder.setText(j.b.e.H5, strArrSplit[0]);
        baseViewHolder.setText(j.b.e.Z5, strArrSplit[1]);
        baseViewHolder.addOnClickListener(j.b.e.O0);
    }
}
