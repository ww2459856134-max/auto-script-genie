package com.adapter;

import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.frame.l1;
import com.frame.v0;
import com.frame.y0;
import com.yl.model.AlarmTask;
import com.yl.model.TaskSimple;
import i.b.da;
import i.b.i7;
import i.b.k8;
import i.b.l7;
import i.b.w7;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class MultiTaskSimpleAdapter extends BaseMultiItemQuickAdapter<TaskSimple, BaseViewHolder> {
    private ExecutorService a;
    private PackageManager b;
    private boolean c;
    private HashMap<Integer, TaskSimple> d;
    private TaskSimple e;
    private long f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f414h;

    public MultiTaskSimpleAdapter(List<TaskSimple> list) {
        super(list);
        this.a = Executors.newSingleThreadExecutor();
        this.g = v0.g().getResources().getColor(j.b.c.c);
        this.f414h = false;
        this.b = v0.g().getPackageManager();
        this.f = da.B().J();
        int i2 = j.b.f.d1;
        addItemType(1, i2);
        addItemType(2, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(TaskSimple taskSimple, final BaseViewHolder baseViewHolder) {
        try {
            final Drawable drawableLoadIcon = this.b.getApplicationInfo(taskSimple.getPn(), 128).loadIcon(this.b);
            l1.e(new Runnable() { // from class: com.adapter.e
                @Override // java.lang.Runnable
                public final void run() {
                    baseViewHolder.setImageDrawable(j.b.e.G3, drawableLoadIcon);
                }
            });
        } catch (Exception unused) {
        }
        try {
            final boolean z = true;
            final boolean z2 = w7.g().f(taskSimple.getId()) != null;
            l1.e(new Runnable() { // from class: com.adapter.h
                @Override // java.lang.Runnable
                public final void run() {
                    baseViewHolder.setGone(j.b.e.n0, z2);
                }
            });
            List<AlarmTask> listJ = i7.p().j(taskSimple.getId());
            final boolean z3 = (listJ == null || listJ.isEmpty()) ? false : true;
            l1.e(new Runnable() { // from class: com.adapter.f
                @Override // java.lang.Runnable
                public final void run() {
                    baseViewHolder.setGone(j.b.e.Z, z3);
                }
            });
            if (l7.b().a(taskSimple.getId()) == null) {
                z = false;
            }
            l1.e(new Runnable() { // from class: com.adapter.d
                @Override // java.lang.Runnable
                public final void run() {
                    baseViewHolder.setGone(j.b.e.c0, z);
                }
            });
            final boolean zC = k8.d().c(taskSimple.getId());
            l1.e(new Runnable() { // from class: com.adapter.g
                @Override // java.lang.Runnable
                public final void run() {
                    baseViewHolder.setGone(j.b.e.d0, zC);
                }
            });
        } catch (Exception e) {
            y0.l(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void convert(final BaseViewHolder baseViewHolder, final TaskSimple taskSimple) {
        int i2 = j.b.e.n6;
        baseViewHolder.setText(i2, taskSimple.getName());
        int i3 = j.b.e.G3;
        baseViewHolder.setImageDrawable(i3, null);
        if (taskSimple.getRepeatCount() != 0) {
            int i4 = j.b.e.g6;
            baseViewHolder.setGone(i4, true);
            if (taskSimple.getRepeatCount() == -1) {
                baseViewHolder.setText(i4, "(无限循环)");
            } else {
                baseViewHolder.setText(i4, "(循环:" + taskSimple.getRepeatCount() + "次)");
            }
        } else {
            baseViewHolder.setGone(j.b.e.g6, false);
        }
        if ("group".equals(taskSimple.getPn())) {
            baseViewHolder.setGone(j.b.e.P0, false);
            baseViewHolder.setGone(j.b.e.S0, false);
            baseViewHolder.setGone(j.b.e.n0, false);
            baseViewHolder.setGone(j.b.e.Z, false);
            baseViewHolder.setGone(j.b.e.c0, false);
            int i5 = j.b.e.q0;
            baseViewHolder.setGone(i5, true);
            baseViewHolder.addOnClickListener(i5);
            baseViewHolder.setImageResource(i3, j.b.d.r);
            if (taskSimple.isExpanded()) {
                baseViewHolder.setText(i5, "收起分组");
            } else {
                baseViewHolder.setText(i5, "展开分组");
            }
        } else if (!this.c) {
            baseViewHolder.setGone(j.b.e.P0, this.f == taskSimple.getId());
            baseViewHolder.setGone(j.b.e.S0, true);
            baseViewHolder.setGone(j.b.e.q0, false);
            if (taskSimple.getLevel() == 1) {
                baseViewHolder.setVisible(i3, false);
                baseViewHolder.setTextColor(i2, Color.parseColor("#aa777777"));
            } else {
                baseViewHolder.setVisible(i3, true);
                baseViewHolder.setTextColor(i2, this.g);
            }
            this.a.execute(new Runnable() { // from class: com.adapter.i
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.k(taskSimple, baseViewHolder);
                }
            });
        }
        if ((!this.c && !this.f414h) || "group".equals(taskSimple.getPn())) {
            baseViewHolder.setGone(j.b.e.k1, false);
            baseViewHolder.addOnClickListener(j.b.e.n0);
            baseViewHolder.addOnClickListener(j.b.e.Z);
            baseViewHolder.addOnClickListener(j.b.e.c0);
            baseViewHolder.addOnClickListener(j.b.e.P0);
            return;
        }
        if (this.c) {
            int i6 = j.b.e.k1;
            baseViewHolder.setVisible(i6, true);
            baseViewHolder.getView(i6).setSelected(this.d.containsKey(Integer.valueOf(baseViewHolder.getAdapterPosition())));
        } else if (this.f414h) {
            int i7 = j.b.e.k1;
            baseViewHolder.setVisible(i7, true);
            baseViewHolder.getView(i7).setSelected(this.e == taskSimple);
        }
        baseViewHolder.setGone(j.b.e.P0, false);
        baseViewHolder.setGone(j.b.e.S0, false);
        baseViewHolder.setGone(j.b.e.q0, false);
        baseViewHolder.setGone(i3, false);
        baseViewHolder.setGone(j.b.e.c0, false);
        baseViewHolder.setGone(j.b.e.n0, false);
        baseViewHolder.setGone(j.b.e.Z, false);
    }

    public TaskSimple d() {
        return this.e;
    }

    public void l(long j2) {
        this.f = j2;
    }

    public void m(TaskSimple taskSimple) {
        this.e = taskSimple;
        notifyDataSetChanged();
    }

    public void n(boolean z) {
        this.f414h = z;
    }
}
