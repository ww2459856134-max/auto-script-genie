package com.adapter;

import android.widget.ImageView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.frame.v0;
import java.util.List;

/* loaded from: classes.dex */
public class ImageHorizontalAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public ImageHorizontalAdapter(List<String> list) {
        super(j.b.f.H0, list);
        v0.g().getPackageManager();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, String str) {
        com.bumptech.glide.c.t(v0.g()).w(str).q0((ImageView) baseViewHolder.getView(j.b.e.G3));
    }
}
