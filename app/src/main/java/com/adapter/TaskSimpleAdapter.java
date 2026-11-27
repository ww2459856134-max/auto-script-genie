package com.adapter;

import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.frame.k0;
import com.frame.l1;
import com.frame.v0;
import com.frame.y0;
import com.yl.model.AlarmTask;
import com.yl.model.TaskSimple;
import i.b.da;
import i.b.i7;
import i.b.l7;
import i.b.w7;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class TaskSimpleAdapter extends BaseItemDraggableAdapter<TaskSimple, BaseViewHolder> {
    private ExecutorService a;
    private PackageManager b;
    private boolean c;
    private HashMap<Integer, TaskSimple> d;
    private long e;

    public TaskSimpleAdapter(List<TaskSimple> list) {
        super(j.b.f.d1, list);
        this.a = Executors.newSingleThreadExecutor();
        this.b = v0.g().getPackageManager();
        this.e = da.B().J();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(TaskSimple taskSimple, final BaseViewHolder baseViewHolder) {
        try {
            try {
                final Drawable drawableLoadIcon = this.b.getApplicationInfo(taskSimple.getPn(), 128).loadIcon(this.b);
                l1.e(new Runnable() { // from class: com.adapter.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        baseViewHolder.setImageDrawable(j.b.e.G3, drawableLoadIcon);
                    }
                });
            } catch (Exception e) {
                k0.r(e);
            }
            final boolean z = true;
            final boolean z2 = w7.g().f(taskSimple.getId()) != null;
            l1.e(new Runnable() { // from class: com.adapter.l
                @Override // java.lang.Runnable
                public final void run() {
                    baseViewHolder.setGone(j.b.e.n0, z2);
                }
            });
            List<AlarmTask> listJ = i7.p().j(taskSimple.getId());
            final boolean z3 = (listJ == null || listJ.isEmpty()) ? false : true;
            l1.e(new Runnable() { // from class: com.adapter.o
                @Override // java.lang.Runnable
                public final void run() {
                    baseViewHolder.setGone(j.b.e.Z, z3);
                }
            });
            if (l7.b().a(taskSimple.getId()) == null) {
                z = false;
            }
            l1.e(new Runnable() { // from class: com.adapter.n
                @Override // java.lang.Runnable
                public final void run() {
                    baseViewHolder.setGone(j.b.e.c0, z);
                }
            });
        } catch (Exception e2) {
            y0.l(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void convert(final BaseViewHolder baseViewHolder, final TaskSimple taskSimple) {
        baseViewHolder.setText(j.b.e.n6, taskSimple.getName());
        int i2 = j.b.e.G3;
        baseViewHolder.setImageDrawable(i2, null);
        int i3 = j.b.e.g6;
        baseViewHolder.setGone(i3, taskSimple.getRepeatCount() != 0);
        baseViewHolder.setText(i3, "循环:" + taskSimple.getRepeatCount() + "次");
        if ("group".equals(taskSimple.getPn())) {
            baseViewHolder.setGone(j.b.e.P0, false);
            baseViewHolder.setGone(j.b.e.S0, false);
            baseViewHolder.setGone(j.b.e.n0, false);
            baseViewHolder.setGone(j.b.e.Z, false);
            baseViewHolder.setGone(j.b.e.c0, false);
            baseViewHolder.setGone(j.b.e.q0, true);
            baseViewHolder.setImageResource(i2, j.b.d.K0);
        } else if (!this.c) {
            baseViewHolder.setGone(j.b.e.P0, this.e == taskSimple.getId());
            baseViewHolder.setGone(j.b.e.S0, true);
            baseViewHolder.setGone(j.b.e.q0, false);
            this.a.execute(new Runnable() { // from class: com.adapter.k
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.j(taskSimple, baseViewHolder);
                }
            });
        }
        if (!this.c) {
            baseViewHolder.setGone(j.b.e.k1, false);
            baseViewHolder.addOnClickListener(j.b.e.n0);
            baseViewHolder.addOnClickListener(j.b.e.Z);
            baseViewHolder.addOnClickListener(j.b.e.c0);
            baseViewHolder.addOnClickListener(j.b.e.P0);
            return;
        }
        int i4 = j.b.e.k1;
        baseViewHolder.setVisible(i4, true);
        baseViewHolder.setGone(j.b.e.P0, false);
        baseViewHolder.setGone(j.b.e.S0, false);
        baseViewHolder.setGone(j.b.e.q0, false);
        baseViewHolder.setGone(i2, false);
        baseViewHolder.setGone(j.b.e.c0, false);
        baseViewHolder.setGone(j.b.e.n0, false);
        baseViewHolder.setGone(j.b.e.Z, false);
        baseViewHolder.getView(i4).setSelected(this.d.containsKey(Integer.valueOf(baseViewHolder.getAdapterPosition())));
    }

    public Collection<TaskSimple> d() {
        return this.d.values();
    }

    public void k(boolean z) {
        for (int i2 = 0; i2 < getData().size(); i2++) {
            this.d.put(Integer.valueOf(i2), getItem(i2));
        }
        notifyDataSetChanged();
    }

    public void l(boolean z) {
        this.c = z;
        if (z) {
            this.d = new HashMap<>();
        }
    }

    public void m(int i2) {
        if (this.d.containsKey(Integer.valueOf(i2))) {
            this.d.remove(Integer.valueOf(i2));
        } else {
            this.d.put(Integer.valueOf(i2), getItem(i2));
        }
        notifyItemChanged(i2);
    }
}
