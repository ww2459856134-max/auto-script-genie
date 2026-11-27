package com.jsj.autojs.adapter;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.widget.ImageView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.frame.v0;
import com.jsj.autojs.l.x;
import com.jsj.autojs.model.AppConfig;
import com.tencent.cursor.R;

/* loaded from: classes.dex */
public class NoADAdapter extends BaseQuickAdapter<AppConfig, BaseViewHolder> {
    PackageManager a;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, AppConfig appConfig) throws PackageManager.NameNotFoundException {
        try {
            ApplicationInfo applicationInfo = this.a.getApplicationInfo(appConfig.getPackageName(), 128);
            String string = applicationInfo.loadLabel(this.a).toString();
            com.bumptech.glide.c.t(v0.g()).s(applicationInfo.loadIcon(this.a)).q0((ImageView) baseViewHolder.getView(R.id.iv_icon));
            baseViewHolder.setText(2131297203, string);
            baseViewHolder.setText(2131297216, x.e().f(appConfig.getPackageName()) + "次");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
