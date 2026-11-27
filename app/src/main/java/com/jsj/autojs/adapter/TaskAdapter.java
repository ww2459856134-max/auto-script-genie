package com.jsj.autojs.adapter;

import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.frame.l1;
import com.frame.m1;
import com.frame.v0;
import com.tencent.cursor.R;
import com.yl.model.TaskSimple;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class TaskAdapter extends BaseItemDraggableAdapter<TaskSimple, BaseViewHolder> {
    private boolean a;
    private ExecutorService b;

    public TaskAdapter(List<TaskSimple> list) {
        super(2131493089, list);
        this.b = Executors.newSingleThreadExecutor();
    }

    static /* synthetic */ void e(TaskSimple taskSimple, final BaseViewHolder baseViewHolder) {
        try {
            PackageManager packageManager = v0.g().getPackageManager();
            final Drawable drawableLoadIcon = packageManager.getApplicationInfo(taskSimple.getPn(), 128).loadIcon(packageManager);
            l1.e(new Runnable() { // from class: com.jsj.autojs.adapter.d
                @Override // java.lang.Runnable
                public final void run() {
                    baseViewHolder.setImageDrawable(R.id.iv_icon, drawableLoadIcon);
                }
            });
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void convert(final BaseViewHolder baseViewHolder, final TaskSimple taskSimple) {
        if ("group".equals(taskSimple.getPn())) {
            baseViewHolder.setGone(2131296525, false);
            baseViewHolder.setGone(2131296507, false);
            baseViewHolder.setText(2131297255, taskSimple.getName());
            baseViewHolder.setText(2131297218, "脚本文件夹");
            baseViewHolder.setImageResource(R.id.iv_icon, 2131230923);
            baseViewHolder.addOnClickListener(2131296507).addOnClickListener(2131296452).addOnClickListener(2131296426).addOnClickListener(2131296501).addOnClickListener(2131297255).addOnClickListener(2131296523).addOnClickListener(2131297274).addOnClickListener(2131297273).addOnClickListener(2131296447);
            return;
        }
        this.b.execute(new Runnable() { // from class: com.jsj.autojs.adapter.c
            @Override // java.lang.Runnable
            public final void run() {
                TaskAdapter.e(taskSimple, baseViewHolder);
            }
        });
        if (this.a) {
            baseViewHolder.setGone(2131296525, true);
            baseViewHolder.setGone(2131296507, false);
            baseViewHolder.setGone(2131296447, false);
            baseViewHolder.setGone(2131296523, true);
        } else {
            baseViewHolder.setGone(2131296525, false);
            baseViewHolder.setGone(2131296507, true);
            baseViewHolder.setGone(2131296447, true);
            baseViewHolder.setGone(2131296523, true);
        }
        baseViewHolder.setText(2131297218, "编辑时间：" + m1.b(taskSimple.updateTime, "yyyy-MM-dd HH:mm"));
        baseViewHolder.setText(2131297255, taskSimple.getName());
        baseViewHolder.setText(2131297274, "循环间隔：" + taskSimple.getRepeatDelay() + "ms");
        StringBuilder sb = new StringBuilder();
        sb.append("循环次数：");
        sb.append(taskSimple.getRepeatCount());
        baseViewHolder.setText(2131297273, sb.toString());
        baseViewHolder.addOnClickListener(2131296507).addOnClickListener(2131296452).addOnClickListener(2131296426).addOnClickListener(2131296501).addOnClickListener(2131297255).addOnClickListener(2131296523).addOnClickListener(2131297274).addOnClickListener(2131297273).addOnClickListener(2131296447);
    }
}
