package com.jsj.autojs.adapter;

import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.frame.l1;
import com.frame.v0;
import com.tencent.cursor.R;
import com.yl.model.Node;
import com.yl.model.TaskSimple;
import i.b.da;
import i.b.g8;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class PageScanAdapter extends BaseQuickAdapter<Node, BaseViewHolder> {
    private ExecutorService a;
    private List<Node> b;
    boolean c;
    private PackageManager d;

    public PageScanAdapter(List<Node> list) {
        super(2131493078, list);
        this.a = Executors.newSingleThreadExecutor();
        this.b = new ArrayList();
        this.d = v0.g().getPackageManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(Node node, final BaseViewHolder baseViewHolder) {
        try {
            final Drawable drawableLoadIcon = g8.d().a(node.url).activityInfo.applicationInfo.loadIcon(this.d);
            l1.e(new Runnable() { // from class: com.jsj.autojs.adapter.a
                @Override // java.lang.Runnable
                public final void run() {
                    baseViewHolder.setImageDrawable(R.id.icon, drawableLoadIcon);
                }
            });
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void convert(final BaseViewHolder baseViewHolder, final Node node) {
        baseViewHolder.addOnClickListener(2131297248).addOnClickListener(2131296546);
        View view = baseViewHolder.getView(2131296546);
        view.setSelected(e(node));
        view.setVisibility(this.c ? 0 : 8);
        baseViewHolder.setText(R.id.tv_title, node.getName());
        TaskSimple taskSimpleW = da.B().w(node.nextId);
        if (taskSimpleW == null) {
            baseViewHolder.setText(2131297248, "未设置任务");
        } else {
            baseViewHolder.setText(2131297248, taskSimpleW.getName());
        }
        baseViewHolder.setText(R.id.tv_content, node.url);
        this.a.execute(new Runnable() { // from class: com.jsj.autojs.adapter.b
            @Override // java.lang.Runnable
            public final void run() {
                this.c.h(node, baseViewHolder);
            }
        });
    }

    public boolean d(int i2) {
        return e(getItem(i2));
    }

    boolean e(Node node) {
        return this.b.contains(node);
    }

    public void i(int i2) {
        this.b.add(getItem(i2));
    }

    public void j(int i2) {
        if (d(i2)) {
            k(i2);
        } else {
            i(i2);
        }
        notifyItemChanged(i2);
    }

    public void k(int i2) {
        this.b.remove(getItem(i2));
    }
}
