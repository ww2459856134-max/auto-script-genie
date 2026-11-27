package com.v;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.Html;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.k0;
import com.adapter.AlarmAdapter;
import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.v.TaskChooseDialogView;
import com.v.item.ItemWeekChoose;
import com.yl.float_ui.DingMsgView;
import com.yl.model.AlarmTask;
import com.yl.model.Task;
import com.yl.model.TaskSimple;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes.dex */
public class AlarmTaskDialogView extends RelativeLayout implements View.OnClickListener, BaseQuickAdapter.OnItemClickListener, BaseQuickAdapter.OnItemChildClickListener {
    private long c;
    private AlarmAdapter d;
    private boolean e;

    public AlarmTaskDialogView() {
        this(com.frame.v0.g());
    }

    static /* synthetic */ void B(View view) {
        com.frame.s0.g().d(DingMsgView.class);
        com.frame.v0.g().t(new Intent("android.settings.REQUEST_SCHEDULE_EXACT_ALARM", Uri.parse("package:" + com.frame.v0.g().getPackageName())), k0.a.DEFAULT_DRAG_ANIMATION_DURATION);
        com.frame.s0.g().i(AlarmTaskDialogView.class);
        com.frame.s0.g().i(NodeListDialogView.class);
        com.frame.s0.g().i(TaskChooseDialogView.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void D(List list) {
        this.d.setNewData(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F(long j2) {
        final ArrayList arrayList = new ArrayList();
        for (AlarmTask alarmTask : i.b.i7.p().k()) {
            if (alarmTask.taskId == j2) {
                arrayList.add(alarmTask);
            }
        }
        com.frame.l1.e(new Runnable() { // from class: com.v.n
            @Override // java.lang.Runnable
            public final void run() {
                this.c.D(arrayList);
            }
        });
    }

    static /* synthetic */ int K(AlarmTask alarmTask, AlarmTask alarmTask2) {
        return (int) (alarmTask.startTime - alarmTask2.startTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M(TextView textView, TextView textView2, ItemWeekChoose itemWeekChoose, View view) {
        String string = textView.getText().toString();
        String string2 = textView2.getText().toString();
        if (TextUtils.isEmpty(string)) {
            textView.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
            return;
        }
        if (TextUtils.isEmpty(string2)) {
            textView2.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
            return;
        }
        AlarmTask alarmTask = new AlarmTask();
        alarmTask.startTime = com.frame.m1.c("HH:mm", string);
        long jC = com.frame.m1.c("HH:mm", string2);
        alarmTask.endTime = jC;
        if (jC <= alarmTask.startTime) {
            textView2.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
            FloatToast.i("结束时间必须大于开始时间");
            return;
        }
        alarmTask.id = SystemClock.currentThreadTimeMillis();
        alarmTask.taskId = this.c;
        alarmTask.name = i.b.da.B().w(this.c).getName();
        alarmTask.isOpen = true;
        alarmTask.isArea = true;
        alarmTask.repeat = itemWeekChoose.getRepeatWeek();
        List<AlarmTask> listK = i.b.i7.p().k();
        listK.add(alarmTask);
        listK.sort(new Comparator() { // from class: com.v.k0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return AlarmTaskDialogView.K((AlarmTask) obj, (AlarmTask) obj2);
            }
        });
        this.d.addData((AlarmAdapter) alarmTask);
        com.frame.s0.g().d(DingMsgView.class);
        this.e = true;
        try {
            if (System.currentTimeMillis() % 86400000 > alarmTask.endTime) {
                alarmTask.time = com.frame.m1.b(o.a.f.a((int) alarmTask.startTime, (int) r3), "HH:mm");
                i.b.i7.p().b(alarmTask);
            } else {
                alarmTask.time = com.frame.m1.b(o.a.f.a((int) Math.max(alarmTask.startTime, r10), (int) alarmTask.endTime), "HH:mm");
                i.b.i7.p().a(alarmTask);
            }
        } catch (Exception unused) {
            com.frame.v0 v0VarG = com.frame.v0.g();
            int i2 = j.b.a.d;
            textView.startAnimation(AnimationUtils.loadAnimation(v0VarG, i2));
            textView2.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), i2));
            FloatToast.i("设置错误，请检查时间设置");
        }
    }

    static /* synthetic */ int R(AlarmTask alarmTask, AlarmTask alarmTask2) {
        return (int) (alarmTask.startTime - alarmTask2.startTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void T(TextView textView, TextView textView2, EditText editText, ItemWeekChoose itemWeekChoose, AlarmTask alarmTask, View view) throws NumberFormatException {
        String string = textView.getText().toString();
        String string2 = textView2.getText().toString();
        String strTrim = editText.getText().toString().trim();
        if (TextUtils.isEmpty(string)) {
            textView.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
            return;
        }
        if (TextUtils.isEmpty(string2)) {
            textView2.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
            return;
        }
        if (TextUtils.isEmpty(strTrim)) {
            editText.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
            FloatToast.i("请输入执行间隔（分钟）");
            return;
        }
        try {
            long j2 = Long.parseLong(strTrim);
            if (j2 < 1) {
                editText.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                FloatToast.i("执行间隔不能小于1分钟");
                return;
            }
            long j3 = j2 * 60000;
            long jC = com.frame.m1.c("HH:mm", string);
            long jC2 = com.frame.m1.c("HH:mm", string2);
            if (jC2 <= jC) {
                textView2.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                FloatToast.i("结束时间必须大于开始时间");
                return;
            }
            List<Integer> repeatWeek = itemWeekChoose.getRepeatWeek();
            if (repeatWeek == null || repeatWeek.isEmpty()) {
                FloatToast.i("请至少选择一个星期");
                itemWeekChoose.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                return;
            }
            AlarmTask alarmTask2 = alarmTask != null ? alarmTask : new AlarmTask();
            if (alarmTask == null) {
                alarmTask2.id = SystemClock.currentThreadTimeMillis();
                alarmTask2.taskId = this.c;
                alarmTask2.name = i.b.da.B().w(this.c).getName();
                i.b.i7.p().k().add(alarmTask2);
                this.d.addData((AlarmAdapter) alarmTask2);
            } else {
                i.b.i7.p().B(alarmTask2.id);
            }
            alarmTask2.startTime = jC;
            alarmTask2.endTime = jC2;
            alarmTask2.intervalMs = j3;
            alarmTask2.isInterval = true;
            alarmTask2.isArea = false;
            alarmTask2.isOpen = true;
            alarmTask2.isSingleLoop = false;
            alarmTask2.repeat = repeatWeek;
            i.b.i7.p().s(alarmTask2);
            if (alarmTask2.nextFireAt > 0) {
                i.b.i7.p().k().sort(new Comparator() { // from class: com.v.j0
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return AlarmTaskDialogView.R((AlarmTask) obj, (AlarmTask) obj2);
                    }
                });
                this.d.notifyDataSetChanged();
                com.frame.s0.g().d(DingMsgView.class);
                this.e = true;
                i.b.i7.p().d();
                return;
            }
            FloatToast.i("当前设置的时间区间内没有可执行的定时");
            if (alarmTask == null) {
                i.b.i7.p().k().remove(alarmTask2);
                int iIndexOf = this.d.getData().indexOf(alarmTask2);
                if (iIndexOf >= 0) {
                    this.d.remove(iIndexOf);
                }
            }
        } catch (Exception unused) {
            editText.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
            FloatToast.i("请输入正确的间隔分钟数");
        }
    }

    static /* synthetic */ void V(TextView textView, TimeWeekPick timeWeekPick, View view) {
        textView.setText(timeWeekPick.getSelectedTime());
        com.frame.s0.g().d(DingMsgView1.class);
    }

    static /* synthetic */ int X(AlarmTask alarmTask, AlarmTask alarmTask2) {
        return (int) (alarmTask.startTime - alarmTask2.startTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Z(AlarmTask alarmTask, TimeWeekPick timeWeekPick) throws NumberFormatException {
        AlarmTask alarmTask2;
        if (alarmTask == null) {
            alarmTask2 = new AlarmTask();
            alarmTask2.id = SystemClock.currentThreadTimeMillis();
        } else {
            i.b.i7.p().B(alarmTask.id);
            alarmTask2 = alarmTask;
        }
        String selectedTime = timeWeekPick.getSelectedTime();
        alarmTask2.time = selectedTime;
        alarmTask2.startTime = com.frame.m1.c("HH:mm", selectedTime);
        alarmTask2.taskId = this.c;
        alarmTask2.name = i.b.da.B().w(this.c).getName();
        alarmTask2.isOpen = true;
        alarmTask2.repeat = timeWeekPick.getRepeatWeek();
        List<AlarmTask> listK = i.b.i7.p().k();
        if (alarmTask != alarmTask2) {
            listK.add(alarmTask2);
            this.d.addData((AlarmAdapter) alarmTask2);
        } else {
            this.d.notifyDataSetChanged();
        }
        listK.sort(new Comparator() { // from class: com.v.g0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return AlarmTaskDialogView.X((AlarmTask) obj, (AlarmTask) obj2);
            }
        });
        com.frame.s0.g().d(DingMsgView.class);
        this.e = true;
        if (com.frame.n0.a("alarmCalendar", true)) {
            a(alarmTask2);
        }
        if (com.frame.n0.a("alarmClock", false)) {
            b(alarmTask2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b0(final AlarmTask alarmTask, final TimeWeekPick timeWeekPick, View view) {
        d0(new Runnable() { // from class: com.v.b0
            @Override // java.lang.Runnable
            public final void run() throws NumberFormatException {
                this.c.Z(alarmTask, timeWeekPick);
            }
        });
    }

    private View c() {
        View viewInflate = View.inflate(com.frame.v0.g(), j.b.f.z0, null);
        ((TextView) viewInflate.findViewById(j.b.e.v6)).setText("设置解锁手势");
        final TextView textView = (TextView) viewInflate.findViewById(j.b.e.g6);
        Long lValueOf = Long.valueOf(i.b.i7.p().q());
        Task taskL = lValueOf.longValue() != 0 ? i.b.da.B().L(lValueOf.longValue()) : null;
        final ImageView imageView = (ImageView) viewInflate.findViewById(j.b.e.O0);
        if (taskL != null) {
            textView.setVisibility(0);
            textView.setText(taskL.getName());
            textView.setTextColor(com.frame.v0.g().getColor(j.b.c.e));
            imageView.setVisibility(8);
        } else {
            imageView.setImageResource(j.b.d.L0);
            imageView.setImageTintList(null);
            imageView.setImageTintMode(null);
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.v.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AlarmTaskDialogView.e(view);
            }
        });
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.v.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AlarmTaskDialogView.g(textView, imageView, view);
            }
        });
        if (taskL == null) {
            viewInflate.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
        }
        return viewInflate;
    }

    private void d() {
        View.inflate(com.frame.v0.g(), j.b.f.f, this);
        setGravity(17);
        this.d = new AlarmAdapter(null);
        RecyclerView recyclerView = (RecyclerView) findViewById(j.b.e.O4);
        recyclerView.setLayoutManager(new LinearLayoutManager(com.frame.v0.g()));
        recyclerView.setAdapter(this.d);
        findViewById(j.b.e.P).setOnClickListener(this);
        int i2 = j.b.e.g;
        findViewById(i2).setOnClickListener(this);
        findViewById(i2).setVisibility(8);
        int i3 = j.b.e.X;
        findViewById(i3).setVisibility(0);
        findViewById(i3).setOnClickListener(this);
        View viewFindViewById = findViewById(j.b.e.J0);
        viewFindViewById.setOnClickListener(this);
        viewFindViewById.setVisibility(0);
        viewFindViewById.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
        TextView textView = (TextView) findViewById(j.b.e.i0);
        textView.setVisibility(0);
        textView.setBackground(null);
        textView.setText("随机定时");
        textView.setOnClickListener(this);
        textView.setTextColor(-7829368);
        textView.setBackgroundColor(getResources().getColor(j.b.c.a));
        TextView textView2 = (TextView) findViewById(j.b.e.w0);
        textView2.setVisibility(0);
        textView2.setOnClickListener(this);
        this.d.setOnItemChildClickListener(this);
        this.d.setOnItemClickListener(this);
        TextView textView3 = new TextView(com.frame.v0.g());
        textView3.setText("还未添加定时~");
        textView3.setGravity(17);
        textView3.setTextColor(com.frame.v0.g().getResources().getColor(j.b.c.d));
        this.d.setEmptyView(textView3);
        this.d.addHeaderView(c());
    }

    private void d0(Runnable runnable) {
        if (Build.VERSION.SDK_INT < 31) {
            runnable.run();
            return;
        }
        if (((AlarmManager) com.frame.v0.g().getSystemService("alarm")).canScheduleExactAlarms()) {
            runnable.run();
            return;
        }
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.l("温馨提示");
        dingMsgView.h("定时执行任务需要开启「闹钟和提醒」精确闹钟权限，否则定时可能无法准时触发，是否前往开启？");
        dingMsgView.k("去开启", new View.OnClickListener() { // from class: com.v.l0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AlarmTaskDialogView.B(view);
            }
        });
        dingMsgView.i("取消", null);
    }

    static /* synthetic */ void e(View view) {
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.h("定时自动执行，当锁屏待机状态无法执行操作，需要先执行解锁操作才能自动完成当前任务，请先录制并选择解锁操作。");
        dingMsgView.i("知道了", null);
    }

    static /* synthetic */ void f(TextView textView, ImageView imageView, TaskSimple taskSimple) {
        i.b.i7.p().J(Long.valueOf(taskSimple.getId()));
        textView.setVisibility(0);
        imageView.setVisibility(8);
        textView.setText(i.b.da.B().L(taskSimple.getId()).getName());
        com.frame.s0.g().d(TaskChooseDialogView.class);
        com.yl.ui.i0.l(null);
    }

    static /* synthetic */ void g(final TextView textView, final ImageView imageView, View view) {
        FloatToast.i(Html.fromHtml("请选择<font color='#F45075'>解锁手势</font>任务"));
        com.frame.s0.g().d(TaskChooseDialogView.class);
        TaskChooseDialogView.show().setOnChooseListener(new TaskChooseDialogView.b() { // from class: com.v.o
            @Override // com.v.TaskChooseDialogView.b
            public final void a(TaskSimple taskSimple) {
                AlarmTaskDialogView.f(textView, imageView, taskSimple);
            }
        });
    }

    static /* synthetic */ void h(i.a.l lVar) {
        lVar.d();
        com.frame.s0.g().d(DingMsgView.class);
        com.frame.s0.g().i(AlarmTaskDialogView.class);
        com.frame.s0.g().i(NodeListDialogView.class);
        com.frame.s0.g().i(TaskChooseDialogView.class);
    }

    static /* synthetic */ void i(final i.a.l lVar, View view) throws PendingIntent.CanceledException {
        com.frame.i0.n(com.frame.v0.g().getPackageName());
        com.frame.l1.f(new Runnable() { // from class: com.v.d
            @Override // java.lang.Runnable
            public final void run() {
                AlarmTaskDialogView.h(lVar);
            }
        }, 800L);
    }

    static /* synthetic */ void j(final i.a.l lVar, View view) {
        if (lVar.i()) {
            view.setSelected(!view.isSelected());
            com.frame.n0.g("alarmCalendar", view.isSelected());
            return;
        }
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.h("请先开启日历权限，使用日历权限服务唤醒屏幕（亮屏）达到自动定时执行的效果。");
        TextView textView = new TextView(com.frame.v0.g());
        textView.setTextColor(Color.parseColor("#999999"));
        textView.setText("已经开过了，不再提示");
        textView.setPadding(com.frame.p1.c(25.0f), com.frame.p1.c(15.0f), 0, com.frame.p1.c(5.0f));
        textView.setTextSize(12.0f);
        textView.setCompoundDrawablePadding(com.frame.p1.c(5.0f));
        textView.setCompoundDrawablesWithIntrinsicBounds(j.b.d.J0, 0, 0, 0);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.v.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AlarmTaskDialogView.w(view2);
            }
        });
        dingMsgView.m(textView);
        dingMsgView.k("开启", new View.OnClickListener() { // from class: com.v.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) throws PendingIntent.CanceledException {
                AlarmTaskDialogView.i(lVar, view2);
            }
        });
        dingMsgView.i("取消", null);
    }

    static /* synthetic */ void k(AlarmManager alarmManager, View view) {
        if (Build.VERSION.SDK_INT < 31 || alarmManager.canScheduleExactAlarms()) {
            view.setSelected(!view.isSelected());
            com.frame.n0.g("alarmClock", view.isSelected());
            return;
        }
        com.frame.v0.g().t(new Intent("android.settings.REQUEST_SCHEDULE_EXACT_ALARM", Uri.parse("package:" + com.frame.v0.g().getPackageName())), k0.a.DEFAULT_DRAG_ANIMATION_DURATION);
        com.frame.s0.g().d(DingMsgView.class);
        com.frame.s0.g().i(AlarmTaskDialogView.class);
        com.frame.s0.g().i(NodeListDialogView.class);
        com.frame.s0.g().i(TaskChooseDialogView.class);
    }

    static /* synthetic */ void l(View view) {
        com.frame.s0.g().d(DingMsgView.class);
        com.frame.n0.g("alreadyCalendar", true);
    }

    static /* synthetic */ void m(i.a.l lVar) {
        lVar.d();
        com.frame.s0.g().d(DingMsgView.class);
        com.frame.s0.g().i(AlarmTaskDialogView.class);
        com.frame.s0.g().i(NodeListDialogView.class);
        com.frame.s0.g().i(TaskChooseDialogView.class);
    }

    static /* synthetic */ void n(final i.a.l lVar, View view) throws PendingIntent.CanceledException {
        com.frame.i0.n(com.frame.v0.g().getPackageName());
        com.frame.l1.f(new Runnable() { // from class: com.v.s
            @Override // java.lang.Runnable
            public final void run() {
                AlarmTaskDialogView.m(lVar);
            }
        }, 800L);
    }

    static /* synthetic */ void o(View view) {
        com.frame.n0.g("alarmCalendar", false);
        com.frame.s0.g().d(DingMsgView1.class);
    }

    static /* synthetic */ void p(View view) {
        com.frame.s0.g().d(DingMsgView.class);
        DingMsgView1 dingMsgView1 = (DingMsgView1) com.frame.s0.g().x(DingMsgView1.class);
        dingMsgView1.h("是否确定关闭日历辅助功能？");
        dingMsgView1.k("关闭", new View.OnClickListener() { // from class: com.v.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AlarmTaskDialogView.o(view2);
            }
        });
        dingMsgView1.i("取消", null);
    }

    static /* synthetic */ void q(View view) {
        com.permission.x0.m().g();
        com.frame.s0.g().d(DingMsgView.class);
        com.frame.s0.g().d(AlarmTaskDialogView.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s() throws NumberFormatException {
        h0(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u() {
        z(null);
    }

    static /* synthetic */ void v(View view) {
        com.frame.s0.g().d(DingMsgView.class);
        com.permission.x0.m().h();
    }

    static /* synthetic */ void w(View view) {
        com.frame.s0.g().d(DingMsgView.class);
        com.frame.n0.g("alreadyCalendar", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y(AlarmTask alarmTask) throws NumberFormatException {
        alarmTask.isOpen = true;
        if (alarmTask.isInterval) {
            i.b.i7.p().s(alarmTask);
            i.b.i7.p().d();
        } else {
            a(alarmTask);
        }
        this.d.notifyDataSetChanged();
        i.b.i7.p().D();
    }

    public void a(AlarmTask alarmTask) throws NumberFormatException {
        try {
            String[] strArrSplit = alarmTask.time.split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
            int i2 = Integer.parseInt(strArrSplit[0]);
            int i3 = Integer.parseInt(strArrSplit[1]);
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, i2);
            calendar.set(12, i3);
            calendar.set(13, 0);
            long timeInMillis = calendar.getTimeInMillis();
            calendar.add(1, 1);
            long timeInMillis2 = calendar.getTimeInMillis();
            String str = "定时任务：" + alarmTask.name;
            new i.a.l().c(str, alarmTask.id + "", timeInMillis, timeInMillis2, alarmTask.repeat);
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    public void b(AlarmTask alarmTask) {
        if (androidx.core.content.a.a(com.frame.v0.g(), "com.android.alarm.permission.SET_ALARM") != 0) {
            return;
        }
        try {
            Calendar calendar = Calendar.getInstance();
            String[] strArrSplit = alarmTask.time.split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
            calendar.set(11, Integer.parseInt(strArrSplit[0]));
            calendar.set(12, Integer.parseInt(strArrSplit[1]));
            calendar.set(13, 0);
            Intent intent = new Intent("android.intent.action.SET_ALARM");
            intent.putExtra("android.intent.extra.alarm.MESSAGE", alarmTask.name);
            intent.putExtra("android.intent.extra.alarm.HOUR", calendar.get(11));
            intent.putExtra("android.intent.extra.alarm.MINUTES", calendar.get(12));
            intent.putExtra("android.intent.extra.alarm.SKIP_UI", true);
            if (Build.VERSION.SDK_INT >= 19) {
                intent.putIntegerArrayListExtra("android.intent.extra.alarm.DAYS", (ArrayList) alarmTask.repeat);
            }
            intent.addFlags(268435456);
            com.frame.v0.g().startActivity(intent);
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    public void c0(AlarmTask alarmTask) {
        try {
            new i.a.l().h(alarmTask.id + "");
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    public void e0() {
        View viewInflate = View.inflate(com.frame.v0.g(), j.b.f.B0, null);
        final TextView textView = (TextView) viewInflate.findViewById(j.b.e.T5);
        final TextView textView2 = (TextView) viewInflate.findViewById(j.b.e.B5);
        final ItemWeekChoose itemWeekChoose = (ItemWeekChoose) viewInflate.findViewById(j.b.e.K4);
        itemWeekChoose.setRepeatWeek(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.v.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws NumberFormatException {
                this.c.H(view);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.v.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws NumberFormatException {
                this.c.J(view);
            }
        });
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.h("随机定时，用于在一个时间区间内，随机获取一个时间作为定时启动脚本的时间。");
        dingMsgView.m(viewInflate);
        dingMsgView.k("确定", new View.OnClickListener() { // from class: com.v.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.M(textView, textView2, itemWeekChoose, view);
            }
        });
        dingMsgView.i("取消", null);
    }

    /* renamed from: f0, reason: merged with bridge method [inline-methods] */
    public void A(final AlarmTask alarmTask) {
        View viewInflate = View.inflate(com.frame.v0.g(), j.b.f.J0, null);
        final TextView textView = (TextView) viewInflate.findViewById(j.b.e.T5);
        final TextView textView2 = (TextView) viewInflate.findViewById(j.b.e.B5);
        final EditText editText = (EditText) viewInflate.findViewById(j.b.e.M1);
        editText.setInputType(2);
        final ItemWeekChoose itemWeekChoose = (ItemWeekChoose) viewInflate.findViewById(j.b.e.K4);
        if (alarmTask != null) {
            textView.setText(alarmTask.getStartTimeStr());
            textView2.setText(alarmTask.getEndTimeStr());
            long j2 = alarmTask.intervalMs;
            if (j2 > 0) {
                editText.setText(String.valueOf(j2 / 60000));
            }
            List<Integer> list = alarmTask.repeat;
            if (list == null || list.isEmpty()) {
                itemWeekChoose.setRepeatWeek(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
            } else {
                itemWeekChoose.setRepeatWeek(alarmTask.repeat);
            }
        } else {
            itemWeekChoose.setRepeatWeek(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.v.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws NumberFormatException {
                this.c.O(view);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.v.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws NumberFormatException {
                this.c.Q(view);
            }
        });
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().B(DingMsgView.class);
        dingMsgView.l("区间定时");
        dingMsgView.m(viewInflate);
        dingMsgView.k("确定", new View.OnClickListener() { // from class: com.v.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws NumberFormatException {
                this.c.T(textView, textView2, editText, itemWeekChoose, alarmTask, view);
            }
        });
        dingMsgView.i("取消", null);
    }

    /* renamed from: g0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void Q(final TextView textView) throws NumberFormatException {
        final TimeWeekPick timeWeekPick = new TimeWeekPick(com.frame.v0.g());
        timeWeekPick.a();
        timeWeekPick.setDefaultValue(com.frame.m1.b(System.currentTimeMillis(), "HH:mm"), null);
        DingMsgView1 dingMsgView1 = (DingMsgView1) com.frame.s0.g().x(DingMsgView1.class);
        dingMsgView1.l("选择时间");
        dingMsgView1.m(timeWeekPick);
        dingMsgView1.i("取消", new View.OnClickListener() { // from class: com.v.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.frame.s0.g().d(DingMsgView1.class);
            }
        });
        dingMsgView1.k("确定", new View.OnClickListener() { // from class: com.v.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AlarmTaskDialogView.V(textView, timeWeekPick, view);
            }
        });
    }

    public void h0(final AlarmTask alarmTask) throws NumberFormatException {
        final TimeWeekPick timeWeekPick = new TimeWeekPick(com.frame.v0.g());
        timeWeekPick.a();
        if (alarmTask == null || TextUtils.isEmpty(alarmTask.time)) {
            timeWeekPick.setDefaultValue(com.frame.m1.b(System.currentTimeMillis(), "HH:mm"), Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        } else {
            timeWeekPick.setDefaultValue(alarmTask.time, alarmTask.repeat);
        }
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.l("选择时间");
        dingMsgView.m(timeWeekPick);
        dingMsgView.i("取消", new View.OnClickListener() { // from class: com.v.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.frame.s0.g().d(DingMsgView.class);
            }
        });
        dingMsgView.k("确定", new View.OnClickListener() { // from class: com.v.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.b0(alarmTask, timeWeekPick, view);
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == j.b.e.P) {
            com.frame.s0.g().d(AlarmTaskDialogView.class);
            return;
        }
        if (id == j.b.e.i0) {
            d0(new ct(this));
            return;
        }
        if (id == j.b.e.w0) {
            d0(new Runnable() { // from class: com.v.p
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.u();
                }
            });
            return;
        }
        if (id == j.b.e.J0) {
            DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
            dingMsgView.h("定时自动执行，部分手机由于系统厂家高度定制系统的原因，可能导致定时到点时无法从黑屏唤起任务，这是可以使用日历通知或者闹钟辅助唤醒屏幕达到自动定时执行的效果，日历权限需要在app设置管理中的权限设置中开启。\n注意：此方法需要在开启权限后再添加定时任务才有效。");
            dingMsgView.i("知道了", null);
            View viewInflate = View.inflate(com.frame.v0.g(), j.b.f.i1, null);
            dingMsgView.m(viewInflate);
            final i.a.l lVar = new i.a.l();
            if (lVar.i() && com.frame.n0.a("alarmCalendar", true)) {
                viewInflate.findViewById(j.b.e.f1752k).setSelected(true);
            }
            if (com.permission.x0.m().r()) {
                viewInflate.findViewById(j.b.e.G).setSelected(true);
            }
            viewInflate.findViewById(j.b.e.G).setOnClickListener(new View.OnClickListener() { // from class: com.v.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AlarmTaskDialogView.v(view2);
                }
            });
            viewInflate.findViewById(j.b.e.f1752k).setOnClickListener(new View.OnClickListener() { // from class: com.v.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AlarmTaskDialogView.j(lVar, view2);
                }
            });
            final AlarmManager alarmManager = (AlarmManager) com.frame.v0.g().getSystemService("alarm");
            if ((Build.VERSION.SDK_INT < 31 || alarmManager.canScheduleExactAlarms()) && com.frame.n0.a("alarmClock", false)) {
                viewInflate.findViewById(j.b.e.f1750i).setSelected(true);
            }
            viewInflate.findViewById(j.b.e.f1750i).setOnClickListener(new View.OnClickListener() { // from class: com.v.h0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AlarmTaskDialogView.k(alarmManager, view2);
                }
            });
            return;
        }
        if (id != j.b.e.g && id == j.b.e.X) {
            final i.a.l lVar2 = new i.a.l();
            if (com.frame.n0.a("alarmCalendar", true) && !com.frame.n0.a("alreadyCalendar", false) && !lVar2.i()) {
                DingMsgView dingMsgView2 = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
                dingMsgView2.h("请先开启日历权限，使用日历通知辅助唤醒屏幕（亮屏）达到自动定时执行的效果。");
                TextView textView = new TextView(com.frame.v0.g());
                textView.setTextColor(Color.parseColor("#999999"));
                textView.setText("已经开过了，不再提示");
                textView.setPadding(com.frame.p1.c(25.0f), com.frame.p1.c(15.0f), 0, com.frame.p1.c(5.0f));
                textView.setTextSize(12.0f);
                textView.setCompoundDrawablePadding(com.frame.p1.c(5.0f));
                textView.setCompoundDrawablesWithIntrinsicBounds(j.b.d.J0, 0, 0, 0);
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.v.i0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        AlarmTaskDialogView.l(view2);
                    }
                });
                dingMsgView2.m(textView);
                dingMsgView2.k("开启", new View.OnClickListener() { // from class: com.v.g
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) throws PendingIntent.CanceledException {
                        AlarmTaskDialogView.n(lVar2, view2);
                    }
                });
                dingMsgView2.i("取消", null);
                return;
            }
            if (!com.frame.n0.a("alarmCalendar", true) || !lVar2.i() || com.permission.x0.m().r()) {
                d0(new Runnable() { // from class: com.v.v
                    @Override // java.lang.Runnable
                    public final void run() throws NumberFormatException {
                        this.c.s();
                    }
                });
                return;
            }
            DingMsgView dingMsgView3 = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
            TextView textView2 = new TextView(com.frame.v0.g());
            textView2.setTextColor(Color.parseColor("#999999"));
            textView2.setText("关闭日历辅助功能");
            textView2.setPadding(com.frame.p1.c(25.0f), com.frame.p1.c(15.0f), 0, com.frame.p1.c(5.0f));
            textView2.setTextSize(12.0f);
            textView2.setCompoundDrawablePadding(com.frame.p1.c(5.0f));
            textView2.setCompoundDrawablesWithIntrinsicBounds(j.b.d.J0, 0, 0, 0);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.v.e0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AlarmTaskDialogView.p(view2);
                }
            });
            dingMsgView3.m(textView2);
            dingMsgView3.h("日历辅助功能需要用到读取通知栏权限才能监听到日历并触发定时任务。");
            dingMsgView3.k("开启", new View.OnClickListener() { // from class: com.v.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AlarmTaskDialogView.q(view2);
                }
            });
            dingMsgView3.i("取消", null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.e) {
            i.b.i7.p().E(i.b.i7.p().k());
            i.b.i7.p().d();
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemChildClickListener
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (view.getId() == j.b.e.i1) {
            final AlarmTask item = this.d.getItem(i2);
            if (!item.isOpen) {
                d0(new Runnable() { // from class: com.v.i
                    @Override // java.lang.Runnable
                    public final void run() throws NumberFormatException {
                        this.c.y(item);
                    }
                });
                return;
            }
            item.isOpen = false;
            if (!item.isInterval) {
                c0(item);
            }
            this.d.notifyDataSetChanged();
            i.b.i7.p().D();
            i.b.i7.p().e();
            return;
        }
        if (view.getId() == j.b.e.O0) {
            AlarmTask item2 = this.d.getItem(i2);
            i.b.i7.p().k().remove(item2);
            if (item2.isInterval) {
                i.b.i7.p().e();
            } else {
                c0(item2);
            }
            this.d.remove(i2);
            this.e = true;
            i.b.i7.p().D();
            i.b.i7.p().e();
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) throws NumberFormatException {
        final AlarmTask item = this.d.getItem(i2);
        if (item.isInterval) {
            d0(new Runnable() { // from class: com.v.y
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.A(item);
                }
            });
        } else if (item.isArea) {
            d0(new ct(this));
        } else {
            h0(item);
        }
    }

    public void setTaskId(final long j2) {
        this.c = j2;
        com.frame.l1.g(new Runnable() { // from class: com.v.q
            @Override // java.lang.Runnable
            public final void run() {
                this.c.F(j2);
            }
        });
    }

    public AlarmTaskDialogView(Context context) {
        this(context, null);
    }

    public AlarmTaskDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d();
    }
}
