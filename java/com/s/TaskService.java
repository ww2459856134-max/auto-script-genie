package com.s;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.view.View;
import com.frame.k0;
import com.frame.l1;
import com.frame.s0;
import com.frame.v0;
import com.frame.w0;
import com.frame.y0;
import com.permission.x0;
import com.yl.float_ui.DingMsgView;
import com.yl.model.AlarmTask;
import com.yl.model.Task;
import i.b.da;
import i.b.i7;
import i.b.j7;
import java.io.IOException;
import java.util.Calendar;
import org.json.JSONException;

/* loaded from: classes.dex */
public class TaskService extends Service {
    static /* synthetic */ void a(long j2) throws JSONException {
        Task taskL = da.B().L(j2);
        if (taskL == null) {
            y0.j("未找到重启手机触发任务");
        } else {
            y0.j("启动重启手机自动触发任务");
            da.B().b2(taskL, null, j7.a().f(), null, false);
        }
    }

    static /* synthetic */ void e(View view) {
        x0.m().a();
        s0.g().d(DingMsgView.class);
    }

    static /* synthetic */ void f(long j2, AlarmTask alarmTask) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        Task taskL = da.B().L(j2);
        if (taskL != null) {
            y0.o("触发定时任务：" + taskL.getName());
            if (alarmTask != null && !alarmTask.isInterval) {
                i7.p().I(alarmTask.id);
            }
            da.B().D1(da.B().M().alarmTaskSoundFile);
            da.B().A1();
            da.B().f2(taskL);
            if (alarmTask != null && alarmTask.isInterval) {
                i7.p().c(alarmTask);
            }
        } else {
            y0.j("未找到定时任务：" + j2);
        }
        i7.p().e();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    @SuppressLint({"InvalidWakeLockTag"})
    public int onStartCommand(Intent intent, int i2, int i3) throws NumberFormatException {
        if (intent == null) {
            y0.o("TaskService.onStartCommand(intent==null)");
            return super.onStartCommand(intent, i2, i3);
        }
        y0.o("TaskService.onStartCommand");
        final long longExtra = intent.getLongExtra("resetPhoneAT", 0L);
        if (longExtra != 0) {
            l1.g(new Runnable() { // from class: com.s.r
                @Override // java.lang.Runnable
                public final void run() throws JSONException {
                    TaskService.a(longExtra);
                }
            });
            return super.onStartCommand(intent, i2, i3);
        }
        long longExtra2 = intent.getLongExtra("alarmId", 0L);
        final AlarmTask alarmTaskH = longExtra2 != 0 ? i7.p().h(longExtra2) : null;
        if (alarmTaskH == null) {
            alarmTaskH = i7.p().m();
        }
        String stringExtra = intent.getStringExtra("pn");
        if (stringExtra != null && !stringExtra.equals(v0.g().getPackageName())) {
            return super.onStartCommand(intent, i2, i3);
        }
        final long longExtra3 = intent.getLongExtra("taskId", 0L);
        if (alarmTaskH != null) {
            if (!alarmTaskH.isOpen) {
                l1.g(new Runnable() { // from class: com.s.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        i7.p().e();
                    }
                });
                return super.onStartCommand(intent, i2, i3);
            }
            if (alarmTaskH.isInterval) {
                longExtra3 = alarmTaskH.taskId;
            } else {
                if (i7.p().t(alarmTaskH.id, Calendar.getInstance().get(6))) {
                    y0.j("定时，今日已经执行过了，不重复执行了");
                    l1.g(new Runnable() { // from class: com.s.t
                        @Override // java.lang.Runnable
                        public final void run() {
                            i7.p().e();
                        }
                    });
                    return super.onStartCommand(intent, i2, i3);
                }
                longExtra3 = alarmTaskH.taskId;
                i7.p().H(alarmTaskH);
                if (alarmTaskH.isArea) {
                    i7.p().C(alarmTaskH);
                }
            }
        }
        if (longExtra3 == 0) {
            l1.g(new Runnable() { // from class: com.s.p
                @Override // java.lang.Runnable
                public final void run() {
                    i7.p().e();
                }
            });
            return super.onStartCommand(intent, i2, i3);
        }
        if (w0.d()) {
            l1.g(new Runnable() { // from class: com.s.q
                @Override // java.lang.Runnable
                public final void run() throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
                    TaskService.f(longExtra3, alarmTaskH);
                }
            });
            return super.onStartCommand(intent, i2, i3);
        }
        try {
            DingMsgView dingMsgView = (DingMsgView) s0.g().x(DingMsgView.class);
            dingMsgView.l("温馨提示");
            dingMsgView.h("无障碍服务未开启或丢失，自动自行任务无法继续，请先开启无障碍服务~");
            dingMsgView.k("立即开启", new View.OnClickListener() { // from class: com.s.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TaskService.e(view);
                }
            });
            dingMsgView.i("取消", null);
        } catch (Exception e) {
            k0.r(e);
        }
        return super.onStartCommand(intent, i2, i3);
    }
}
