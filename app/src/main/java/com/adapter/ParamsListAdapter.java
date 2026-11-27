package com.adapter;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import i.b.da;
import java.util.List;

/* loaded from: classes.dex */
public class ParamsListAdapter extends BaseItemDraggableAdapter<String, BaseViewHolder> {
    public ParamsListAdapter(List<String> list) {
        super(j.b.f.X0, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, String str) {
        baseViewHolder.setText(j.b.e.K5, str).setText(j.b.e.Z5, da.B().H(str));
    }
}
