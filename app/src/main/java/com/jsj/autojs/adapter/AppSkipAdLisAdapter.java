package com.jsj.autojs.adapter;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import android.widget.ImageView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.frame.v0;
import com.jsj.autojs.model.AppConfig;
import com.tencent.cursor.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class AppSkipAdLisAdapter extends BaseQuickAdapter<ResolveInfo, BaseViewHolder> {
    PackageManager a;
    private HashMap<String, AppConfig> b;

    public AppSkipAdLisAdapter(List<ResolveInfo> list, HashMap<String, AppConfig> map) {
        super(2131492931, list);
        new ArrayList();
        this.a = v0.g().getPackageManager();
        this.b = map;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, ResolveInfo resolveInfo) {
        ApplicationInfo applicationInfo = resolveInfo.activityInfo.applicationInfo;
        String string = applicationInfo.loadLabel(this.a).toString();
        com.bumptech.glide.c.t(v0.g()).s(applicationInfo.loadIcon(this.a)).q0((ImageView) baseViewHolder.getView(R.id.iv_icon));
        baseViewHolder.setText(2131297203, string);
        baseViewHolder.setGone(2131296555, true);
        try {
            baseViewHolder.setChecked(2131296555, this.b.containsKey(applicationInfo.packageName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void d(List<String> list) {
        if (list != null) {
            return;
        }
        Log.e("AppLisAdapterNew", "selectedPackageNames不能为Null");
    }
}
