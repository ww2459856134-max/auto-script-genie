package com.adapter;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.frame.v0;
import java.util.List;

/* loaded from: classes.dex */
public class TextAdapter extends BaseItemDraggableAdapter<String, BaseViewHolder> {
    private int a;

    public TextAdapter(List<String> list) {
        super(j.b.f.z0, list);
    }

    public void c(int i2) {
        this.a = i2;
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, String str) {
        baseViewHolder.addOnClickListener(j.b.e.O0);
        int i2 = j.b.e.k0;
        baseViewHolder.addOnClickListener(i2);
        baseViewHolder.setGone(i2, true);
        baseViewHolder.setText(j.b.e.v6, str);
        baseViewHolder.setBackgroundColor(j.b.e.t3, v0.g().getResources().getColor(this.a == baseViewHolder.getLayoutPosition() ? j.b.c.e : j.b.c.a));
    }

    public int e() {
        return this.a;
    }
}
