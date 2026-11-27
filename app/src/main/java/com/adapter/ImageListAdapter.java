package com.adapter;

import android.widget.ImageView;
import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.frame.v0;
import java.util.List;

/* loaded from: classes.dex */
public class ImageListAdapter extends BaseItemDraggableAdapter<String, BaseViewHolder> {
    public ImageListAdapter(List<String> list) {
        super(j.b.f.F0, list);
    }

    public void c(int i2) {
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, String str) {
        com.bumptech.glide.c.t(v0.g()).w(str).q0((ImageView) baseViewHolder.getView(j.b.e.I3));
        baseViewHolder.setText(j.b.e.M5, baseViewHolder.getAdapterPosition() + "");
    }
}
