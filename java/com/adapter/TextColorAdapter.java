package com.adapter;

import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;

/* loaded from: classes.dex */
public class TextColorAdapter extends BaseQuickAdapter<Integer, BaseViewHolder> {
    private int a;

    public TextColorAdapter(List<Integer> list) {
        super(j.b.f.q1, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, Integer num) {
        baseViewHolder.getView(j.b.e.w4).setSelected(baseViewHolder.getAdapterPosition() == this.a);
        ((TextView) baseViewHolder.getView(j.b.e.G3)).setTextColor(num.intValue());
    }

    public int d() {
        return this.a;
    }

    public void e(int i2) {
        this.a = i2;
        notifyDataSetChanged();
    }
}
