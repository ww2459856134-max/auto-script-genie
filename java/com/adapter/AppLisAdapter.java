package com.adapter;

import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.frame.k0;
import com.frame.l1;
import com.frame.v0;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class AppLisAdapter extends BaseQuickAdapter<ResolveInfo, BaseViewHolder> {
    private ExecutorService a;
    private List<String> b;
    private PackageManager c;
    public boolean d;

    public AppLisAdapter(List<ResolveInfo> list, boolean z) {
        super(j.b.f.e, list);
        this.a = Executors.newSingleThreadExecutor();
        this.b = new ArrayList();
        this.d = z;
        this.c = v0.g().getPackageManager();
    }

    static /* synthetic */ void g(BaseViewHolder baseViewHolder, Drawable drawable, String str) {
        baseViewHolder.setImageDrawable(j.b.e.G3, drawable);
        baseViewHolder.setText(j.b.e.d6, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(ResolveInfo resolveInfo, final BaseViewHolder baseViewHolder) {
        try {
            final Drawable drawableLoadIcon = resolveInfo.activityInfo.applicationInfo.loadIcon(this.c);
            final String string = resolveInfo.activityInfo.applicationInfo.loadLabel(this.c).toString();
            l1.e(new Runnable() { // from class: com.adapter.a
                @Override // java.lang.Runnable
                public final void run() {
                    AppLisAdapter.g(baseViewHolder, drawableLoadIcon, string);
                }
            });
        } catch (Exception e) {
            k0.r(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void convert(final BaseViewHolder baseViewHolder, final ResolveInfo resolveInfo) {
        this.a.execute(new Runnable() { // from class: com.adapter.b
            @Override // java.lang.Runnable
            public final void run() {
                this.c.i(resolveInfo, baseViewHolder);
            }
        });
        if (this.d) {
            baseViewHolder.getView(j.b.e.S1).setSelected(f(resolveInfo));
        } else {
            baseViewHolder.setVisible(j.b.e.H3, false);
        }
    }

    public List<String> d() {
        return this.b;
    }

    public boolean e(int i2) {
        return f(getItem(i2));
    }

    boolean f(ResolveInfo resolveInfo) {
        return this.b.contains(resolveInfo.activityInfo.packageName);
    }

    public void j(int i2) {
        this.b.add(getItem(i2).activityInfo.packageName);
    }

    public void k(List<String> list) {
        if (list != null) {
            this.b = list;
        } else {
            Log.e("AppLisAdapterNew", "selectedPackageNames不能为Null");
        }
    }

    public void l(int i2) {
        this.b.remove(getItem(i2).activityInfo.packageName);
    }
}
