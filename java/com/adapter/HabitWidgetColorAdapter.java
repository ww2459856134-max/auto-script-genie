package com.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.v.ColorView;
import java.util.List;

/* loaded from: classes.dex */
public class HabitWidgetColorAdapter extends BaseQuickAdapter<Integer, BaseViewHolder> {
    private int a;

    public HabitWidgetColorAdapter(List<Integer> list) {
        super(j.b.f.x0, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, Integer num) {
        baseViewHolder.getView(j.b.e.w4).setSelected(baseViewHolder.getAdapterPosition() == this.a);
        ((ColorView) baseViewHolder.getView(j.b.e.G3)).setColor(num.intValue());
    }

    public int d() {
        return this.a;
    }

    public void e(int i2) {
        this.a = i2;
        notifyDataSetChanged();
    }
}
