package com.auto.dialog;

import android.graphics.Color;
import android.widget.TextView;
import com.bumptech.glide.c;
import com.bumptech.glide.load.x.b0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.frame.p1;
import com.frame.v0;
import com.makeramen.roundedimageview.RoundedImageView;
import j.b.e;
import j.b.f;
import wallpaper.WallpaperSetting;

/* loaded from: classes.dex */
public class WallPaperAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    private String a;

    public WallPaperAdapter() {
        super(f.r1, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, String str) {
        RoundedImageView roundedImageView = (RoundedImageView) baseViewHolder.getView(e.R1);
        boolean zP = WallpaperSetting.p(str);
        c.t(v0.g()).w(str).Z(true).f(b0.b).q0(roundedImageView);
        TextView textView = (TextView) baseViewHolder.getView(e.n6);
        if (textView != null) {
            textView.setVisibility(zP ? 0 : 8);
            textView.setText(zP ? "默认浅蓝 · 无需相册" : "");
        }
        roundedImageView.setContentDescription(zP ? "默认浅蓝色壁纸" : "自定义壁纸");
        if (!str.equals(this.a)) {
            roundedImageView.setBorderColor(0);
            roundedImageView.setBorderWidth(0.0f);
            baseViewHolder.setGone(e.u6, false);
            return;
        }
        roundedImageView.setBorderColor(Color.parseColor("#55CA9B"));
        roundedImageView.setBorderWidth(p1.c(2.0f));
        baseViewHolder.setGone(e.u6, true);
        roundedImageView.setContentDescription(((Object) roundedImageView.getContentDescription()) + "，当前壁纸");
    }

    public String d() {
        return this.a;
    }

    public void e(String str) {
        this.a = str;
    }
}
