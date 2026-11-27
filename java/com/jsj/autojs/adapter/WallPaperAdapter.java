package com.jsj.autojs.adapter;

import android.graphics.Color;
import com.bumptech.glide.load.x.b0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.frame.p1;
import com.frame.v0;
import com.makeramen.roundedimageview.RoundedImageView;

/* loaded from: classes.dex */
public class WallPaperAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    private String a;

    public WallPaperAdapter() {
        super(2131493183, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, String str) {
        RoundedImageView roundedImageView = (RoundedImageView) baseViewHolder.getView(2131296647);
        com.bumptech.glide.c.t(v0.g()).w(str).Z(true).f(b0.b).q0(roundedImageView);
        if (!str.equals(this.a)) {
            roundedImageView.setBorderColor(0);
            baseViewHolder.setGone(2131297282, false);
        } else {
            roundedImageView.setBorderColor(Color.parseColor("#55CA9B"));
            roundedImageView.setBorderWidth(p1.c(2.0f));
            baseViewHolder.setGone(2131297282, true);
        }
    }
}
