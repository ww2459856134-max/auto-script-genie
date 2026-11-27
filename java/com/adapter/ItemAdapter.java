package com.adapter;

import android.widget.TextView;
import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.frame.v0;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class ItemAdapter extends BaseItemDraggableAdapter<String, BaseViewHolder> {
    private int a;
    private boolean b;
    private HashMap<Integer, String> c;

    public ItemAdapter(List<String> list) {
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
        int i2 = j.b.e.v6;
        baseViewHolder.setText(i2, str);
        baseViewHolder.setGone(j.b.e.O0, false);
        if (!this.b) {
            baseViewHolder.setBackgroundColor(j.b.e.t3, v0.g().getResources().getColor(this.a == baseViewHolder.getLayoutPosition() ? j.b.c.e : j.b.c.a));
            return;
        }
        TextView textView = (TextView) baseViewHolder.getView(i2);
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(j.b.d.f1746m, 0, 0, 0);
        textView.setSelected(this.c.containsKey(Integer.valueOf(baseViewHolder.getAdapterPosition())));
    }

    public int e() {
        return this.a;
    }

    public HashMap<Integer, String> f() {
        return this.c;
    }

    public boolean g() {
        return this.b;
    }

    public void h(boolean z) {
        this.b = z;
        if (z) {
            this.c = new HashMap<>();
        }
    }

    public void i(int i2) {
        if (this.c.containsKey(Integer.valueOf(i2))) {
            this.c.remove(Integer.valueOf(i2));
        } else {
            this.c.put(Integer.valueOf(i2), getItem(i2));
        }
        notifyItemChanged(i2);
    }
}
