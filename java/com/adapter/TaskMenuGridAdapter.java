package com.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;

/* loaded from: classes.dex */
public class TaskMenuGridAdapter extends BaseQuickAdapter<a, BaseViewHolder> {

    public static class a {
        public final String a;
        public final int b;

        public a(String str, int i2) {
            this.a = str;
            this.b = i2;
        }
    }

    public TaskMenuGridAdapter(List<a> list) {
        super(j.b.f.b1, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, a aVar) {
        baseViewHolder.setText(j.b.e.w6, aVar.a);
        baseViewHolder.setImageResource(j.b.e.G3, aVar.b);
    }
}
